package com.sghir.generateur.Implementation;

import org.springframework.stereotype.Component;

@Component
public class AutoImcremet implements Idgen
{
    private long compter;

    @Override
    public String genererId() {
        return Long.toString(compter++);
    }
}
