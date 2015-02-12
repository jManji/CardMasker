package com.bcsg.cardmasker;

/**
 * With this masker, only the first four digits are going to be visible.
 */
public class ShowFirstFourMasker implements ICardMasker {
    
    @Override
    public String mask(String cardNumber) {
        return cardNumber.substring(0, 4) + "-xxxx-xxxx-xxxx";
    }
}
