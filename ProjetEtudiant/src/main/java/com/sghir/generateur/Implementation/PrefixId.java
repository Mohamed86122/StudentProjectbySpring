package com.sghir.generateur.Implementation;

public class PrefixId implements Idgen
{

    private String prefix;
    private long compteur = 0;
    @Override
    public String genererId() {
        return prefix + compteur++ ;
    }
}
