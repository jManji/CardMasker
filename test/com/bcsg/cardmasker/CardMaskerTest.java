package com.bcsg.cardmasker;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bcsg.cardmasker.ShowFirstFourMasker;
import com.bcsg.cardmasker.ShowFirstTwoMasker;
import com.bcsg.cardmasker.ShowLastThreeMasker;

public class CardMaskerTest {

    @Test
    public void ShowFirstFourMaskerValidMaskTest() {
        ICardMasker showFirstFourMasker = new ShowFirstFourMasker();
        assertEquals("1234-xxxx-xxxx-xxxx", showFirstFourMasker.mask("1234-5678-1234-5678"));
    }
    
    @Test
    public void ShowFirstFourMaskerWrongMaskTest() {
        ICardMasker showFirstFourMasker = new ShowFirstFourMasker();
        assertNotEquals("xxxx-4578-xxxx-xxxx", showFirstFourMasker.mask("1234-5678-1234-5678"));
    }
    
    @Test
    public void ShowFirstTwoMaskerValidMaskTest() {
        ICardMasker showFirstTwoMasker = new ShowFirstTwoMasker();
        assertEquals("12xx-xxxx-xxxx-xxxx", showFirstTwoMasker.mask("1234-5678-1234-5678"));
    }
    
    @Test
    public void ShowFirstTwoMaskerWrongMaskTest() {
        ICardMasker showFirstTwoMasker = new ShowFirstTwoMasker();
        assertNotEquals("xxxx-4578-xxxx-xxxx", showFirstTwoMasker.mask("1234-5678-1234-5678"));
    }

    @Test
    public void ShowLastThreeMaskerValidMaskTest() {
        ICardMasker showLastThreeMasker = new ShowLastThreeMasker();
        assertEquals("xxxx-xxxx-xxxx-567", showLastThreeMasker.mask("1234-5678-1234-567"));
    }
    
    @Test
    public void ShowLastThreeMaskerWrongMaskTest() {
        ICardMasker showLastThreeMasker = new ShowLastThreeMasker();
        assertNotEquals("xxxx-4578-xxxx-xxxx", showLastThreeMasker.mask("1234-5678-1234-5678"));
    }
}
