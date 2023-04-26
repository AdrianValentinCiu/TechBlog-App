package com.tech.blog.junit;

public class OperatiiDBImplJunit implements OperatiiDB{

    @Override
    public UserJUnit getUser() {
        return new UserJUnit("Adi", Risk.RISC_RIDICAT);
    }
}
