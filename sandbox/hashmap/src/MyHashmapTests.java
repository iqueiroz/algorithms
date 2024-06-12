
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.Test;

public class MyHashmapTests {
    @Test
    public void get_NotExistingKey_ShoudThrows(){
        //setup
        MyKey myKey = new MyKey(1, "some key");

        //act
        MyHashmap myHashmap = new MyHashmap();

        //assert
        assertThrows(NoSuchElementException.class, ()->myHashmap.get(myKey));
    } 

    @Test
    public void get_ExistingKey_ShoudReturnElement(){
        //setup
        MyKey myKey = new MyKey(1, "some key");
        MyValue myValue = new MyValue(1, "some value");
        MyHashmap myHashmap = new MyHashmap();
        myHashmap.put(myKey, myValue);
        //act
        var result = myHashmap.get(myKey);

        //assert
        assertEquals(myValue, result);
    } 


    @Test
    public void get_ExistingKey_MultipleElements_ShoudReturnElement(){
        //setup
        MyHashmap myHashmap = new MyHashmap();
        
        //generate bunch of nodes
        for(int i=0; i<9999; i++) {
            MyKey someKey = new MyKey(i, "some key");
            MyValue someValue = new MyValue(i, "some value");
            myHashmap.put(someKey, someValue);
        }
        MyKey myKey = new MyKey(99999, "some key");
        MyValue myValue = new MyValue(99999, "some value");
        
        myHashmap.put(myKey, myValue);

        //act
        var result = myHashmap.get(myKey);

        //assert
        assertEquals(myValue, result);
    } 



}
