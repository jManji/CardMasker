package com.bcsg;

import java.text.ParseException;

import com.bcsg.card.Card;
import com.bcsg.card.CardFactory;
import com.bcsg.card.CardManager;
import com.bcsg.exception.CardNumberException;
import com.bcsg.exception.InvalidBankException;

public class BCSGApplication {

    CardManager cardManager;
    
    public static void main(String[] args) {
        
        BCSGApplication app = new BCSGApplication(args);
        app.run();
    }
    
    /**
     * This is the main class of the application. It takes the bank details, as
     * separate csv parameters, and outputs them in descending order, with
     * the card numbers masked.
     * 
     * @param args The bank details, in csv format eg:
     * "HSBC Canada,5601-2345-3446-5678,Nov-2017"
     * "Royal Bank of Canada,4519-4532-4524-2456,Oct-2017"
     * "American Express,3786-7334-8965-345,Dec-2018"
     */
    public BCSGApplication(String[] args) {
        
        cardManager = new CardManager();
        
        for (int i = 0; i < args.length; i++)
        {
            try {
                Card card = CardFactory.createCard(args[i]);
                cardManager.add(card);
            } catch (ParseException | CardNumberException | InvalidBankException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    /**
     * Runs the application. It sorts the cards and displays them with their
     * numbers masked.
     */
    public void run() {
        cardManager.sort();
        cardManager.displayMasked();
    }
}
