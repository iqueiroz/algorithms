import static org.junit.Assert.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class MapConverterTests {
    @Test
    public void convertToMap_WithNullParameter_ShouldThrow(){
        assertThrows(IllegalArgumentException.class, ()->MapConverter.convertToMap(null));
    } 

    @Test
    public void convertToMap_WithInvalidParameter_ShouldThrow(){
        //setup
        String[] invalidParameters = { "123,", "123", "123,123,123", "111,,," };
        
        for (String invalidParameter : invalidParameters) {
            assertThrows(IllegalArgumentException.class, ()->MapConverter.convertToMap(Arrays.asList(invalidParameter)));
        }
    }

    @Test
    public void convertToMap_WithValidParameters_ShoudConvert(){
        //setup
        List<String> parameter = Arrays.asList("11,21", "12,21", "13,23", "13,24");

        //act
        var result = MapConverter.convertToMap(parameter);

        //assert
        assertThat("key 11 is expected", result.containsKey("11"));
        assertThat("key 12 is expected", result.containsKey("12"));
        assertThat("key 13 is expected", result.containsKey("13"));
    }

    @Test
    public void convertToMap_WithRepeatedKeys_ShoudUpdate(){
        //setup
        List<String> parameter = Arrays.asList("11,21", "12,21", "13,23", "13,24");

        //act
        var result = MapConverter.convertToMap(parameter);

        //assert
        assertThat("key 13 is expected", result.containsKey("11"));
        assertThat("key 13 should be updated to the latest value", "24".equals(result.get("13")));
    }
}
