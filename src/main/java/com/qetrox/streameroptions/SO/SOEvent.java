package com.qetrox.streameroptions.SO;

/**
 * Event class for StreamerOptions events.
 */
public class SOEvent {
    private SOEventType EventType;
    private String RedeemedBy;

    /**
     * Event class for StreamerOptions events.
     * @param EventType The type of event.
     * @param RedeemedBy The user who activated the event.
     */
    public SOEvent(SOEventType EventType, String RedeemedBy) {
        this.EventType = EventType;
        this.RedeemedBy = RedeemedBy;
    }

    /**
     * Get the type of event.
     * @return The type of event.
     */
    public SOEventType eventType() {
        return EventType;
    }

    /**
     * Get the user who activated the event.
     * @return The user who activated the event.
     */
    public String redeemedBy() {
        return RedeemedBy;
    }

    /**
     * Set the type of event.
     * @param EventType The type of event.
     */
    public void setEventType(SOEventType EventType) {
        this.EventType = EventType;
    }

    /**
     * Set the user who activated the event.
     * @param RedeemedBy The user who activated the event.
     */
    public void setRedeemedBy(String RedeemedBy) {
        this.RedeemedBy = RedeemedBy;
    }

    /**
     * Get the event as a string.
     * @return The event string.
     * @deprecated Use eventType() and redeemedBy() instead.
     */
    public String toString() {
        return "SOEvent(EventType=" + EventType + ", RedeemedBy=" + RedeemedBy + ")";
    }

    /**
     * Check if the event is equal to another object.
     * @param o The object to check.
     * @return Whether the event is equal to the object.
     */
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof SOEvent other)) return false;
        if (!other.equals((Object) this)) return false;
        if (!this.eventType().equals(other.eventType())) return false;
        return this.redeemedBy() == null ? other.redeemedBy() == null : this.redeemedBy().equals(other.redeemedBy());
    }
}
