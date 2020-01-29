package dev.vladflore.javaeezerotohero;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GermanLocalitiesTest {

    @DisplayName("Search input to output conversion")
    @ParameterizedTest(name = "input: {0} expected: {1}")
    @MethodSource("getTestData")
    void test(String input, String expected) {
        assertThat(prepareForSearch(input)).isEqualTo(expected);
    }

    private String prepareForSearch(String input) {
        Matcher matcher = Pattern.compile("^(Bad|St\\.|Sankt|Neustadt)\\s(.*)$").matcher(input);
        if (matcher.find()) {
            return matcher.group(1) + " " + matcher.group(2) + "*";
        } else {
            return Pattern.compile("[^a-zA-ZöäüßÖÄÜ]")
                    .splitAsStream(input)
                    .limit(1)
                    .filter(s -> !s.isEmpty())
                    .map(s -> s + "*")
                    .findFirst()
                    .orElse("");
        }
    }

    static Stream<Arguments> getTestData() {
        return Stream.of(
                Arguments.of("Bad Aibling", "Bad Aibling*"),
                Arguments.of("St. Blasien", "St. Blasien*"),
                Arguments.of("Frankfurt a.M.", "Frankfurt*"),
                Arguments.of("Sankt Augustin", "Sankt Augustin*"),
                Arguments.of("Titisee-Neustadt", "Titisee*"),
                Arguments.of(" Ort", ""),
                Arguments.of("Neustadt an der Aisch", "Neustadt an der Aisch*")
        );
    }

}
