package dev.vladflore.javaeezerotohero.soap;

import dev.vladflore.javaeezerotohero.calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    void testCalculator_addition() {

        Calculator calculator = new Calculator();
        int add = calculator.getCalculatorSoap().add(5, 5);
        assertThat(add).isEqualTo(10);

    }

}
