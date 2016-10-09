package ie.nuigalway.ct475.a1.p1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Suavek on 09/10/2016.
 */
public class StudentTest {
    @Test
    public void generateUsername() throws Exception {
        final Student a = new Student("Slawomir Mlynarowicz", "10-10-1984", 12100888);
        final String expected = "SlawomirMlynarowicz32";
        final String actual = a.generateUsername();
        assertEquals(expected, actual);
    }

}