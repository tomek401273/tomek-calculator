package calculator.operators;

import java.math.BigDecimal;

public class SubtractOperation implements Operation {
    @Override
    public BigDecimal calculate(BigDecimal first, BigDecimal second) {
        return first.subtract(second);
    }
}
