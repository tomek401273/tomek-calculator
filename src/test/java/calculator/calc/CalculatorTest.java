package calculator.calc;

import calculator.file.loader.FileLoader;
import calculator.instruction.InstructionFactory;
import calculator.instruction.InstructionsFile;
import calculator.instruction.InstructionsFileTest;
import calculator.library.LibraryOperators;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void calculate1() throws IOException {
        LibraryOperators libraryOperators= new LibraryOperators();
        File inputFile = new File(CalculatorTest.class.getClassLoader().getResource("instructions/instructions.txt").getFile());

        InstructionsFile instructionsFile = new InstructionsFile(new InstructionFactory(), inputFile);
        Calculator calculator = new Calculator(libraryOperators, instructionsFile);
        BigDecimal result = calculator.calculate();
        Assert.assertEquals(new BigDecimal(36), result);
    }

    @Test
    public void calculate2() throws IOException {
        LibraryOperators libraryOperators= new LibraryOperators();
        File inputFile = new File(CalculatorTest.class.getClassLoader().getResource("instructions/instructions2.txt").getFile());

        InstructionsFile instructionsFile = new InstructionsFile(new InstructionFactory(), inputFile);
        Calculator calculator = new Calculator(libraryOperators, instructionsFile);
        BigDecimal result = calculator.calculate();
        Assert.assertEquals(new BigDecimal(32), result);
    }
    @Test
    public void calculate3() throws IOException {
        LibraryOperators libraryOperators= new LibraryOperators();
        File inputFile = new File(CalculatorTest.class.getClassLoader().getResource("instructions/instructions3.txt").getFile());

        InstructionsFile instructionsFile = new InstructionsFile(new InstructionFactory(), inputFile);
        Calculator calculator = new Calculator(libraryOperators, instructionsFile);
        BigDecimal result = calculator.calculate();
        Assert.assertEquals(new BigDecimal(1), result);
    }
}
