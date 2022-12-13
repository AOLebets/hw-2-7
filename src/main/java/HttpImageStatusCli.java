import java.util.Scanner;
public class HttpImageStatusCli {

    void askStatus() {

        HttpStatusImageDownloader hsid = new HttpStatusImageDownloader();
        CheckIsAValidHTTPCode httpCodeChecker = new CheckIsAValidHTTPCode();
        CheckIfCommandStop commandStopChecker = new CheckIfCommandStop();

        System.out.println("If you want to download an image, enter HTTP status code. If you don't, enter \"STOP\"." +
                "\nImage would be downloaded to whatever folder this program is stationed in.");

        while (true) {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            if (httpCodeChecker.check(input)) {
                hsid.downloadStatusImage(Integer.parseInt(input));
            } else if (commandStopChecker.check(input)) {
                break;
            } else {
                System.out.println("Please enter valid command.");
            }
        }
    }
}
