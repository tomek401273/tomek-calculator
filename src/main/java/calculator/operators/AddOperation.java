package calculator.operators;

import java.math.BigDecimal;

public class AddOperation implements Operation {
    @Override
    public BigDecimal calculate(BigDecimal first, BigDecimal second) {
        return first.add(second);
    }
}
