package com.hasanbilgin.bankaapp.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.hasanbilgin.bankaapp.Models.SendMoneyModel;

import com.hasanbilgin.bankaapp.Views.SendMoney.*;
import com.hasanbilgin.bankaapp.Views.SendMoney.SendMoneyFragment;
import com.hasanbilgin.bankaapp.databinding.SendMoneyRowBinding;


import java.util.ArrayList;
import java.util.List;

public class SendMoneyAdapter extends RecyclerView.Adapter<SendMoneyAdapter.PlaceHolder> {

    private ArrayList<SendMoneyModel> sendMoneyModelList;
    private String recyclerViewName;
    private ItemClickListener itemClickListener;

    public SendMoneyAdapter(ArrayList<SendMoneyModel> sendMoneyModelList, String recyclerViewName, ItemClickListener itemClickListener) {
        this.sendMoneyModelList = sendMoneyModelList;
        this.recyclerViewName = recyclerViewName;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public PlaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        SendMoneyRowBinding recyclerRowBinding = SendMoneyRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new PlaceHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceHolder holder, int position) {
        holder.binding.sendMoneyRecyclerTextView.setText(sendMoneyModelList.get(position).name);
        //adapter şart atılcak
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recyclerViewName == "transferTransactionsRecyclerView") {
                    itemClickListener.onItemClick(sendMoneyModelList.get(position).id, recyclerViewName);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return sendMoneyModelList.size();
    }

    public class PlaceHolder extends RecyclerView.ViewHolder {
        SendMoneyRowBinding binding;

        public PlaceHolder(SendMoneyRowBinding sendMoneyRowBinding) {
            super(sendMoneyRowBinding.getRoot());
            this.binding = sendMoneyRowBinding;
        }

    }

    public interface ItemClickListener {
        void onItemClick(int id, String recyclerViewName);
    }
}
