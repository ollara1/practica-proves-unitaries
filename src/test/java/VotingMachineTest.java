import data.Vote;
import kiosk.ActivationCard;
import kiosk.VotingMachine;
import org.junit.Assert;
import org.junit.Test;
import services.ValidationService;
import services.VotesDB;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ollara on 19/01/2017.
 */
public class VotingMachineTest {

    @Test
    public void testCanActive() {
        VotingMachine vm = new VotingMachine();
        vm.setValidationService(new ValidationService() {
            @Override
            public boolean validate(ActivationCard card) {
                return card.isActive();
            }

            @Override
            public void deactivate(ActivationCard card) {
                card.erase();
            }
        });

        Assert.assertFalse(vm.canVote());
        ActivationCard ac = new ActivationCard("ayyLmao");
        vm.activateEmission(ac);
        Assert.assertTrue(vm.canVote());
    }

    @Test
    public void testTryActiveWithInvalid() {
        VotingMachine vm = new VotingMachine();
        vm.setValidationService(new ValidationService() {
            @Override
            public boolean validate(ActivationCard card) {
                return card.isActive();
            }

            @Override
            public void deactivate(ActivationCard card) {
                card.erase();
            }
        });

        Assert.assertFalse(vm.canVote());
        ActivationCard ac = new ActivationCard("ayyLmao");
        ac.erase();
        vm.activateEmission(ac);
        Assert.assertFalse(vm.canVote());
    }

    @Test(expected = IllegalStateException.class)
    public void activeThrowsExcepion() {
        VotingMachine vm = new VotingMachine();
        vm.setValidationService(new ValidationService() {
            @Override
            public boolean validate(ActivationCard card) {
                return card.isActive();
            }

            @Override
            public void deactivate(ActivationCard card) {
                card.erase();
            }
        });

        Assert.assertFalse(vm.canVote());
        ActivationCard ac = new ActivationCard("ayyLmao");
        vm.activateEmission(ac);
        Assert.assertTrue(vm.canVote());
        vm.activateEmission(new ActivationCard("cualsevol"));
    }

    @Test
    public void testVote() {
        VotingMachine vm = new VotingMachine();
        vm.setValidationService(new ValidationService() {
            @Override
            public boolean validate(ActivationCard card) {
                return card.isActive();
            }

            @Override
            public void deactivate(ActivationCard card) {
                card.erase();
            }
        });
        VotesDB vdb = new VotesDB() {
            private List<Vote> innerList = new LinkedList<Vote>();

            @Override
            public void registerVote(Vote vote) {
                this.innerList.add(vote);
            }

            @Override
            public List<Vote> getVotes() {
                return this.innerList;
            }
        };
        vm.setVotesDB(vdb);
        vm.setVotePrinter(vote -> System.out.println(vote.toString()));

        Assert.assertFalse(vm.canVote());
        ActivationCard ac = new ActivationCard("ayyLmao");
        vm.activateEmission(ac);
        Assert.assertTrue(vm.canVote());

        Vote vote = new Vote("ayyLmaoVote");
        vm.vote(vote);

        Assert.assertEquals(
                vdb.getVotes().get(0),
                vote
        );
    }

    @Test(expected = IllegalStateException.class)
    public void testVoteFail() {
        VotingMachine vm = new VotingMachine();
        vm.setValidationService(new ValidationService() {
            @Override
            public boolean validate(ActivationCard card) {
                return card.isActive();
            }

            @Override
            public void deactivate(ActivationCard card) {
                card.erase();
            }
        });
        VotesDB vdb = new VotesDB() {
            private List<Vote> innerList = new LinkedList<Vote>();

            @Override
            public void registerVote(Vote vote) {
                this.innerList.add(vote);
            }

            @Override
            public List<Vote> getVotes() {
                return this.innerList;
            }
        };
        vm.setVotesDB(vdb);
        vm.setVotePrinter(vote -> System.out.println(vote.toString()));

        Assert.assertFalse(vm.canVote());
        ActivationCard ac = new ActivationCard("ayyLmao");

        Vote vote = new Vote("ayyLmaoVote");
        vm.vote(vote);
    }
}
