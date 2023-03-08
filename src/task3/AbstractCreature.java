package task3;

public abstract class AbstractCreature implements ICreature {
    private Status status;
    private String name;
    private int money;
    private Place place;
    private Sex sex;

    public AbstractCreature(String name, Status status, Place place, Sex sex, int money) {
        this.status = status;
        this.name = name;
        this.money = money;
        this.place = place;
        this.sex = sex;
    }
    public String kill(ICreature creature){
        if (this.equals(creature)) {
            if (sex == Sex.Default) {
                return getStatus() + " " + getName() + " killed itself :(";
            } else if (sex == Sex.Man) {
                return getStatus() + " " + getName() + " killed himself :(";
            } else {
                return getStatus() + " " + getName() + " killed herself :(";
            }

        } else {
            return getStatus() + " " + getName() + " killed " + creature.getStatus() + " " + creature.getName();
        }

    };
    public String getName(){
        return name;
    };
    public Status getStatus(){
        return status;
    };
    public int getMoney(){
        return money;
    };
    public Place whereIs(){
        return place;
    };
    public String wantToPay(String forWhat, int cost){
        if (money > cost) {
            return getStatus() + " " + getName() + " wants to pay for " + forWhat;
        }
        else {
            return getStatus() + " " + getName() + " doesn't have enough money for " + forWhat;
        }
    };

    public void setMoney(int money){
        this.money = money;
    };


}
