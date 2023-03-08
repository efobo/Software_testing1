package task3;

public class Shadow extends AbstractCreature {
    private Status status;
    private String name;
    private int money;
    private Place place;

    public Shadow(String name, Place place, int money) {
        super(name, Status.Shadow, place, Sex.Default, money);
    }

}
