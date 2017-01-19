import kiosk.ActivationCard;
import kiosk.VotingMachine;
import org.junit.Assert;
import org.junit.Test;
import services.ValidationService;

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
}
