package com.alo.cryptogit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class BITconversion extends AppCompatActivity {

    private TextView convertRate;

    private EditText base_currency_editext;
    private EditText crypto_currency_editext;
    private TextView country_code;
    private TextView currencies;

    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitconversion);

        convertRate = (TextView) findViewById(R.id.top);
        crypto_currency_editext = (EditText) findViewById(R.id.converted_amount);
        base_currency_editext = (EditText) findViewById(R.id.base_currency);
        country_code = (TextView) findViewById(R.id.countrycode);
        currencies = (TextView) findViewById(R.id.currencies);


        Bundle bundle = getIntent().getBundleExtra("BIT_value");
        if (bundle == null) {
            finish();
        } else {

            String code = bundle.getString("country_code");
            value = bundle.getString("Bit");

            convertRate.setText(value);
            currencies.setText(code);
            country_code.setText(code);


        }

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
            int bitcoin;
            double answer;
            String value2;
            double base_currency;

            bitcoinRate = Float.parseFloat(value);
            bitcoin = 1;
            value2 = crypto_currency_editext.getText().toString();

            if (!value2.isEmpty()) {
                base_currency_editext.removeTextChangedListener(watch2);
                base_currency = Float.parseFloat(value2);
                answer = (base_currency * bitcoinRate) / bitcoin;
                base_currency_editext.setText(String.format(Locale.getDefault(), "%.2f", answer));
                base_currency_editext.addTextChangedListener(watch2);
            }

            if (value2.isEmpty()) {
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
            int bitcoin;
            double answer;
            String value2;
            double base_currency;

            bitcoinRate = Float.parseFloat(value);
            bitcoin = 1;
            value2 = base_currency_editext.getText().toString();

            if (!value2.isEmpty()) {
                crypto_currency_editext.removeTextChangedListener(watch1);
                base_currency = Float.parseFloat(value2);
                answer = (base_currency * bitcoin) / bitcoinRate;
                crypto_currency_editext.setText(String.format(Locale.getDefault(), "%.2f", answer));
                crypto_currency_editext.addTextChangedListener(watch1);
            }

            if (value2.isEmpty()) {
                crypto_currency_editext.removeTextChangedListener(watch1);
                crypto_currency_editext.setText("");
                crypto_currency_editext.addTextChangedListener(watch1);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

   /* public  void toConvert(View view){
        float bitcoinRate = Float.parseFloat(value);
        int bitcoin = 1;
        double answer;

        String value2 = base_currency_editext.getText().toString();
        double base_currency = Float.parseFloat(value2);

        answer = (base_currency * bitcoin)/bitcoinRate;


        base_currency_editext.setText(String.format(Locale.getDefault(),"%.2f", answer));
    } */
}
