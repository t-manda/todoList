package jp.kobespiral.todoList.exception;

public class UserControllerException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserControllerException(String message) {
        super(message);
    }
}