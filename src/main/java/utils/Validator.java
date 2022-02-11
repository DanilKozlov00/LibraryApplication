package utils;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class Validator {

    private final Pattern keyPattern;
    private final Pattern valuePattern;

    public Validator(String keyPattern, String valuePattern) {
        this.keyPattern = Pattern.compile(keyPattern);
        this.valuePattern = Pattern.compile(valuePattern);
    }

    public boolean isValidKey(String key) {
        return keyPattern.matcher(key).matches();
    }

    public boolean isValidValue(String value) {
        return valuePattern.matcher(value).matches();
    }

}
