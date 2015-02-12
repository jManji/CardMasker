package com.bcsg;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.bcsg.cardvalidator.CardValidatorTest;
import com.bcsg.cardmasker.CardMaskerTest;
import com.bcsg.card.CardTest;
import com.bcsg.card.CardManagerTest;

@RunWith(Suite.class)
@SuiteClasses({ CardTest.class, CardManagerTest.class, CardValidatorTest.class,
                CardMaskerTest.class, })
public class AllTests {
    public static void main(String[] args) throws Exception {                    
       JUnitCore.main(
         "com.bcsg.AllTests");
    }
}
