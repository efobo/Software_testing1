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
public class ShadowTest {

    public Shadow initShadow(String name, String placeName, int placeLight){
        Place place = new Place(placeName, placeLight);
        Shadow shadow = new Shadow(name, place);
        return shadow;
    }



    @ParameterizedTest
    @ArgumentsSource(ShadowTest.shadowArgsProvider.class)
    public void GetName_AssertEquals(String name, String placeName, int placeLight) {
        Shadow cornel = initShadow(name, placeName, placeLight);

        assertEquals(name, cornel.getName());
    }


    @ParameterizedTest
    @ArgumentsSource(ShadowTest.shadowArgsProvider.class)
    public void WhereIs_AssertEquals(String name, String placeName, int placeLight) {
        Shadow shadow = initShadow(name, placeName, placeLight);
        if (placeLight > 80) {
            assertEquals(PlaceCharacteristic.Light + " " + placeName, shadow.whereIs());
        } else if (placeLight < 40) {
            assertEquals(PlaceCharacteristic.Gloomy + " " + placeName, shadow.whereIs());
        } else {
            assertEquals(PlaceCharacteristic.Dark + " " + placeName, shadow.whereIs());
        }
    }


    static class shadowArgsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    // check array sort
                    Arguments.of("Janna", "park", 100),
                    Arguments.of("Mark", "park", 10),
                    Arguments.of("Mark", "park", 60));
        }
    }


}
