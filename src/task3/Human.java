package task3;

import java.util.Random;

public class Human extends AbstractCreature {
    private Status status;
    private String name;
    private int money;
    private Place place;
    private Sex sex;

    public Human(String name, Place place, Sex sex, int money) {
        super(name, Status.Human, place);
        this.money = money;
        this.sex = sex;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public String wantToPay(String forWhat, int cost){
        if (money > cost) {
            return getStatus() + " " + getName() + " wants to pay for " + forWhat;
        }
        else {
            return getStatus() + " " + getName() + " doesn't have enough money for " + forWhat;
        }
    };
}
