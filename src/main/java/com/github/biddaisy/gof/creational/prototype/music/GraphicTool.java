package com.github.biddaisy.gof.creational.prototype.music;

/**
 * Framework tool that creates new graphics by cloning a prototype.
 *
 * This is the heart of the Prototype pattern in the GoF example.
 *
 * Instead of subclassing GraphicTool for each music object,
 * we pass a prototype instance into the constructor.
 *
 * Each GraphicTool instance is parameterized by:
 *   - whole note prototype
 *   - quarter note prototype
 *   - rest prototype
 *   - staff prototype
 */
public class GraphicTool extends Tool {

    private final Graphic prototype;

    public GraphicTool(Graphic prototype) {
        this.prototype = prototype;
    }

    @Override
    public void onMouseClick(ScoreDocument document) {
        // Clone the prototype to create a new object
        Graphic newGraphic = prototype.cloneGraphic();

        // Add the cloned object to the score
        document.addGraphic(newGraphic);
    }
}
