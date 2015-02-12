package com.bcsg.card;

import java.util.Date;

import com.bcsg.cardmasker.ICardMasker;
import com.bcsg.cardvalidator.ICardValidator;
import com.bcsg.exception.CardNumberException;

public class Card {

    private String bank;
    private String number;
    private Date expiryDate;
    private ICardMasker masker;
    private ICardValidator validator;
    
    /**
     * Constructor
     * 
     * @param bank        Bank of the card
     * @param cardNumber  The card number
     * @param expiryDate  Expiry date of the card
     */
    public Card(String bank, String cardNumber, Date expiryDate) {
        this.bank = bank;
        this.number = cardNumber;
        this.expiryDate = expiryDate;
    }
    
    /**
     * Return the bank name
     * 
     * @return  The bank name
     */
    public String getBank() {
        return bank;
    }
    
    /**
     * Return the card number
     * 
     * @return  The card number
     */
    public String getNumber() {
        return number;
    }
    
    /**
     * Returns the expiry date
     * 
     * @return  The expiry date
     */
    public Date getDate() {
        return expiryDate;
    }
    
    /**
     * Adds all the required components for various card functionalities
     * 
     * @param masker     The card number masker that will be used
     * @param validator  The card validator that will be used
     */
    public void setComponents(ICardValidator validator, ICardMasker masker) {
        this.validator = validator;
        this.masker = masker;
    }
    
    /**
     * Returns the masked value of a number
     * 
     * @return  The masked number
     */
    public String getMaskedNumber() {
        return masker.mask(number);
    }

    /**
     * Validates the card number. Throws an exception if invalid
     * 
     * @throws CardNumberException The exception of an invalid card number
     */
    public void validateNumber() throws CardNumberException {
        if (!validator.isValid(number)) {
            throw new CardNumberException("Card number provided for " + bank +
                                          " is invalid");
        }
    }
    
    /**
     * Used for unit testing
     */
    public boolean equals(Object object){
        boolean isEqual = false;
        
        if (object != null && object instanceof Card) {
            Card other = (Card)object;
            isEqual = bank.equals(other.getBank()) &&
                      number == other.getNumber() &&
                      expiryDate == other.getDate();
        }
        return isEqual;
    }
    
}
