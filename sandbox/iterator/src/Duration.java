import java.time.LocalDate;

public class Duration {
	private final LocalDate startDate;
    private final LocalDate endDate;


    public Duration (LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        String prefix = this.startDate.getDayOfWeek().getValue() <= 6 ? "Weekday" : "Weekend";
        return String.format("%s: %s - %s", prefix, this.startDate.toString(), this.endDate.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Duration))
            return false;
        Duration other = (Duration)obj;
        return this.getStartDate().isEqual(other.getStartDate()) &&
            this.getEndDate().isEqual(other.getEndDate());
    }

}
