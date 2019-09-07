package calculator.order;

public interface IInstructionFactory {
   Instruction createInstruction(String name, String value);
}
