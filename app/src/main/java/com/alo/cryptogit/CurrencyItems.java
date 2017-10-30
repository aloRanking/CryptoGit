package com.alo.cryptogit;

/**
 * Created by alo on 10/11/17.
 */

public class CurrencyItems {

    String country_code, amount, country;

    public CurrencyItems() {
    }

    public CurrencyItems(String country_code, String amount, String country) {
        this.country_code = country_code;
        this.amount = amount;
        this.country = country;

    }

    public String getCountry_code() {
        return country_code;
    }

    public String getAmount() {
        return amount;
    }

    public String getCountry() {
        return country;
    }
}
