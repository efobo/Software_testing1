package task3;

public class Place {
    private String name;
    private int light;
    private PlaceCharacteristic placeCharacteristic;

    public Place(String name, int light) {
        this.name = name;
        setNoisy(light);
    }


    public void setNoisy(int light) {
        if (light > 100) {
            light = 100;
        } else if (light < 0) {
            light = 0;
        }

        if (light > 80) {
            placeCharacteristic = PlaceCharacteristic.Light;
        } else if (light < 40) {
            placeCharacteristic = PlaceCharacteristic.Gloomy;
        } else {
            placeCharacteristic = PlaceCharacteristic.Dark;
        }
    }

    public int getLight() {
        return light;
    }

    public void setLight(int light) {
        this.light = light;
    }

    public PlaceCharacteristic getPlaceCharacteristic() {
        return placeCharacteristic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return placeCharacteristic + " " + name;
    }
}
