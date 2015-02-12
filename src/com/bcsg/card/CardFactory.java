package com.bcsg.card;

import static com.bcsg.constants.Constants.SEPARATOR;
import static com.bcsg.constants.Constants.DATE_FORMAT;
import static com.bcsg.constants.Constants.BankName.AMEX;
import static com.bcsg.constants.Constants.BankName.HSBCCA;
import static com.bcsg.constants.Constants.BankName.RBC;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import com.bcsg.cardmasker.ShowFirstFourMasker;
import com.bcsg.cardmasker.ShowFirstTwoMasker;
import com.bcsg.cardmasker.ShowLastThreeMasker;
import com.bcsg.cardvalidator.FifteenDigitsWithDashesValidator;
import com.bcsg.cardvalidator.SixteenDigitsWithDashes;
import com.bcsg.exception.CardNumberException;
import com.bcsg.exception.InvalidBankException;

/**
 * This class is responsible for creating a card object, given the bank. Depending
 * on the bank name, a corresponding card will be returned, using the appropriate
 * validators and maskers. 
 * 
 * This class does not strictly follow the factory pattern, as it does not create
 * separate Card classes. It does follow the composition over inheritance 
 * approach though, as each card is composed of some components/ attributes, 
 * like the validator and the maskers.
 */
public class CardFactory {
    
    private static SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT); 
    
    /**
     * Creates the correct card, according to the bank name
     * 
     * @param  bankDetails  The csv bank details
     * @return The card
     * @throws ParseException
     * @throws CardNumberException
     * @throws InvalidBankException 
     */
    public static Card createCard(String bankDetails) 
                                    throws ParseException, CardNumberException, InvalidBankException {
        
        StringTokenizer st = new StringTokenizer(bankDetails, SEPARATOR);
        String bank = st.nextToken(); 
        String cardNumber = st.nextToken(); 
        String expiryDate = st.nextToken();
        
        return createCard(bank, cardNumber, expiryDate); 
    }
    
    /**
     * Creates the correct card, according to the bank name
     * 
     * @param bank        Bank name
     * @param number      Card number
     * @param expiryDate  Expiration date
     * @return  The card
     * @throws  ParseException
     * @throws  CardNumberException
     * @throws  InvalidBankException 
     */
    public static Card createCard(String bank,
                                  String number,
                                  String expiryDate) 
                                    throws ParseException, CardNumberException, InvalidBankException {
        
        // Convert date string to Date
        Date date = (Date)formatter.parseObject(expiryDate);
        
        // Get the correct card, according to bank
        Card card = getCard(bank, number, date);
        
        // Perform validations
        validate(card);
        
        return card;
    }
    
    /**
     * It checks the bank name, and decides according what kind of card it will
     * instantiate, providing with the appropriate validator and masker.
     * 
     * @param bank   Bank name
     * @param number Card number
     * @param date   Expiration date
     * @return  The card
     * @throws InvalidBankException 
     */
    private static Card getCard(String bank, String number, Date date) throws InvalidBankException {
        
        Card card = new Card(bank, number, date);
        
        if (HSBCCA.equalsName(bank)) {
            card.setComponents(new SixteenDigitsWithDashes(),
                               new ShowFirstTwoMasker());
        } else if (RBC.equalsName(bank)) {
            card.setComponents(new SixteenDigitsWithDashes(),
                               new ShowFirstFourMasker());
        } else if (AMEX.equalsName(bank)) {
            card.setComponents(new FifteenDigitsWithDashesValidator(),
                               new ShowLastThreeMasker());
        } else {
            throw new InvalidBankException("Bank " + bank + " is not a valid bank name");
        }
        
        return card;
    }
    
    /**
     * Perform any necessary validations
     * @param card  Card to be validated
     * @throws CardNumberException
     */
    private static void validate(Card card) throws CardNumberException {
        card.validateNumber();
    }
    
}
