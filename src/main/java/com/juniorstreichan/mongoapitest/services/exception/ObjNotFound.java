package com.juniorstreichan.mongoapitest.services.exception;

public class ObjNotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ObjNotFound(String msg ) {
    super(msg);
    }
}
