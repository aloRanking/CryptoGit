package com.alo.cryptogit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by alo on 10/12/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<CurrencyItems>currencyItemsList;
    private Context context;

    public MyAdapter(List<CurrencyItems> currencyItemsList, Context context) {
        this.currencyItemsList = currencyItemsList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.currency_items, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        CurrencyItems items = currencyItemsList.get(position);

        holder.country_codeText.setText(items.getCountry_code());
        holder.currencyText.setText(items.getAmount());
        holder.country.setText(items.getCountry());
    }

    @Override
    public int getItemCount() {
        return currencyItemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView currencyText;
        public TextView country_codeText,country;
        public ViewHolder(View itemView) {
            super(itemView);

            currencyText = (TextView) itemView.findViewById(R.id.currency);
            country_codeText = (TextView) itemView.findViewById(R.id.country_code);
            country = (TextView)itemView.findViewById(R.id.country);
        }
    }


}
