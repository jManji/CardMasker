package com.bcsg.cardmasker;

/**
 * With this masker, only the last three digits are going to be visible.
 */
public class ShowLastThreeMasker implements ICardMasker {
    
    @Override
    public String mask(String cardNumber) {
        return "xxxx-xxxx-xxxx-" + cardNumber.substring(cardNumber.length()-3,
                                                        cardNumber.length());
    }
}
