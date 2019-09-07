package calculator.order;

public class InstructionFactory implements IInstructionFactory {

    public InstructionFactory() {
    }

    @Override
    public Instruction createInstruction(String name, String value) {
        return new Instruction(name.trim(), Integer.parseInt(value));
    }
}
