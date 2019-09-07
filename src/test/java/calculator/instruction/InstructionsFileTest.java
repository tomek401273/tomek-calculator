package calculator.instruction;

import calculator.exceptions.InvalidApply;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class InstructionsFileTest {

    @Test
    public void createInstructions() {
    }

    @Test(expected = InvalidApply.class)
    public void validateFileApplayIsNotPresent() throws IOException {
        //Given
        String filePath = InstructionsFileTest.class.getClassLoader().getResource("apply/without-apply.txt").getFile();
        File inputFile = new File(filePath);
        //When & Then
        new InstructionsFile(new InstructionFactory(), inputFile);
    }

    @Test(expected = InvalidApply.class)
    public void validateFileApplayWithoutNumber() throws IOException {
        //Given
        String filePath = InstructionsFileTest.class.getClassLoader().getResource("apply/without-apply.txt").getFile();
        File inputFile = new File(filePath);
        //When && Then
        new InstructionsFile(new InstructionFactory(), inputFile);
    }

    @Test
    public void validateFileOk() throws IOException {
        //Given
        String filePath = InstructionsFileTest.class.getClassLoader().getResource("apply/applyOk.txt").getFile();
        File inputFile = new File(filePath);
        //When & Then
        new InstructionsFile(new InstructionFactory(), inputFile);
    }

}
