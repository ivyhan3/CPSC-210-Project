package persistence;

import java.io.PrintWriter;

/**
 * Credit: TellerApp (AccountNotRobust) CPSC 210.
 */

// Represents data that can be saved to file
public interface Saveable {
    // MODIFIES: printWriter
    // EFFECTS: writes the saveable to printWriter
    void save(PrintWriter printWriter);
}
