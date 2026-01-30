package com.mr.gof.creational.prototype.music;

/**
 * Abstract Prototype for all graphical music elements.
 *
 * The key requirement of the Prototype pattern:
 *   - Every subclass must support cloning.
 *
 * The framework (GraphicTool) will clone these objects
 * instead of instantiating them directly.
 */
public abstract class Graphic implements Cloneable {

    /**
     * Draws the graphic on the screen.
     * Concrete subclasses define their own rendering.
     */
    public abstract void draw();

    /**
     * Prototype cloning operation.
     *
     * Uses Object.clone() to produce a shallow copy.
     * Subclasses may override if deep cloning is required.
     */
    public Graphic cloneGraphic() {
        try {
            return (Graphic) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone failed", e);
        }
    }
}
