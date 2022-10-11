import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class RatingIncrease {
    public static void main(String[] args) {
        String s = "https://www.wildberries.ru/catalog/97602601/detail.aspx?targetUrl=EX";
        URL url = null;
        HttpURLConnection httpURLConnection = null;
        try {
            url = new URL(s);
        } catch (MalformedURLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(e.getLocalizedMessage());
            }
            try {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                System.out.println(e.getLocalizedMessage());
            }
            try {
                InputStream in = null;
                try {
                    in = httpURLConnection.getInputStream();
                } catch (IOException e) {
                    System.out.println(e.getLocalizedMessage());
                }
                Scanner scanner = new Scanner(in);
                scanner.useDelimiter("\\A");
                boolean hasInput = scanner.hasNext();
                if(hasInput) {
//                    System.out.println(scanner.next());
                }
            } finally {
                httpURLConnection.disconnect();
            }
        }
    }
}
