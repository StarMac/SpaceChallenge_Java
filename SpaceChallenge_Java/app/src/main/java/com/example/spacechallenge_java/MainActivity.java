package com.example.spacechallenge_java;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtTotalBudgetU1;
    TextView txtTotalBudgetU2;
    Simulation simulation = new Simulation(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTotalBudgetU1 = findViewById(R.id.txtTotalBudgetU1);
        txtTotalBudgetU2 = findViewById(R.id.txtTotalBudgetU2);
        Button button = findViewById(R.id.btnRunSimulation);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {
            runTheSimulation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("SetTextI18n")
    public void runTheSimulation() throws Exception {
        int totalBudgetU1 = simulation.runSimulation(simulation.loadU1(simulation.loadItems(getString(R.string.txtphase1))));
        totalBudgetU1 += simulation.runSimulation(simulation.loadU1(simulation.loadItems(getString(R.string.txtphase2))));
        txtTotalBudgetU1.setText("Budget U1: " + totalBudgetU1 + " million$");

        int totalBudgetU2 = simulation.runSimulation(simulation.loadU2(simulation.loadItems(getString(R.string.txtphase1))));
        totalBudgetU2 += simulation.runSimulation(simulation.loadU2(simulation.loadItems(getString(R.string.txtphase2))));
        txtTotalBudgetU2.setText("Budget U2: " + totalBudgetU2 + " million$");
    }
}