package mateusz.grabarski.newsreader.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by MGrabarski on 27.11.2017.
 */

public class DateUtils {

    public static String formatApiDate(String apiDate) {

        if (apiDate == null)
            return null;

        try {
            String inputDateFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";
            String outDateFormat = "EEE, d MM yyyy HH:mm";

            SimpleDateFormat inputFormat = new SimpleDateFormat(inputDateFormat, Locale.getDefault());
            SimpleDateFormat outputFormat = new SimpleDateFormat(outDateFormat, Locale.getDefault());

            Date inputDate = inputFormat.parse(apiDate);
            return outputFormat.format(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return apiDate;
    }
}
