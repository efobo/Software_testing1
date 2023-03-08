package test_task3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import task3.Ghost;
import task3.Human;
import task3.Place;
import task3.Shadow;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ShadowTest {

    @Test
    public void Constructor_NoExcept() {
        new Shadow("Cornel", Place.GLOOMY_PLACE, 1000);
    }

    @Test
    public void Kill_AssertEquals() {
        Shadow cornel = new Shadow("Cornel", Place.GLOOMY_PLACE, 1000);
        Ghost valera = new Ghost("Valera", Place.CHEERFUL_PLACE, 1000);
        assertEquals("Shadow Cornel killed Ghost Valera", cornel.kill(valera));

        assertEquals("Shadow Cornel killed itself :(", cornel.kill(cornel));
    }

    @Test
    public void GetName_AssertEquals() {
        Shadow cornel = new Shadow("Cornel", Place.GLOOMY_PLACE, 1000);
        assertEquals("Cornel", cornel.getName());
    }

    @Test
    public void GetMoney_AssertEquals() {
        Shadow cornel = new Shadow("Cornel", Place.GLOOMY_PLACE, 1000);
        assertEquals(1000, cornel.getMoney());
    }

    @Test
    public void WhereIs_AssertEquals() {
        Shadow cornel = new Shadow("Cornel", Place.GLOOMY_PLACE, 1000);
        assertEquals(Place.GLOOMY_PLACE, cornel.whereIs());
    }

    @Test
    public void WantToPay_AssertEquals() {
        Shadow cornel = new Shadow("Cornel", Place.GLOOMY_PLACE, 1000);
        assertEquals("Shadow Cornel wants to pay for Snickers", cornel.wantToPay("Snickers", 10));
        cornel.setMoney(0);
        assertEquals("Shadow Cornel doesn't have enough money for Snickers", cornel.wantToPay("Snickers", 10));
    }
}
