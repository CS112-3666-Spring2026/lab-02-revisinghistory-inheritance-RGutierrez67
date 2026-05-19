public class HistoricalEvent {
    private String description;
    private Date eventDay;

    public HistoricalEvent() {
        this("No description provided.", new Date());
    }

    public HistoricalEvent(String description, Date eventDay) {
        if (!setAll(description, eventDay)) {
            System.out.println("ERROR: bad historical event data!");
            System.out.println("Exiting program...");
            System.exit(0);
        }
    }

    public HistoricalEvent(HistoricalEvent original) {
        if (original == null) {
            System.out.println("ERROR: trying to copy NULL HistoricalEvent object.");
            System.out.println("Exiting program...");
            System.exit(0);
        }

        setAll(original.description, original.eventDay);
    }

    public boolean setDescription(String description) {
        if (description != null && description.length() > 0) {
            this.description = description;
            return true;
        }

        return false;
    }

    public boolean setEventDay(Date eventDay) {
        if (eventDay != null) {
            this.eventDay = new Date(eventDay);
            return true;
        }

        return false;
    }

    public boolean setAll(String description, Date eventDay) {
        if (description != null && description.length() > 0 && eventDay != null) {
            this.description = description;
            this.eventDay = new Date(eventDay);
            return true;
        }

        return false;
    }

    public String getDescription() {
        return description;
    }

    public Date getEventDay() {
        return new Date(eventDay);
    }

    @Override
    public String toString() {
        return "On " + eventDay + ": " + description;
    }

    @Override
    public boolean equals(Object other) {
        HistoricalEvent otherEvent;

        if (other == null) {
            return false;
        } else if (!(other instanceof HistoricalEvent)) {
            return false;
        } else {
            otherEvent = (HistoricalEvent) other;
            return description.equals(otherEvent.description)
                    && eventDay.equals(otherEvent.eventDay);
        }
    }
}