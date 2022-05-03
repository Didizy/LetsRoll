package com.example.letroll;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DicesAdapter extends RecyclerView.Adapter<DicesAdapter.DiceViewHolder> {

    public int numberItems;

    public DicesAdapter(int numberOfItems) {
        numberItems = numberOfItems;
    }

    @NonNull
    @androidx.annotation.NonNull
    @Override
    public DiceViewHolder onCreateViewHolder(@NonNull @androidx.annotation.NonNull ViewGroup parent, int i) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.dice_item;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);
        DiceViewHolder viewHolder=new DiceViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @androidx.annotation.NonNull DiceViewHolder diceViewHolder, int i) {
        diceViewHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        return numberItems;
    }

    class DiceViewHolder extends RecyclerView.ViewHolder {

        TextView diceName;
        TextView diceCounter;

        public DiceViewHolder(@NonNull @androidx.annotation.NonNull View itemView) {
            super(itemView);

            diceName = itemView.findViewById(R.id.rv_dice_item_name);
            diceCounter = itemView.findViewById(R.id.rv_dice_item_counter);
        }

        void bind(int name) {
            diceName.setText(String.valueOf(name));
        }
    }
}
