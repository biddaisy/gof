package com.mr.gof.creational.prototype.music;

import com.mr.gof.Logger;

/**
 * Demonstrates the Prototype pattern in a music editor.
 *
 * This version uses the enhanced ScoreDocument, which now supports:
 *   - read‑only access to all graphics
 *   - querying by type
 *   - retrieving the last added graphic
 *   - counting graphics
 *   - predicate‑based searches
 *
 * The core Prototype behavior remains unchanged:
 * each tool clones its prototype and inserts the clone into the document.
 */
public class Demo {

    public static void main(String[] args) {

        ScoreDocument score = getScoreDocument();

        Logger.log("\n=== SCORE QUERIES ===");

        // Count graphics
        Logger.log("Total graphics: " + score.getGraphicCount());

        // Query by type
        var notes = score.getGraphicsByType(MusicalNote.class);
        Logger.log("Number of notes: " + notes.size());

        // Last added graphic
        score.getLastGraphic().ifPresent(g -> {
            Logger.log("Last added graphic: ");
            g.draw();
        });

        // Predicate-based query: find all whole notes
        var wholeNotes = score.findGraphics(g ->
                g instanceof MusicalNote note && "whole".equals(note.getDuration())
        );
        Logger.log("Whole notes found: " + wholeNotes.size());
    }

    private static ScoreDocument getScoreDocument() {
        ScoreDocument score = new ScoreDocument();

        // === PROTOTYPES ===
        Graphic wholeNotePrototype   = new MusicalNote("whole-note-bitmap", "whole");
        Graphic quarterNotePrototype = new MusicalNote("quarter-note-bitmap", "quarter");
        Graphic restPrototype        = new Rest("quarter-rest");
        Graphic staffPrototype       = new Staff();

        // === TOOLS CONFIGURED WITH PROTOTYPES ===
        Tool wholeNoteTool   = new GraphicTool(wholeNotePrototype);
        Tool quarterNoteTool = new GraphicTool(quarterNotePrototype);
        Tool restTool        = new GraphicTool(restPrototype);
        Tool staffTool       = new GraphicTool(staffPrototype);

        // === USER ACTIONS ===
        wholeNoteTool.onMouseClick(score);
        quarterNoteTool.onMouseClick(score);
        restTool.onMouseClick(score);
        staffTool.onMouseClick(score);
        quarterNoteTool.onMouseClick(score); // add another quarter note
        return score;
    }
}
