package test_task3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import task3.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HumanTest {

    public Human initHuman(String name, String placeName, int placeLight, Sex sex, int money){
        Place place = new Place(placeName, placeLight);
        Human human = new Human(name, place, sex, money);
        return human;
    }



    @ParameterizedTest
    @ArgumentsSource(HumanTest.humanArgsProvider.class)
    public void GetName_AssertEquals(String name, String placeName, int placeLight, Sex sex, int money) {
        Human human = initHuman(name, placeName, placeLight, sex, money);
        assertEquals(name, human.getName());
    }

    @ParameterizedTest
    @ArgumentsSource(HumanTest.humanArgsProvider.class)
    public void GetMoney_AssertEquals(String name, String placeName, int placeLight, Sex sex, int money) {
        Human human = initHuman(name, placeName, placeLight, sex, money);
        assertEquals(money, human.getMoney());
    }

    @ParameterizedTest
    @ArgumentsSource(HumanTest.humanArgsProvider.class)
    public void WhereIs_AssertEquals(String name, String placeName, int placeLight, Sex sex, int money) {
        Human human = initHuman(name, placeName, placeLight, sex, money);
        if (placeLight > 80) {
            assertEquals(PlaceCharacteristic.Light + " " + placeName, human.whereIs());
        } else if (placeLight < 40) {
            assertEquals(PlaceCharacteristic.Gloomy + " " + placeName, human.whereIs());
        } else {
            assertEquals(PlaceCharacteristic.Dark + " " + placeName, human.whereIs());
        }

    }

    @ParameterizedTest
    @ArgumentsSource(HumanTest.humanArgsProvider.class)
    public void succesWantToPay_AssertEquals(String name, String placeName, int placeLight, Sex sex, int money) {
        Human human = initHuman(name, placeName, placeLight, sex, 100);
        assertEquals("Human " + name + " wants to pay for Snickers", human.wantToPay("Snickers", 10));

    }

    @ParameterizedTest
    @ArgumentsSource(HumanTest.humanArgsProvider.class)
    public void failWantToPay_AssertEquals(String name, String placeName, int placeLight, Sex sex, int money) {
        Human human = initHuman(name, placeName, placeLight, sex, 0);

        assertEquals("Human " +  name + " doesn't have enough money for Snickers", human.wantToPay("Snickers", 10));
    }


    static class humanArgsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    // check array sort
                    Arguments.of("Janna", "park", 100, Sex.Woman, 100),
                    Arguments.of("Janna", "park", 20, Sex.Woman, 10),
                    Arguments.of("Janna", "park", 60, Sex.Woman, 1000),
                    Arguments.of("Mark", "park", 10, Sex.Man, 432),
                    Arguments.of("Mark", "park", 90, Sex.Man, 3829),
                    Arguments.of("Mark", "park", 70, Sex.Man, 538));
        }
    }
}
