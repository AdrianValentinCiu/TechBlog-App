package com.tech.blog.junit;

public class OperatiiDBImplJunit implements OperatiiDB{

    @Override
    public User getUser() {
        return new User("Adi", Risk.RISC_RIDICAT);
    }
}
