package com.alo.cryptogit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Etherium extends AppCompatActivity {

    private ProgressDialog pDialog;
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<CurrencyItems> currencyItemsList;

    String currencies = "NGN,USD,EUR,GBP,RUB,KWD,BHD,EGP,INR,KES,CNY,AUD,ZAR,CHF,SAR,JPY,CAD,BGN,CLP,OMR,QAR";
    private String URL_DATA = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=ETH,BTC&tsyms=" + currencies;
    String NGN, USD, EUR, GBP, RUB, KWD, BHD, EGP, INR, KES, CNY, AUD, ZAR, CHF, SAR, JPY, CAD, BGN, CLP, OMR, QAR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etherium);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        currencyItemsList = new ArrayList<>();


        loadRecylerView();

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener
                .OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //handle click events here
                CurrencyItems currencyItems = currencyItemsList.get(position);
                Bundle args = new Bundle();
                args.putString("Eth", currencyItems.getAmount());
                args.putString("country_code", currencyItems.getCountry_code());
                Intent i = new Intent(Etherium.this, ETHconversion.class);
                i.putExtra("ETH_value", args);
                startActivity(i);

            }

            @Override
            public void onItemLongClick(View view, int position) {
                //handle longClick if any
            }
        }));
    }


    public void loadRecylerView() {


        pDialog = new ProgressDialog(Etherium.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        pDialog.dismiss();

                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            String ETH = jsonObject.getString("ETH");
                            JSONObject o = new JSONObject(ETH);

                            NGN = o.getString("NGN");
                            USD = o.getString("USD");
                            EUR = o.getString("EUR");
                            GBP = o.getString("GBP");
                            RUB = o.getString("RUB");
                            KWD = o.getString("KWD");
                            BHD = o.getString("BHD");
                            EGP = o.getString("EGP");
                            INR = o.getString("INR");
                            KES = o.getString("KES");
                            CNY = o.getString("CNY");
                            AUD = o.getString("AUD");
                            ZAR = o.getString("ZAR");
                            CHF = o.getString("CHF");
                            SAR = o.getString("SAR");
                            JPY = o.getString("JPY");
                            CAD = o.getString("CAD");
                            BGN = o.getString("BGN");
                            CLP = o.getString("CLP");
                            OMR = o.getString("OMR");
                            QAR = o.getString("QAR");


                            CurrencyItems currency = new CurrencyItems("NGN", NGN, "NIGERIA");
                            currencyItemsList.add(currency);

                            currency = new CurrencyItems("USD", USD, "USA");
                            currencyItemsList.add(currency);

                            currency = new CurrencyItems("EUR", EUR, "GERMANY");
                            currencyItemsList.add(currency);

                            currency = new CurrencyItems("GBP", GBP, "UK");
                            currencyItemsList.add(currency);

                            currency = new CurrencyItems("RUB", RUB, "RUSSIA");
                            currencyItemsList.add(currency);

                            currency = new CurrencyItems("KWD", KWD, "KUWAIT");
                            currencyItemsList.add(currency);

                            currency = new CurrencyItems("BHD", BHD, "BAHRAIN");
                            currencyItemsList.add(currency);

                            currency = new CurrencyItems("EGP", EGP, "EGYPT");
                            currencyItemsList.add(currency);

                            currency = new CurrencyItems("INR", INR, "INDIA");
                            currencyItemsList.add(currency);

                            currency = new CurrencyItems("KES", KES, "KENYA");
                            currencyItemsList.add(currency);

                            currency = new CurrencyItems("CNY", CNY, "CHINA");
                            currencyItemsList.add(currency);

                            currency = new CurrencyItems("AUD", AUD, "AUSTRALIA");
                            currencyItemsList.add(currency);

                            currency = new CurrencyItems("ZAR", ZAR, "S.AFRICA");
                            currencyItemsList.add(currency);

                            currency = new CurrencyItems("CHF", CHF, "SWITZERLAND");
                            currencyItemsList.add(currency);

                            currency = new CurrencyItems("SAR", SAR, "S.ARABIA");
                            currencyItemsList.add(currency);

                            currency = new CurrencyItems("JPY", JPY, "JAPAN");
                            currencyItemsList.add(currency);

                            currency = new CurrencyItems("CAD", CAD, "CANADA");
                            currencyItemsList.add(currency);

                            currency = new CurrencyItems("BGN", BGN, "BELGIUM");
                            currencyItemsList.add(currency);

                            currency = new CurrencyItems("CLP", CLP, "CHILE");
                            currencyItemsList.add(currency);

                            currency = new CurrencyItems("OMR", OMR, "OMAN");
                            currencyItemsList.add(currency);

                            currency = new CurrencyItems("QAR", QAR, "QATAR");
                            currencyItemsList.add(currency);

                            adapter = new MyAdapter(currencyItemsList, getApplicationContext());
                            recyclerView.setAdapter(adapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getApplicationContext(), "Unable to retrieve information ", Toast.LENGTH_SHORT)
                                .show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }


}
