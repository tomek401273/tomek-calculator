package calculator.instruction;

public interface IInstructionFactory {
   Instruction createInstruction(String name, String value);
}
