public class RevisedHistoricalEvent extends HistoricalEvent {
    private String revisedDescription;
    private String citation;

    public RevisedHistoricalEvent() {
        this("No description provided.", new Date(),
                "No revised description provided.", "No citation provided.");
    }

    public RevisedHistoricalEvent(String description, Date eventDay,
            String revisedDescription, String citation) {
        super(description, eventDay);

        if (!setAll(revisedDescription, citation)) {
            System.out.println("ERROR: bad revised historical event data!");
            System.out.println("Exiting program...");
            System.exit(0);
        }
    }

    public RevisedHistoricalEvent(RevisedHistoricalEvent original) {
        super(original);

        if (original == null) {
            System.out.println("ERROR: trying to copy NULL RevisedHistoricalEvent object.");
            System.out.println("Exiting program...");
            System.exit(0);
        }

        setAll(original.revisedDescription, original.citation);
    }

    public boolean setRevisedDescription(String revisedDescription) {
        if (revisedDescription != null && revisedDescription.length() > 0) {
            this.revisedDescription = revisedDescription;
            return true;
        }

        return false;
    }

    public boolean setCitation(String citation) {
        if (citation != null && citation.length() > 0) {
            this.citation = citation;
            return true;
        }

        return false;
    }

    public boolean setAll(String revisedDescription, String citation) {
        if (revisedDescription != null && revisedDescription.length() > 0
                && citation != null && citation.length() > 0) {
            this.revisedDescription = revisedDescription;
            this.citation = citation;
            return true;
        }

        return false;
    }

    public String getRevisedDescription() {
        return revisedDescription;
    }

    public String getCitation() {
        return citation;
    }

    public void teach() {
        System.out.println("The following  \"history\" was told for many years:\n");
        System.out.println(getDescription());
        System.out.println();
        System.out.println();
        System.out.println(
                "By correcting history, not just rewriting it, we are revising it to embark on the process of righting a wrong.");
        System.out.println("Here is the revised history:");
        System.out.println(revisedDescription);
        System.out.println();
        System.out.println("Source: " + citation);
    }

    @Override
    public String toString() {
        return super.toString() + "\nRevised history: " + revisedDescription
                + "\nSource: " + citation;
    }

    @Override
    public boolean equals(Object other) {
        RevisedHistoricalEvent otherEvent;

        if (other == null) {
            return false;
        } else if (!(other instanceof RevisedHistoricalEvent)) {
            return false;
        } else {
            otherEvent = (RevisedHistoricalEvent) other;
            return super.equals(otherEvent)
                    && revisedDescription.equals(otherEvent.revisedDescription)
                    && citation.equals(otherEvent.citation);
        }
    }
}