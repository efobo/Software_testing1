package task3;

public class Ghost extends AbstractCreature {

    private Status status;
    private String name;
    private int money;
    private Place place;
    private int lives;

    public Ghost(String name, Place place) {
        super(name, Status.Ghost, place);
        lives =10;
    }

    public String kill(Ghost ghost){
        if (lives > 0) {
            if (this.equals(ghost)) {
                lives = lives - 1;
                return getStatus() + " " + getName() + " killed itself :(";
            } else {

                int otherLives = ghost.getLives();
                if (otherLives > 0 ) {
                    ghost.setLives(otherLives - 1);
                    return getStatus() + " " + getName() + " killed " + ghost.getStatus() + " " + ghost.getName();
                } else {
                    return "He cannot be killed, as he has no lives left.";
                }

            }
        } else {
            return "You don't have any more lives to kill";
        }


    };

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }


}
