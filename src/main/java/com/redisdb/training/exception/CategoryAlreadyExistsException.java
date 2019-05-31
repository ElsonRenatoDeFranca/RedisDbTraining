package com.redisdb.training.exception;

/**
 * Created by e068635 on 3/10/2019.
 */
public class CategoryAlreadyExistsException  extends Exception {

    private static final long serialVersionUID = 7899928512143245128L;

    public CategoryAlreadyExistsException(String message) {
        super(message);
    }

}
