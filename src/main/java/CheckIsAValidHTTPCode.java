import java.util.regex.Pattern;

public class CheckIsAValidHTTPCode {
    public boolean check(CharSequence code) {
        return Pattern.matches("\\d{1,9}", code);
    }
}
