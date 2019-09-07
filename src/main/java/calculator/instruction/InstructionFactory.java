package calculator.instruction;

import java.math.BigDecimal;

public class InstructionFactory implements IInstructionFactory {

    public InstructionFactory() {
    }

    @Override
    public Instruction createInstruction(String name, String value) {
        return new Instruction(name.trim(), new BigDecimal(value));
    }
}
