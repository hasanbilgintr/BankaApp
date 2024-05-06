package com.hasanbilgin.bankaapp.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hasanbilgin.bankaapp.Models.SendMoneyModel;
import com.hasanbilgin.bankaapp.databinding.SendMoneyRowBinding;


import java.util.ArrayList;
import java.util.List;

public class SendMoneyAdapter extends RecyclerView.Adapter<SendMoneyAdapter.PlaceHolder> {

    ArrayList<SendMoneyModel> sendMoneyModelList;

    public SendMoneyAdapter(ArrayList<SendMoneyModel> sendMoneyModelList) {
        this.sendMoneyModelList = sendMoneyModelList;
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
//                Intent intent = new Intent(holder.itemView.getContext(), MapsActivity.class);
//                intent.putExtra("info", "old");
//                // placeList.get(position) gönderilmeye çalışıldığında modele Place.java yani  public class Place implements Serializable yapıldı
//                intent.putExtra("place", placeList.get(position));
//                holder.itemView.getContext().startActivity(intent);
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
}
