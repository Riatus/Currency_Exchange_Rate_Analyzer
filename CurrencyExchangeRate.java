import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;

public class CurrencyExchangeRate {
    public static void main(String[] args) throws IOException, InterruptedException {
        LocalDate currentDate = LocalDate.of(2014, 1, 1);
        LocalDate lastDate = LocalDate.of(2014, 12 , 31);
        String page1= "";
        PageDownloader downloader = new PageDownloader();

        while (currentDate.isBefore(lastDate)) {
            String day = withZero(currentDate.getDayOfMonth());
            String month = withZero(currentDate.getMonthValue());
            String year = String.valueOf(currentDate.getYear());
            String dateForUrl = day + "/"+ month + "/"+ year;
            String page = downloader.downloadWebPage( " https://www.cbr.ru/scripts/XML_dynamic.asp?date_req1=" + dateForUrl + "&date_req2=" + dateForUrl + "&VAL_NM_RQ=R01235");
            Thread.sleep(1000);
            int startIndex = page.lastIndexOf("<Value>");
            if (startIndex != -1) {
                int endIndex = page.lastIndexOf("</Value>");
                String courseStr = page.substring(startIndex + 7, endIndex);
                System.out.println(currentDate + ": " + courseStr);
            }
            currentDate= currentDate.plusDays(1);
        }
    }
    static String withZero(int value){
        if(value<10){
            return "0" + value;
        }else{
            return String.valueOf(value);
        }
    }


}

