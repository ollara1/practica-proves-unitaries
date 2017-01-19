package kiosk;


import data.IrisScan;
import data.MailAddress;
import data.Signature;
import data.Vote;
import services.*;


/**
 * Implements a simplification of Use Case: Emit Vote
 */
public class VotingMachine {

    private ValidationService validationService;
    private VotePrinter votePrinter;
    private VotesDB votesDB;
    private SignatureService signatureService;
    private MailerService mailerService;
    private IrisScanner irisScanner;
    private boolean exist;

    private ActivationCard activeCard = null;
    private Vote activeVote = null;

    public VotingMachine() {
        exist = false;

    }

    public void setValidationService(ValidationService validationService) {
        this.validationService = validationService;
    }

    public void setVotePrinter(VotePrinter votePrinter) {
        this.votePrinter = votePrinter;

    }

    public void setVotesDB(VotesDB votesDB) {
        this.votesDB = votesDB;

    }

    public void setSignatureService(SignatureService signatureService) {
        this.signatureService = signatureService;
    }

    public void setMailerService(MailerService mailerService) {
        this.mailerService = mailerService;
    }

    public void setIrisScanner(IrisScanner irisScanner) {
        this.irisScanner = irisScanner;
    }

    public void activateEmission(ActivationCard card) throws IllegalStateException {

        if (exist == true) {//miramos si esta creada la maquina
            throw new IllegalStateException();
        } else {
            if (validationService.validate(card) == true) {//miramos si esta activada
                this.exist = true;//creamos la maquina
                this.activeCard = card;
                this.activeVote = null;
                if (card.getIrisScan() != null) {
                    IrisScan irisScan = this.irisScanner.scan();
                    if (!irisScan.equals(card.getIrisScan())) {
                        this.exist = false;
                        this.activeCard = null;
                    }
                }
            }
        }

    }

    public boolean canVote() {
        return exist == true;


    }

    public void vote(Vote vote) throws IllegalStateException {
        if (!this.exist) throw new IllegalStateException();

        if (this.canVote()) {
            this.votesDB.registerVote(vote);
            this.votePrinter.print(vote);
            this.activeCard.erase();
            this.exist = false;
            this.activeVote = vote;
        }
    }

    public void sendReceipt(MailAddress address) throws IllegalStateException {
        if (this.activeVote == null) throw new IllegalStateException();

        final Signature signature = this.signatureService.sign(this.activeVote);
        this.mailerService.send(address, signature);
    }

}