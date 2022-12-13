import java.util.regex.Pattern;

public class CheckIfCommandStop {
    public boolean check(CharSequence code) {
        return Pattern.matches("STOP", code);
    }
}
