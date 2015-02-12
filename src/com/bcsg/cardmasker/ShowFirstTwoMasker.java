package com.bcsg.cardmasker;

/**
 * With this masker, only the first two digits are going to be visible.
 */
public class ShowFirstTwoMasker implements ICardMasker {
    
    @Override
    public String mask(String cardNumber) {
        return cardNumber.substring(0, 2) + "xx-xxxx-xxxx-xxxx";
    }
}
