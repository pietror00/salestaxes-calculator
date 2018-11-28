package it.salestaxes.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtils {

    public static BigDecimal roundToNearest5Cent(BigDecimal input) {
        input = input.multiply(new BigDecimal("20")).setScale(0, RoundingMode.UP).setScale(2);
        input = input.divide(new BigDecimal("20"), RoundingMode.UP);
        return input;
    }

    public static BigDecimal roundTwoDecimalPlaces(BigDecimal input) {
        return input.setScale(2, RoundingMode.CEILING);
    }
}
