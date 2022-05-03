package com.example.letroll;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.letroll.ui.main.SectionsPagerAdapter;
import com.example.letroll.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private RecyclerView dicesList;
    private DicesAdapter dicesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dicesList=findViewById(R.id.rv_dice);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this    );
        dicesList.setLayoutManager(layoutManager);

        dicesAdapter=new DicesAdapter(10);
        dicesList.setAdapter(dicesAdapter);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = binding.fab;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    public void addDices(View view) {

    }

    public void decreaseDices(View view) {

    }

    public String insertDice(String insert) {
        String correct = null;
        if ((char) insert.charAt(0) == '-') {
            correct = insert;
        } else if ((char) insert.charAt(0) == '0')
            correct = null;
        else
            correct = '+' + insert;

        return correct;
    }

    public void makeRoll(View view) {
        Dice dice = new Dice();
        String request = "+4d12+2-3-6d6+12+2d8-2";
        HashSet<EditText> dices = new HashSet<EditText>();

        dice.doTheDiceRoll(request);
        String result = dice.showResult();

        TextView res_view = findViewById(R.id.res_view);
        res_view.setText(result);
    }
}