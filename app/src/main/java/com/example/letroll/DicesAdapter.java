package com.example.letroll;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DicesAdapter extends RecyclerView.Adapter<DicesAdapter.DiceViewHolder> {

    private final LayoutInflater inflater;
    private final List<DiceItem> diceItems;
    private final Context context;

    DicesAdapter(Context context, ArrayList<DiceItem> diceItems) {
        this.diceItems = diceItems;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public DiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.dice_item, parent, false);
        return new DiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiceViewHolder holder, int position) {
        DiceItem diceItem = diceItems.get(position);
        holder.nameView.setText(diceItem.getName());
        holder.countView.setText(String.valueOf(diceItem.getCount()));

        holder.plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = diceItem.getCount();
                sum++;
                diceItem.setCount(sum);
                holder.countView.setText(String.valueOf(diceItem.getCount()));
            }
        });
        holder.minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = diceItem.getCount();
                if (sum > 0) {
                    sum--;
                }
                diceItem.setCount(sum);
                holder.countView.setText(String.valueOf(diceItem.getCount()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return diceItems.size();
    }

    public static class DiceViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView;
        final TextView countView;
        final Button plusBtn;
        final Button minusBtn;

        public DiceViewHolder(View view) {
            super(view);
            nameView = view.findViewById(R.id.rv_dice_item_name);
            countView = view.findViewById(R.id.rv_dice_item_counter);
            plusBtn = view.findViewById(R.id.rv_dice_item_btn_plus);
            minusBtn = view.findViewById(R.id.rv_dice_item_btn_minus);
        }
    }

}
