package com.bcsg.cardvalidator;

/**
 * An interface for validating card number
 */
public interface ICardValidator {
        
    public abstract boolean isValid(String number);
}
