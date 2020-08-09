package ui;

import java.util.EventListener;

public interface TrackerListener extends EventListener {
    public void trackerEventOccurred(TrackerEvent event);
}
