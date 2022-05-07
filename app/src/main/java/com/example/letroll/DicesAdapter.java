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

//    private int numberItems;
//    private static int viewHolderCount;

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
//        DiceViewHolder holder = new DiceViewHolder(view, new ClickListener() {
//
//            @Override
//            public void countSum(int p) {
//                MainActivity.DiceItem diceItem = diceItems.get(p);
//                int newCount = diceItem.getCount();
//                newCount++;
//                diceItem.setCount(newCount);
//                System.out.println(diceItem.getCount());
//            }
//        });
//        holder.countView.setText("1111");

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
//        ClickListener listener;

        public DiceViewHolder(View view) {
            super(view);
            nameView = view.findViewById(R.id.rv_dice_item_name);
            countView = view.findViewById(R.id.rv_dice_item_counter);
            plusBtn = view.findViewById(R.id.rv_dice_item_btn_plus);
            minusBtn = view.findViewById(R.id.rv_dice_item_btn_minus);

//            this.listener = listener;
//            plusBtn.setOnClickListener(this);

        }

//        public void onClick(View view) {
//            switch (view.getId()) {
//                case R.id.rv_dice_item_btn_plus:
//                    listener.countSum(this.getLayoutPosition());
//                    break;
//                default:
//                    break;
//            }
//        }


    }

//    public interface ClickListener {
//        void countSum(int p);
//    }
//    @NonNull
//    @Override
//    public DiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        Context context = parent.getContext();
//        int layoutIdListItem = R.layout.dice_item;
//
//        LayoutInflater inflater = LayoutInflater.from(context);
//
//        View view = inflater.inflate(layoutIdListItem, parent, false);
//
//        DiceViewHolder viewHolder = new DiceViewHolder(view);
//        viewHolder.viewHolderIndex.setText(viewHolderCount);
//        viewHolderCount++;
//
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull DiceViewHolder holder, int position) {
//        holder.bind(position);
//    }
//
//    @Override
//    public int getItemCount() {
//        return numberItems;
//    }
//
//    class DiceViewHolder extends RecyclerView.ViewHolder {
//
//        TextView listItemDiceView;
//        TextView viewHolderIndex;
//
//        public DiceViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            listItemDiceView = itemView.findViewById(R.id.rv_dice_item_counter);
//            viewHolderIndex = itemView.findViewById(R.id.rv_dice_item_name);//потом удалить, это поле не нужно...наверное
//        }
//
//        void bind(int listIndex) {
//            listItemDiceView.setText(String.valueOf(listIndex));
//        }
//    }

}
