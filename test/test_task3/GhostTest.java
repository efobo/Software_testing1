package test_task3;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
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
public class GhostTest {


    public Ghost initGhost(String name, String placeName, int placeLight){
        //test setup code
        Place place = new Place(placeName, placeLight);
        Ghost ghost = new Ghost(name, place);
        return ghost;
    }

    @ParameterizedTest
    @ArgumentsSource(GhostTest.oneGhostArgsProvider.class)
    public void successSuicide(String name, String placeName, int placeLight) {

        Ghost valera = initGhost(name, placeName, placeLight);

        assertEquals("Ghost " + name + " killed itself :(", valera.kill(valera));
    }

    @ParameterizedTest
    @ArgumentsSource(GhostTest.oneGhostArgsProvider.class)
    public void failSuicide(String name, String placeName, int placeLight) {

        Ghost valera = initGhost(name, placeName, placeLight);
        valera.setLives(0);

        assertEquals("You don't have any more lives to kill", valera.kill(valera));
    }

    @ParameterizedTest
    @ArgumentsSource(GhostTest.twoGhostArgsProvider.class)
    public void Kill_AssertEquals(String name1, String placeName1, int placeLight1, String name2, String placeName2, int placeLight2) {
        Ghost ghost1 = initGhost(name1, placeName1, placeLight1);
        Ghost ghost2 = initGhost(name2, placeName2, placeLight2);
        assertEquals("Ghost " + name1 + " killed Ghost " + name2, ghost1.kill(ghost2));
    }


    @ParameterizedTest
    @ArgumentsSource(GhostTest.twoGhostArgsProvider.class)
    public void failKill_AssertEquals(String name1, String placeName1, int placeLight1, String name2, String placeName2, int placeLight2) {
        Ghost ghost1 = initGhost(name1, placeName1, placeLight1);

        Ghost ghost2 = initGhost(name2, placeName2, placeLight2);
        ghost2.setLives(0);
        assertEquals("He cannot be killed, as he has no lives left.", ghost1.kill(ghost2));
    }

    @ParameterizedTest
    @ArgumentsSource(GhostTest.oneGhostArgsProvider.class)
    public void GetName_AssertEquals(String name, String placeName, int placeLight) {
        Ghost ghost = initGhost(name, placeName, placeLight);
        assertEquals(name, ghost.getName());
    }

    @ParameterizedTest
    @ArgumentsSource(GhostTest.oneGhostArgsProvider.class)
    public void WhereIs_AssertEquals(String name, String placeName, int placeLight) {

        Ghost ghost = initGhost(name, placeName, placeLight);

        if (placeLight > 80) {
            assertEquals(PlaceCharacteristic.Light + " " + placeName, ghost.whereIs());
        } else if (placeLight < 40) {
            assertEquals(PlaceCharacteristic.Gloomy + " " + placeName, ghost.whereIs());
        } else {
            assertEquals(PlaceCharacteristic.Dark + " " + placeName, ghost.whereIs());
        }

    }


    static class oneGhostArgsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    // check array sort
                    Arguments.of("Janna", "park", 100),
                    Arguments.of("Mark", "park", 10),
                    Arguments.of("Mark", "park", 70));
        }
    }

    static class twoGhostArgsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    // check array sort
                    Arguments.of("Janna", "park", 100, "Mark", "park", 10),
                    Arguments.of("Mark", "park", 10, "Janna", "park", 100),
                    Arguments.of("Mark", "park", 70, "Mark", "park", 70));
        }
    }


}
