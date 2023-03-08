package test_task3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import task3.Ghost;
import task3.Human;
import task3.Place;
import task3.Sex;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GhostTest {

    @Test
    public void Constructor_NoExcept() {
        new Ghost("Sasha", Place.GLOOMY_PLACE, 1000);
    }

    @Test
    public void Kill_AssertEquals() {
        Human janna = new Human("Janna", Place.CHEERFUL_PLACE, Sex.Woman,100);
        Ghost valera = new Ghost("Valera", Place.CHEERFUL_PLACE, 1000);
        assertEquals("Ghost Valera killed Human Janna", valera.kill(janna));

        assertEquals("Ghost Valera killed itself :(", valera.kill(valera));
    }

    @Test
    public void GetName_AssertEquals() {
        Ghost sasha = new Ghost("Sasha", Place.CHEERFUL_PLACE, 100);
        assertEquals("Sasha", sasha.getName());
    }

    @Test
    public void GetMoney_AssertEquals() {
        Ghost sasha = new Ghost("Sasha", Place.CHEERFUL_PLACE, 100);
        assertEquals(100, sasha.getMoney());
    }

    @Test
    public void WhereIs_AssertEquals() {
        Ghost sasha = new Ghost("Sasha", Place.CHEERFUL_PLACE, 100);
        assertEquals(Place.CHEERFUL_PLACE, sasha.whereIs());
    }

    @Test
    public void WantToPay_AssertEquals() {
        Ghost sasha = new Ghost("Sasha", Place.CHEERFUL_PLACE, 100);
        assertEquals("Ghost Sasha wants to pay for Snickers", sasha.wantToPay("Snickers", 10));
        sasha.setMoney(0);
        assertEquals("Ghost Sasha doesn't have enough money for Snickers", sasha.wantToPay("Snickers", 10));
    }
}
