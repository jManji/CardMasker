package com.bcsg.cardvalidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * With this validator, card numbers need to be 15 digits, with dashes every 4 
 * digits. example:
 * 1234-5678-1234-567
 */
public class FifteenDigitsWithDashesValidator implements ICardValidator {

    private final String formatSpecifier = "[0-9]{4}-?[0-9]{4}-?[0-9]{4}-?[0-9]{3}";
    private final Pattern formatToken = Pattern.compile(formatSpecifier);

    @Override
    public boolean isValid(String cardNumber) {
        final Matcher matcher = formatToken.matcher(cardNumber);
        return matcher.matches();
    }
}
