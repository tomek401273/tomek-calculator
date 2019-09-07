package calculator.calc;

import calculator.library.ILibraryOperators;
import calculator.operators.Operation;
import calculator.instruction.IInstructionFile;
import calculator.instruction.Instruction;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Calculator {
    private ILibraryOperators operators;
    private IInstructionFile instructionSet;

    public Calculator(ILibraryOperators operators, IInstructionFile instructionSet) {
        this.operators = operators;
        this.instructionSet = instructionSet;
    }

    public BigDecimal calculate() {
        if (instructionSet == null || instructionSet.getInstructions().size() == 0)
            throw new NullPointerException("Current file doesn't contains any instructions!");
        List<Instruction> instructionList = instructionSet.getInstructions();
        Map<String, Operation> operatorsLibrary = this.operators.getLibrary();
        BigDecimal total = instructionList.get(instructionList.size()-1).getValue();

        for (int i = 0; i < instructionList.size()-1; i++) {
            Instruction instruction = instructionList.get(i);
            String name = instruction.getName();
            BigDecimal value = instruction.getValue();
            if (operatorsLibrary.containsKey(name))
                total = operatorsLibrary.get(name).calculate(total, value);
        }
        return total;
    }

}
