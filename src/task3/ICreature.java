package task3;

public interface ICreature {

    public String kill(ICreature creature);
    public String getName();
    public int getMoney();
    public Status getStatus();
    public Place whereIs();
    public String wantToPay(String forWhat, int cost);
    public void setMoney(int money);
}
