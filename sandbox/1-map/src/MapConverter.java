import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapConverter {
    /**
     * This methods converts a list of comma separated values to a Map.
     * Both keys and values are strings.
     * <p>
     * Replaced values are updated by its last occurence.
     * @param list the list of comma separated values to be converted.  Example: Arrays.asList("11,21", "12,21")
     * @return     a Map with the respective key/values pairs
     * @throws IllegalArgumentException An invalid parameter was suppllied like null argument or non key/value separated items.
     */
    public static Map convertToMap(List<String> list) {
        if(list==null)
            throw new IllegalArgumentException("Param 'list' could  not be null.");

        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (String item : list) {
            String[] segments = item.split(",");
            if(segments.length!=2) 
                throw new IllegalArgumentException(String.format("Unexpected value: '%s'. Items should be sepparated by comma. Example: \"key,value\".", item));
            if(!hashMap.containsKey(segments[0]))
                hashMap.put(segments[0], segments[1]);
            else
                hashMap.replace(segments[0], segments[1]);
        }
        return hashMap;
    }
}
