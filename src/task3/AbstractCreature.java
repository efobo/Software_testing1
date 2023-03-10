package task3;

public abstract class AbstractCreature implements ICreature {
    private Status status;
    private String name;
    private Place place;


    public AbstractCreature(String name, Status status, Place place) {
        this.status = status;
        this.name = name;
        this.place = place;
    }

    public String getName(){
        return name;
    };
    public Status getStatus(){
        return status;
    };

    public Place getPlace(){
        return place;
    };

    public String whereIs() {
        return place.toString();
    }




}
