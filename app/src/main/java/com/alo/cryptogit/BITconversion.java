package com.alo.cryptogit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class BITconversion extends AppCompatActivity {

    private EditText base_currency_editext;
    private EditText crypto_currency_editext;

    String xchange_rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitconversion);


        crypto_currency_editext = (EditText) findViewById(R.id.converted_amount);
        base_currency_editext = (EditText) findViewById(R.id.base_currency);

        TextView country_code = (TextView) findViewById(R.id.countrycode);
        TextView currencies = (TextView) findViewById(R.id.currencies);
        TextView convertRate = (TextView) findViewById(R.id.top);


        Bundle bundle = getIntent().getBundleExtra("BIT_value");
        if (bundle == null) {
            finish();
        } else {

            String code = bundle.getString("country_code");
            xchange_rate = bundle.getString("Bit");

            convertRate.setText(xchange_rate);
            currencies.setText(code);
            country_code.setText(code);


        }

        //Adding Textwatcher
        crypto_currency_editext.addTextChangedListener(watch1);
        base_currency_editext.addTextChangedListener(watch2);


    }


    TextWatcher watch1 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            float bitcoinRate;
            int bitcoin= 1;
            double answer;
            String inputValue;
            double base_currency;


            //convert the exchange rate(string) to float for easy calculation
            bitcoinRate = Float.parseFloat(xchange_rate);


            //getting data from the crypto_currency_editext
            inputValue = crypto_currency_editext.getText().toString();

            if (!inputValue.isEmpty()) {

                base_currency_editext.removeTextChangedListener(watch2);

                //converts the input xchange_rate to float
                base_currency = Float.parseFloat(inputValue);
                // exchange rate calculation
                answer = (base_currency * bitcoinRate) / bitcoin;

                base_currency_editext.setText(String.format(Locale.getDefault(), "%.2f", answer));
                base_currency_editext.addTextChangedListener(watch2);
            }

            if (inputValue.isEmpty()) {
                base_currency_editext.removeTextChangedListener(watch2);
                base_currency_editext.setText("");
                base_currency_editext.addTextChangedListener(watch2);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    TextWatcher watch2 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            float bitcoinRate;
            int bitcoin= 1;
            double answer;
            String inputValue;
            double base_currency;

            //convert the xchange rate(string) to float for easy calculation
            bitcoinRate = Float.parseFloat(xchange_rate);

            //getting data from the base_currency_editext
            inputValue = base_currency_editext.getText().toString();

            if (!inputValue.isEmpty()) {
                crypto_currency_editext.removeTextChangedListener(watch1);
                //converts the input xchange_rate to float
                base_currency = Float.parseFloat(inputValue);

                // exchange rate calculation
                answer = (base_currency * bitcoin) / bitcoinRate;

                crypto_currency_editext.setText(String.format(Locale.getDefault(), "%.2f", answer));
                crypto_currency_editext.addTextChangedListener(watch1);
            }

            if (inputValue.isEmpty()) {
                crypto_currency_editext.removeTextChangedListener(watch1);
                crypto_currency_editext.setText("");
                crypto_currency_editext.addTextChangedListener(watch1);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


}
