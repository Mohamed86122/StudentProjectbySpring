package com.sghir.generateur.Implementation;

public class AutoImcremet implements Idgen
{
    private long compter;

    @Override
    public String genererId() {
        return Long.toString(compter++);
    }
}
