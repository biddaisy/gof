package com.mr.gof.creational.abstractfactory.hybrid;

public class EnchantedRoom extends Room {

    private final Spell spell;

    public EnchantedRoom(int n, Spell spell) {
        super(n);
        this.spell = spell;
    }
}
