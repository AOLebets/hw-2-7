import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.FileSystems;

public class HttpStatusImageDownloader {

    void downloadStatusImage(int code) {
        try {
            HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
            String forUrl = httpStatusChecker.getStatusImage(code);
            String separator = FileSystems.getDefault().getSeparator();
            URL url = new URL(forUrl);

            InputStream in = new BufferedInputStream(url.openStream());
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int n;
            while (-1!=(n=in.read(buf)))
            {
                out.write(buf, 0, n);
            }
            out.close();
            in.close();
            byte[] response = out.toByteArray();

            FileOutputStream fos = new FileOutputStream("." + separator + "image" + code + ".jpg");
            fos.write(response);
            fos.close();
            System.out.println("Image downloaded to root folder of this program." +
                    "\nAny time you wish to stop write \"STOP\".");
        } catch (IOException e) {
            System.err.println(e);
        }


    }

}
