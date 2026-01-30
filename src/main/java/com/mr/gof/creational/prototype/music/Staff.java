package com.mr.gof.creational.prototype.music;

import com.mr.gof.Logger;

/**
 * Concrete Prototype: Staff (5 horizontal lines).
 */
public class Staff extends Graphic {

    @Override
    public void draw() {
        Logger.log("Drawing Staff (5 lines)");
    }

    @Override
    public Graphic cloneGraphic() {
        Logger.log("cloning Staff");
        return super.cloneGraphic();
    }
}
