package com.bcsg.card;

import static com.bcsg.constants.Constants.DATE_FORMAT;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * This class is a container for Cards objects. I can perform various operations
 * on them, like sorting and displaying them. 
 */
public class CardManager {

    private ArrayList<Card> cards = new ArrayList<Card>();
    
    /**
     * Inner class used to compare two dates.
     */
    private class ExpiryDateComparator implements Comparator<Card> {
    
        @Override
        public int compare(Card card1, Card card2) {
            return card2.getDate().compareTo(card1.getDate());
        }
    }
    
    /**
     * Adds a card to the manager.
     * 
     * @param card  The card to be added to the manager
     */
    public void add(Card card) {
        cards.add(card);
    }
    
    /**
     * Sorts the collection by descending order of the expiry dates.
     */
    public void sort() {
        Collections.sort(cards, new ExpiryDateComparator());
    }
    
    /**
     * Displays the contents of the container.
     */
    public void displayMasked() {
        for (Card card : cards) {
            System.out.format("%-23s%-22s%s\n",
                              card.getBank(),
                              card.getMaskedNumber(),
                              new SimpleDateFormat(DATE_FORMAT).
                                                        format(card.getDate()));
        }
    }
    
    /**
     * Used in unit testing
     * 
     * @param index  Index of the card in the container
     * @return  Card reference
     */
    public Card getCard(int index) {
        return cards.get(index);
    }
}
