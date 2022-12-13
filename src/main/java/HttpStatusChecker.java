import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {

    String getStatusImage(int inputCode) throws IOException {

        try {
            String baseURL = "https://http.cat/";
            URL url = new URL(baseURL + inputCode);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();

            int responseCode = huc.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_NOT_FOUND) {
                throw new NotHTTPCodeException("Please enter valid HTTP code.");
            } else {
            return String.valueOf(url);
            }
        } catch (IOException | NotHTTPCodeException exception) {
            exception.printStackTrace();
        }
        return "task failed successfully";
    }
}