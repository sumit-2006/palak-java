import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StockDataFetcher {
    public static void main(String[] args) {
        String apiKey = "TJWGVM9QUQ5RSHIC";
        String symbol = "AAPL"; // Replace with the stock symbol you want to fetch.

        HttpClient httpClient = HttpClients.createDefault();
        try {
            String url = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=" + symbol
                    + "&interval=1min&apikey=" + apiKey;
            HttpGet request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);

            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
