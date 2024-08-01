package ru.shmvsky.usingspringdatajpa.exception;

public class TodoNotFoundException extends ApiException {

    private static final String BASE_MESSAGE = "Todo not found with id = ";

    public TodoNotFoundException(Integer id) {
        super(BASE_MESSAGE + id);
    }

}
