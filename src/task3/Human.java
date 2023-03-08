package task3;

import java.util.Random;

public class Human extends AbstractCreature {
    private Status status;
    private String name;
    private int money;
    private Place place;

    public Human(String name, Place place, Sex sex, int money) {
        super(name, Status.Human, place, sex, money);
    }
}
