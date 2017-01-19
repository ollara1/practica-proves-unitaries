import kiosk.ActivationCard;
import org.junit.Assert;
import org.junit.Test;

public class ActivationCardTest {

    @Test
    public void testCreateCard() {//testeamos que podemos crear una card
        ActivationCard card = new ActivationCard("myCode");
        Assert.assertTrue(card.isActive());
    }

    @Test
    public void testEraseCard() {//testeamos que podemos borrar una card
        ActivationCard card = new ActivationCard("myCode");
        card.erase();
        Assert.assertFalse(card.isActive());
    }

    @Test
    public void testEquals() {//testeamos que el metodo equals funciona
        ActivationCard card = new ActivationCard("myCode");
        ActivationCard card2 = new ActivationCard("myCode");
        Assert.assertTrue(card.equals(card2));

    }


}
