package br.com.pangoni.json;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class JSONParserTest {

    @Test
    public void testExtractKeyValuePairs() {

        final Map<String, String> pairs = new HashMap<String,String>();

        JSONParser parser = new JSONParser();

        parser.parse("{\"myKeyA\":\"sample value A\", \"myKeyB\":\"sample value B\"}",
 
           new JSONParserCallback(){

                private String lastKey;

                public void handleValue(String value) {
                    pairs.put(lastKey, value);
                }
            
                public void handleKey(String key) {
                    lastKey = key;
                }
            } );

        assertEquals(2, pairs.size());
        assertEquals("sample value A", pairs.get("myKeyA"));
        assertEquals("sample value B", pairs.get("myKeyB"));
    }
}