package task3;

public class Shadow extends AbstractCreature {
    private Status status;
    private String name;
    private Place place;

    public Shadow(String name, Place place) {
        super(name, Status.Shadow, place);
    }

}
