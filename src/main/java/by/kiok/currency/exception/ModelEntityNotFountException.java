package by.kiok.currency.exception;

public class ModelEntityNotFountException extends RuntimeException {

    private static final String MESSAGE = "'Entity by id='%s' is not fount'";

    public ModelEntityNotFountException(Long id) {
        super(String.format(MESSAGE, id));
    }
}
