import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DurationIterator implements Iterator<Duration> {
	private final LocalDate startDate;
    private final LocalDate endDate;

    private LocalDate currentDate;

    private Duration currentDuration;

    public DurationIterator(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;

        this.currentDate = this.startDate;
    }
    private Boolean currentIsWeekday() {
        int weekDayNum = this.currentDate.getDayOfWeek().getValue();
        return weekDayNum >= DayOfWeek.MONDAY.getValue() && weekDayNum <= DayOfWeek.FRIDAY.getValue();
    }
    private void calculateNextDuration() {
        
        int daysToAdd;
        if(this.currentIsWeekday()) {
            daysToAdd = DayOfWeek.FRIDAY.getValue() - this.currentDate.getDayOfWeek().getValue();
        }
        else {
            daysToAdd = DayOfWeek.SUNDAY.getValue() - this.currentDate.getDayOfWeek().getValue();
        }
        
        //calc the end of the current period
        LocalDate currentPeriodEnd = this.currentDate.plusDays(daysToAdd);
        if(currentPeriodEnd.isAfter(this.endDate))
            currentPeriodEnd = this.endDate;
        this.currentDuration = new Duration(this.currentDate, currentPeriodEnd);
        
        this.currentDate = currentPeriodEnd.plusDays(1); //increment current date
    }

    @Override
    public boolean hasNext() {
        return this.currentDate.isBefore(this.endDate);
    }

    @Override
    public Duration next() {
        if (!this.hasNext())
            throw new NoSuchElementException("End date is out of range");

        this.calculateNextDuration();
        return this.currentDuration;

    }



}
