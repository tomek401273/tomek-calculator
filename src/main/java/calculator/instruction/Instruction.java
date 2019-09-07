package calculator.instruction;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Instruction {
    private String name;
    private BigDecimal value;
}
