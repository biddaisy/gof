package com.github.biddaisy.gof.creational.prototype.music;

/**
 * Abstract Tool in the editor framework.
 *
 * Tools represent actions in the palette:
 *   - create note
 *   - create rest
 *   - create staff
 *   - move object
 *   - select object
 *
 * Only creation tools use Prototype.
 */
public abstract class Tool {
    public abstract void onMouseClick(ScoreDocument document);
}
