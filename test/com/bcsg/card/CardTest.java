package com.bcsg.card;

import static com.bcsg.constants.Constants.DATE_FORMAT;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.bcsg.exception.CardNumberException;
import com.bcsg.exception.InvalidBankException;

public class CardTest {

    @Test
    public void CorrectCardTest() throws ParseException, CardNumberException, InvalidBankException {
        Card card = CardFactory.createCard("HSBC Canada,5601-2345-3446-5678,Nov-2017");
        assertEquals("HSBC Canada", card.getBank());
        assertEquals("5601-2345-3446-5678", card.getNumber());
        String Actualdate = new SimpleDateFormat(DATE_FORMAT).format(card.getDate());
        assertEquals("Nov-2017", Actualdate);
    }
    
    @Test(expected=InvalidBankException.class)
    public void InvalidBankCardTest() throws ParseException, CardNumberException, InvalidBankException {
        @SuppressWarnings("unused")
        Card card = CardFactory.createCard("I_AM_INVALID,5601-2345-3446-5678,Nov-2017");
    }
    
    @Test(expected=CardNumberException.class)
    public void InvaliCardNumberCardTest() throws ParseException, CardNumberException, InvalidBankException {
        @SuppressWarnings("unused")
        Card card = CardFactory.createCard("HSBC Canada,5601-2345-111111,Nov-2017");
    }
    
    @Test(expected=ParseException.class)
    public void InvaliDateCardTest() throws ParseException, CardNumberException, InvalidBankException {
        @SuppressWarnings("unused")
        Card card = CardFactory.createCard("HSBC Canada,5601-2345-3446-5678,INV-2017");
    }

}
