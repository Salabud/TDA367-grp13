package model.colony.events;

/**
 * Interface for objects that listen to colony events.
 * Follows the Observer pattern - listeners register with ants
 * and receive events when ants broadcast them.
 */
public interface ColonyEventListener {
    /**
     * Called when a colony event is broadcast.
     * @param event : the event that was broadcast
     */
    void onColonyEvent(ColonyEvent event);
}
