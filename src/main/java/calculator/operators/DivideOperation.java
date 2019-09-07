package calculator.operators;

import java.math.BigDecimal;

public class DivideOperation implements Operation {
    @Override
    public BigDecimal calculate(BigDecimal first, BigDecimal second) {
        return first.divide(second);
    }
}
