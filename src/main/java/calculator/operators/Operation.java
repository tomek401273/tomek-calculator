package calculator.operators;

import java.math.BigDecimal;

public interface Operation {
    BigDecimal calculate(BigDecimal first, BigDecimal second);
}
