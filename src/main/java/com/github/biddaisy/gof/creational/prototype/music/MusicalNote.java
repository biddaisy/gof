package com.github.biddaisy.gof.creational.prototype.music;

import com.github.biddaisy.gof.Logger;

/**
 * Concrete Prototype: Musical Note.
 * <p>
 * Instead of separate classes for whole, half, quarter notes,
 * we use ONE class with configurable:
 * - bitmap (visual representation)
 * - duration (whole, half, quarter, etc.)
 * <p>
 * This is exactly what the GoF book describes:
 * "We can reduce the number of classes dramatically."
 */
public class MusicalNote extends Graphic {

    private final String bitmap;
    private final String duration;

    public MusicalNote(String bitmap, String duration) {
        this.bitmap = bitmap;
        this.duration = duration;
    }

    @Override
    public void draw() {
        Logger.log("Drawing MusicalNote: " + duration + " (" + bitmap + ")");
    }

    public String getBitmap() {
        return bitmap;
    }

    public String getDuration() {
        return duration;
    }

    /**
     * Cloning is inherited from Graphic.
     * Shallow copy is sufficient because fields are immutable strings.
     */
    @Override
    public Graphic cloneGraphic() {
        Logger.log("cloning MusicNote");
        return super.cloneGraphic();
    }
}
