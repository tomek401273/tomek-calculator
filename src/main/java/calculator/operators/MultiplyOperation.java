package calculator.operators;

import java.math.BigDecimal;

public class MultiplyOperation implements Operation {
    @Override
    public BigDecimal calculate(BigDecimal first, BigDecimal second) {
        return first.multiply(second);
    }
}
