package task3;

public class Ghost extends AbstractCreature {

    private Status status;
    private String name;
    private int money;
    private Place place;

    public Ghost(String name, Place place, int money) {
        super(name, Status.Ghost, place, Sex.Default, money);
    }


}
