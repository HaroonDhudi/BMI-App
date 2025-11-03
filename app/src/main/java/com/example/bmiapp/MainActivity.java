package com.example.bmiapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView edtweight, edtheightft, edtheightinch;
        Button btncalculate;
        TextView txtResult;

        edtweight = findViewById(R.id.edtweight);
        edtheightft = findViewById(R.id.edthightinft);
        edtheightinch = findViewById(R.id.edthightinch);
        btncalculate = findViewById(R.id.btncalculate);
        txtResult = findViewById(R.id.txtresult);



        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            int wt = Integer.parseInt( edtweight.getText().toString());
            int ft = Integer.parseInt( edtheightft.getText().toString());
            int inc = Integer.parseInt(edtheightinch.getText().toString());

            int totalinc = ft*12 + inc;
            double totalCm = totalinc*2.53;
            double totalM = totalCm/100;
            double bmi = wt/(totalM*totalM);

            if (bmi>25){
                txtResult.setText("you are over Weight");
            } else if (bmi<18) {
                txtResult.setText("You are Under Height");
            }else {
                txtResult.setText("You are Healthy");
            }


            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}