package dat3.cars.experiment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleSanitizerTest
{

    @Test
    void simpleSanitizeTest()
    {
        String result1 = SimpleSanitizer.simpleSanitize("Hello <b>World</b>");
        String result2 = SimpleSanitizer.simpleSanitize("Hello <h1><b>World</b></h2>");
        String result3 = SimpleSanitizer.simpleSanitize("Hello <h1> <b>World</b> </h2>");
        String result4 = SimpleSanitizer.simpleSanitize("Hello  <h1>   <b>World </b>   </h2>   ");
        assertEquals("Hello World", result1);
        assertEquals("Hello World", result2);
        assertEquals("Hello World", result3);
        assertEquals("Hello World", result4);
    }
}