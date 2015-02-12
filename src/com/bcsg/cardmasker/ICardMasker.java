package com.bcsg.cardmasker;

/**
 * An interface for masking a card
 */
public interface ICardMasker {
    
    /**
     * It takes a card number parameter, and according to the type of masking
     * it returns the masked card number string.
     * 
     * @param cardNumber The card number to be masked
     * @return  The masked number
     */
    public String mask(String cardNumber);
}
