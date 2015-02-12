package com.bcsg.cardvalidator;

import static org.junit.Assert.*;
import org.junit.Test;
import com.bcsg.cardvalidator.FifteenDigitsWithDashesValidator;

public class CardValidatorTest {

    @Test
    public void FifteenDigitsWithDashesValidNumberTest() {
        ICardValidator fifteenDigitsWithDashes = new FifteenDigitsWithDashesValidator();
        assertTrue(fifteenDigitsWithDashes.isValid("1234-5678-1234-567"));
    }
    
    @Test
    public void FifteenDigitsWithDashesMoreDigitsTest() {
        ICardValidator fifteenDigitsWithDashes = new FifteenDigitsWithDashesValidator();
        assertFalse(fifteenDigitsWithDashes.isValid("1234-5678-1234-5678"));
    }
    
    @Test
    public void FifteenDigitsWithDashesLessDigitsTest() {
        ICardValidator fifteenDigitsWithDashes = new FifteenDigitsWithDashesValidator();
        assertFalse(fifteenDigitsWithDashes.isValid("1234-5678"));
    }
    
    @Test
    public void FifteenDigitsWithDashesEmptyTest() {
        ICardValidator fifteenDigitsWithDashes = new FifteenDigitsWithDashesValidator();
        assertFalse(fifteenDigitsWithDashes.isValid(""));
    }
    
    @Test
    public void SixteenDigitsWithDashesValidNumberTest() {
        ICardValidator sixteenDigitsWithDashes = new SixteenDigitsWithDashes();
        assertTrue(sixteenDigitsWithDashes.isValid("1234-5678-1234-5678"));
    }
    
    @Test
    public void SixteenDigitsWithDashesMoreDigitsTest() {
        ICardValidator fifteenDigitsWithDashesTest = 
                                        new SixteenDigitsWithDashes();
        assertFalse(fifteenDigitsWithDashesTest.isValid("1234-5678-1234-56789"));
    }
}
