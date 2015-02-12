package com.bcsg.card;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import com.bcsg.exception.CardNumberException;
import com.bcsg.exception.InvalidBankException;

public class CardManagerTest {

    @Test
    public void CorrectSortingCardManagerTest() 
              throws ParseException, CardNumberException, InvalidBankException {
        CardManager cardManager = new CardManager();
        
        Card card1 = CardFactory.createCard("HSBC Canada,5601-2345-3446-5678,Nov-2017");
        cardManager.add(card1);
        
        Card card2 = CardFactory.createCard("HSBC Canada,6201-2645-3747-5178,Nov-2019");
        cardManager.add(card2);
        
        Card card3 = CardFactory.createCard("Royal Bank of Canada,1601-2348-3445-5673,Nov-2018");
        cardManager.add(card3);
        
        Card card4 = CardFactory.createCard("HSBC Canada,1601-2348-3445-5673,Oct-2017");
        cardManager.add(card4);

        Card card5 = CardFactory.createCard("American Express,6401-2248-3565-563,Feb-2012");
        cardManager.add(card5);
        
        Card card6 = CardFactory.createCard("American Express,7601-2248-3565-563,Jan-2014");
        cardManager.add(card6);
        
        cardManager.sort();
        assertEquals(card2, cardManager.getCard(0));
        assertEquals(card3, cardManager.getCard(1));
        assertEquals(card1, cardManager.getCard(2));
        assertEquals(card4, cardManager.getCard(3));
        assertEquals(card6, cardManager.getCard(4));
        assertEquals(card5, cardManager.getCard(5));
    }

}
