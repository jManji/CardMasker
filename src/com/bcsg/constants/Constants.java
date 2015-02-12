package com.bcsg.constants;

public class Constants {

    public static final String SEPARATOR = ",";
    public static final String DATE_FORMAT = "MMM-yyyy";
    
    public enum BankName {
        HSBCCA ("HSBC Canada"),
        RBC ("Royal Bank of Canada"),
        AMEX ("American Express");
    
        private final String name;       
    
        private BankName(String name) {
            this.name = name;
        }
    
        public boolean equalsName(String otherName) {
            return (otherName == null) ? false : name.equals(otherName);
        }
    
        public String toString() {
           return name;
        }
    }
    
}
