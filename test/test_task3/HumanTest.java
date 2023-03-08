package test_task3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import task3.Ghost;
import task3.Human;
import task3.Place;
import task3.Sex;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HumanTest {

    @Test
    public void Constructor_NoExcept() {
        new Human("Valera", Place.CHEERFUL_PLACE, Sex.Man, 1000);
    }

    @Test
    public void Kill_AssertEquals() {
        Human janna = new Human("Janna", Place.CHEERFUL_PLACE, Sex.Woman, 100);
        Ghost valera = new Ghost("Valera", Place.CHEERFUL_PLACE, 1000);
        assertEquals("Human Janna killed Ghost Valera", janna.kill(valera));

        assertEquals("Human Janna killed herself :(", janna.kill(janna));
    }

    @Test
    public void GetName_AssertEquals() {
        Human janna = new Human("Janna", Place.CHEERFUL_PLACE, Sex.Woman,100);
        assertEquals("Janna", janna.getName());
    }

    @Test
    public void GetMoney_AssertEquals() {
        Human janna = new Human("Janna", Place.CHEERFUL_PLACE, Sex.Woman, 100);
        assertEquals(100, janna.getMoney());
    }

    @Test
    public void WhereIs_AssertEquals() {
        Human janna = new Human("Janna", Place.CHEERFUL_PLACE, Sex.Woman,100);
        assertEquals(Place.CHEERFUL_PLACE, janna.whereIs());
    }

    @Test
    public void WantToPay_AssertEquals() {
        Human janna = new Human("Janna", Place.CHEERFUL_PLACE, Sex.Woman,100);
        assertEquals("Human Janna wants to pay for Snickers", janna.wantToPay("Snickers", 10));
        janna.setMoney(0);
        assertEquals("Human Janna doesn't have enough money for Snickers", janna.wantToPay("Snickers", 10));
    }
}
