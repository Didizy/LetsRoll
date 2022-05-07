package com.example.letroll;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.letroll.databinding.Fragment2LayoutBinding;

import java.util.ArrayList;

public class Fragment2 extends Fragment {
    static public ArrayList<DiceItem> dices = new ArrayList<DiceItem>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_layout, container, false);

        setInitialData();
        RecyclerView recyclerView = view.findViewById(R.id.rv_dices);
        DicesAdapter adapter = new DicesAdapter(getContext(), dices);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void setInitialData() {
        dices.add(new DiceItem("d4", 0));
        dices.add(new DiceItem("d6", 0));
        dices.add(new DiceItem("d8", 0));
        dices.add(new DiceItem("d10", 0));
        dices.add(new DiceItem("d12", 0));
        dices.add(new DiceItem("d20", 0));
        dices.add(new DiceItem("d00", 0));
    }

}

