package calculator.calc;


import calculator.library.ILibraryOperators;
import calculator.operators.Operation;
import calculator.order.IInstructionSet;
import calculator.order.Instruction;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Machine {

	private ILibraryOperators operators;
	private IInstructionSet instructionSet;

	public Machine(ILibraryOperators operators, IInstructionSet instructions) {
		this.operators = operators;
		this.instructionSet = instructions;
	}
	
	public int calculate() {
		if (instructionSet == null) throw new NullPointerException("No instruction set.");
		List<Instruction> instructions = this.instructionSet.getInstructions();
		
		int currentValue = instructions.get(instructions.size() - 1).getValue();

		Map<String, Operation> operators = this.operators.getLibrary();
		
		for (int i = 0; i < instructions.size() - 1; i++) {
			String token = instructions.get(i).getName();
			int toBeOperatedOn = instructions.get(i).getValue();
			
			if (!operators.containsKey(token)) System.out.println("The instruction " + token + " cannot be found in the class files. Please check.");
			currentValue = singleCalculate(currentValue, toBeOperatedOn, operators.get(token)).intValue();
		}
		
		return currentValue;
	}
	
	private BigDecimal singleCalculate(int currentValue, int toBeOperatedOn, Operation operator) {
		return operator.calculate(new BigDecimal(currentValue), new BigDecimal(toBeOperatedOn));
	}
}
