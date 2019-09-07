package calculator.instruction;

import calculator.exceptions.InvalidApply;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class InstructionsFile implements IInstructionFile {
    private IInstructionFactory factory;
    private File instructionFile;
    private List<Instruction> instructionList;

    public InstructionsFile(IInstructionFactory factory, File instructionFile) throws IOException {
        this.factory = factory;
        this.instructionFile = instructionFile;
        validateFile();
        instructionList = createInstructions();
    }

    private List<Instruction> createInstructions() throws IOException {
        return Files.lines(instructionFile.toPath()).map(line -> line.split("\\s+"))
                .filter(lineSplits -> lineSplits.length == 2)
                .map(lineSplits -> factory.createInstruction(lineSplits[0], lineSplits[1]))
                .collect(Collectors.toList());
    }

    private void validateFile() throws IOException {
        boolean isCorrect = Files.lines(instructionFile.toPath())
                .anyMatch(line -> line.matches("apply \\d+"));
        if (!isCorrect) throw new InvalidApply("Input file doesn't contains apply with number");
    }

    @Override
    public List<Instruction> getInstructions() {
        return instructionList;
    }
}
