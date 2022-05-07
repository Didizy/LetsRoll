package com.example.letroll;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.letroll.databinding.ActivityMainBinding;
import com.example.letroll.databinding.Fragment1LayoutBinding;
import com.example.letroll.databinding.Fragment2LayoutBinding;
import com.example.letroll.ui.main.SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private RecyclerView dicesList;
    private DicesAdapter dicesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
    }

    public String insertDice() {
        String correct = null;

        for (int i = 0; i < Fragment2.dices.size(); i++) {
            correct += "+" + String.valueOf(Fragment2.dices.get(i).getCount()) + Fragment2.dices.get(i).getName();
        }
        TextView res_mod = findViewById(R.id.modifications_count);
        if (res_mod.getText() != "Модификатор") {
            correct += "-" + String.valueOf(res_mod.getText());
        }

        return correct;
    }

    public void makeRoll(View view) {
        Dice dice = new Dice();
        String request = insertDice();
        HashSet<EditText> dices = new HashSet<EditText>();

        dice.doTheDiceRoll(request);
        String result = dice.showResult();

        TextView res_view = findViewById(R.id.res_view);
        res_view.setText(result);
    }

    public void clearHistory(View view) {
        TextView res_view = findViewById(R.id.res_view);
        res_view.setText("История пуста");
    }

    public int sum = 0;

    public void modificatorCountPlus(View view) {
        TextView res_mod = findViewById(R.id.modifications_count);
        sum++;
        System.out.println(sum);
        res_mod.setText(String.valueOf(sum));
    }

    public void modificatorCountMinus(View view) {
        TextView res_mod = findViewById(R.id.modifications_count);
        if (sum > 0) {
            sum--;
        }
        System.out.println(sum);
        res_mod.setText(String.valueOf(sum));
    }
}
