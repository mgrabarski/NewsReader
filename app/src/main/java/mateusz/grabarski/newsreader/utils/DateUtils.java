package mateusz.grabarski.newsreader.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by MGrabarski on 27.11.2017.
 */

public class DateUtils {

    public static String formatApiDate(String apiDate) {
        String inputDateFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        String outDateFormat = "EEE, d MM yyyy HH:mm";

        SimpleDateFormat inputFormat = new SimpleDateFormat(inputDateFormat);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outDateFormat);

        try {
            Date inputDate = inputFormat.parse(apiDate);
            return outputFormat.format(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return apiDate;
    }
}
