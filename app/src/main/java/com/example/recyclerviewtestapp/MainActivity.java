package com.example.recyclerviewtestapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private RecyclerView numbersList;
    private NumbersAdapter numbersAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numbersList = findViewById(R.id.rv_numbers);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        numbersList.setLayoutManager(layoutManager);//создали менеджер, отвечает за способ прокрути
        //и передали его в наш РесВью

        numbersList.setHasFixedSize(true);//Указали что нам известен размер списка

        numbersAdapter = new NumbersAdapter(100, this);//создаем адаптер
        numbersList.setAdapter(numbersAdapter);//кидаем адаптер в лист

    }
}