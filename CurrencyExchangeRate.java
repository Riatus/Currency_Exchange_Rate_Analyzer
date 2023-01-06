import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class CurrencyExchangeRate {
    public static void main(String[] args) throws IOException {
        String page1= "";
        PageDownloader pageDownloader = new PageDownloader();
        Request request = new Request();

        try {
            page1 = pageDownloader.downloadWebPage(" https://www.cbr.ru/scripts/XML_dynamic.asp?date_req1="+ request.date1()+"&date_req2="+ request.date2()+"&VAL_NM_RQ=R01235");
        }catch (Exception exception){
            throw new CbrNotAvailableException(exception);
        }
        int startIndex1 = page1.lastIndexOf("<Value>");
        int endIndex1 = page1.lastIndexOf("</Value>");
        String courseStr1 = page1.substring(startIndex1+7,endIndex1);
        System.out.println(courseStr1);


    }


}

