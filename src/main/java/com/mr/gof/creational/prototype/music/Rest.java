package com.mr.gof.creational.prototype.music;

import com.mr.gof.Logger;

/**
 * Concrete Prototype: Rest symbol.
 */
public class Rest extends Graphic {

    private final String type;

    public Rest(String type) {
        this.type = type;
    }

    @Override
    public void draw() {
        Logger.log("Drawing Rest: " + type);
    }

    @Override
    public Graphic cloneGraphic() {
        Logger.log("cloning Rest");
        return super.cloneGraphic();
    }
}
