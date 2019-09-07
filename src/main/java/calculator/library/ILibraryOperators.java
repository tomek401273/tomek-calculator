package calculator.library;

import calculator.operators.Operation;

import java.util.Map;

public interface ILibraryOperators {
    Map<String, Operation> getLibrary();
}
