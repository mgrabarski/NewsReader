package mateusz.grabarski.newsreader.utils;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by MGrabarski on 28.11.2017.
 */
public class DateUtilsTest {

    String correctInputDate1 = "2017-11-28T13:00:30Z";
    String correctOutPutDate1 = "Wt, 28 11 2017 13:00";

    @Test
    public void formatApiDate_correctDate_outputCorrectDate() {
        String output = DateUtils.formatApiDate(correctInputDate1);

        assertEquals(correctOutPutDate1, output);
    }

    @Test
    public void formatApiDate_nullInput_outputNull() {
        assertNull(DateUtils.formatApiDate(null));
    }
}