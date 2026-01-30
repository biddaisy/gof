package com.github.biddaisy.gof.creational.prototype.music;

import com.github.biddaisy.gof.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Represents the music score document in the editor.
 *
 * This class is intentionally simple: it stores graphical elements
 * (notes, rests, staves) that are added by tools such as GraphicTool.
 *
 * In the Prototype pattern, GraphicTool clones a prototype and then
 * inserts the clone into this document. ScoreDocument acts as the
 * receiver/aggregate for all created graphics.
 *
 * The document exposes safe, read‑only query operations so the editor
 * can inspect its contents without breaking encapsulation.
 */
public class ScoreDocument {

    /**
     * Internal list of all graphical elements in the score.
     *
     * This list is private and never exposed directly to callers.
     * All access is done through controlled, read‑only query methods.
     */
    private final List<Graphic> graphics = new ArrayList<>();

    /**
     * Adds a new Graphic to the score.
     *
     * Called by GraphicTool after cloning a prototype.
     * This simulates inserting a new note/rest/staff into the editor.
     */
    public void addGraphic(Graphic g) {
        graphics.add(g);
        Logger.log("Added graphic to score:");
        g.draw();
    }

    /**
     * Returns an unmodifiable view of all graphics in the score.
     *
     * This prevents external code from modifying the internal list,
     * preserving encapsulation and document integrity.
     */
    public List<Graphic> getGraphics() {
        return Collections.unmodifiableList(graphics);
    }

    /**
     * Returns all graphics of a specific type.
     *
     * Useful for operations like:
     *   - selecting all notes
     *   - exporting only staves
     *   - analyzing rests
     *
     * @param type the class of the Graphic subtype to filter by
     * @param <T>  the specific Graphic subtype
     */
    public <T extends Graphic> List<T> getGraphicsByType(Class<T> type) {
        return graphics.stream()
                .filter(type::isInstance)
                .map(type::cast)
                .toList();
    }

    /**
     * Returns the most recently added graphic, if any.
     *
     * Useful for:
     *   - undo operations
     *   - selecting the last inserted note
     *   - debugging
     */
    public Optional<Graphic> getLastGraphic() {
        if (graphics.isEmpty()) return Optional.empty();
        return Optional.of(graphics.getLast());
    }

    /**
     * Returns the number of graphics currently in the score.
     *
     * Useful for diagnostics, UI updates, or testing.
     */
    public int getGraphicCount() {
        return graphics.size();
    }

    /**
     * Flexible query method that accepts a predicate.
     *
     * This allows callers to define arbitrary search logic, e.g.:
     *   - find all whole notes
     *   - find all graphics added after a timestamp
     *   - find all rests of a certain type
     *
     * @param filter predicate defining the match condition
     */
    public List<Graphic> findGraphics(Predicate<Graphic> filter) {
        return graphics.stream()
                .filter(filter)
                .toList();
    }
}
