
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.Test;

public class DurationIteratorTests {
    @Test
    public void hasNext_WithNextAvailablePeriod_ShouldReturnTrue(){
        //setup
        LocalDate startDate = LocalDate.of(2023,3,6);
        LocalDate endDate = LocalDate.of(2023,5,4);

        //act
        DurationIterator iterator = new DurationIterator(startDate, endDate);

        //assert
        assertEquals(true, iterator.hasNext());
    } 

    @Test
    public void hasNext_WithoutNextAvailablePeriod_ShouldReturnFalse(){
        //setup
        LocalDate startDate = LocalDate.of(2023,5,4);
        LocalDate endDate = LocalDate.of(2023,5,3);

        //act
        DurationIterator iterator = new DurationIterator(startDate, endDate);

        //assert
        assertEquals(false, iterator.hasNext());
    } 

    @Test
    public void next_WithNotAvailablePeriod_ShouldThrows(){
        //setup
        LocalDate startDate = LocalDate.of(2023,5,4);
        LocalDate endDate = LocalDate.of(2023,5,3);


        //act
        DurationIterator iterator = new DurationIterator(startDate, endDate);

        //assert
        assertThrows(NoSuchElementException.class, ()->iterator.next());
    } 

    @Test
    public void next_WithAvailablePeriod_ShouldReturnWeeks(){
        //setup
        LocalDate startDate = LocalDate.of(2023,3,6);
        LocalDate endDate = LocalDate.of(2023,3,19);
        DurationIterator iterator = new DurationIterator(startDate, endDate);
        
        ArrayList<Duration> expectedResults = new ArrayList<Duration>();
        expectedResults.add(new Duration(LocalDate.of(2023, 3, 6), LocalDate.of(2023, 3, 10)));
        expectedResults.add(new Duration(LocalDate.of(2023, 3, 11), LocalDate.of(2023, 3, 12)));
        expectedResults.add(new Duration(LocalDate.of(2023, 3, 13), LocalDate.of(2023, 3, 17)));
        expectedResults.add(new Duration(LocalDate.of(2023, 3, 18), LocalDate.of(2023, 3, 19)));
        
        //act
        ArrayList<Duration> results = new ArrayList<Duration>();
        while(iterator.hasNext()) {
            results.add(iterator.next());
        }

        //assert
        assertEquals("interator result should return the same number of records as the expected sample", expectedResults.size(), results.size());
        for(int i = 0; i<results.size(); i++) {
            var expected = expectedResults.get(i);
            var result = results.get(i);
            assertThat(String.format("%s should be equals to %s", result.toString(), expected.toString()), expected.equals(result));
            
        }
    } 


    @Test
    public void next_WithIncompletePeriod_ShouldRestrictEndDate(){
        //setup
        LocalDate startDate = LocalDate.of(2023,3,6); //MONDAY
        LocalDate endDate = LocalDate.of(2023,3,8);   //WEDNESDAY
        DurationIterator iterator = new DurationIterator(startDate, endDate);
        
        ArrayList<Duration> expectedResults = new ArrayList<Duration>();
        expectedResults.add(new Duration(LocalDate.of(2023, 3, 6), LocalDate.of(2023, 3, 8)));
        
        //act
        ArrayList<Duration> results = new ArrayList<Duration>();
        while(iterator.hasNext()) {
            results.add(iterator.next());
        }

        //assert
        assertEquals("interator result should return the same number of records as the expected sample", expectedResults.size(), results.size());
        for(int i = 0; i<results.size(); i++) {
            var expected = expectedResults.get(i);
            var result = results.get(i);
            assertThat(String.format("%s should be equals to %s", result.toString(), expected.toString()), expected.equals(result));
            
        }
    } 

}
