package com.mr.gof.creational.abstractfactory.classic;

public class EnchantedRoom extends Room {

    private final Spell spell;

    public EnchantedRoom(int n, Spell spell) {
        super(n);
        this.spell = spell;
    }
}
