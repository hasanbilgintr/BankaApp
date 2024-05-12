package com.hasanbilgin.bankaapp.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hasanbilgin.bankaapp.Models.MoneyMovementsModel;
import com.hasanbilgin.bankaapp.Other.MainClass;
import com.hasanbilgin.bankaapp.databinding.MoneyMovementsRowBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MoneyMovementsAdapter extends RecyclerView.Adapter<MoneyMovementsAdapter.PlaceHolder> {

    private ArrayList<MoneyMovementsModel> moneyMovementsModelsList;

    public MoneyMovementsAdapter(ArrayList<MoneyMovementsModel> moneyMovementsModels) {
        this.moneyMovementsModelsList = moneyMovementsModels;
    }

    @NonNull
    @Override
    public PlaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        MoneyMovementsRowBinding moneyMovementsRowBinding = MoneyMovementsRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PlaceHolder(moneyMovementsRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceHolder holder, int position) {
        holder.binding.dayTextView.setText(moneyMovementsModelsList.get(position).getTransferDate().substring(8, 10));
        holder.binding.moonTextView.setText(MainClass.getMoon(moneyMovementsModelsList.get(position).getTransferDate().substring(5, 7)));
        holder.binding.hourTextView.setText(moneyMovementsModelsList.get(position).getTransferDate().substring(11,16));
        holder.binding.amountTextView.setText(moneyMovementsModelsList.get(position).getAmount().toString() + " " + moneyMovementsModelsList.get(position).getCurrency());
        holder.binding.transferInfoTextView.setText(moneyMovementsModelsList.get(position).getTransferInfo());


        holder.binding.amountTextView.setText(MainClass.getCommaAndZero(moneyMovementsModelsList.get(position).getAmount().toString()) + " " + moneyMovementsModelsList.get(position).getCurrency());
    }

    @Override
    public int getItemCount() {
        return moneyMovementsModelsList.size();
    }

    public class PlaceHolder extends RecyclerView.ViewHolder {
        MoneyMovementsRowBinding binding;

        public PlaceHolder(MoneyMovementsRowBinding moneyMovementsRowBinding) {
            super(moneyMovementsRowBinding.getRoot());
            this.binding = moneyMovementsRowBinding;
        }

    }
}
