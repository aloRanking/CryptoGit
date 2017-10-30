package com.alo.cryptogit;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog pDialog;
    private String TAG = MainActivity.class.getSimpleName();
    String currencies = "NGN,USD,EUR,GBP,RUB,KWD,BHD,EGP,INR,KES,CNY,AUD,ZAR,CHF,SAR,JPY,CAD,BGN,CLP,OMR,QAR";
    private String URL_DATA = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=ETH,BTC&tsyms=" + currencies;

    private List<CurrencyItems> currencyItemsList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currencyItemsList = new ArrayList<>();
    }

    public void goBitcoin(View view){

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            Intent intent = new Intent(this, Bitcoin.class);
            startActivity(intent);
        } else {
            Toast.makeText(this,"No Internet Connection",Toast.LENGTH_SHORT).show();
        }



    }

    public void goEtherium(View view){
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

                Intent i = new Intent(this, Etherium.class);
            startActivity(i);

        } else {
            Toast.makeText(this,"No Internet Connection",Toast.LENGTH_SHORT).show();
        }



    }


}
