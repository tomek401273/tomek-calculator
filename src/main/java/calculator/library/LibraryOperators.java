package calculator.library;

import calculator.operators.*;

import java.util.HashMap;
import java.util.Map;

public class LibraryOperators implements ILibraryOperators {

    private Map<String, Operation> operatorMap;

    public LibraryOperators() {
        this.operatorMap= new HashMap<>();
        this.operatorMap.put("add", new AddOperation());
        this.operatorMap.put("subtract", new SubtractOperation());
        this.operatorMap.put("multiply", new MultiplyOperation());
        this.operatorMap.put("divide", new DivideOperation());
    }

    @Override
    public Map<String, Operation> getLibrary() {
        return operatorMap;
    }
}
