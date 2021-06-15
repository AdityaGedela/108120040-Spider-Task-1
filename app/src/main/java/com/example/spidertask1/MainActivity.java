package com.example.spidertask1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //Buttons
    Button btn_lrntz_hs;// hs-->homescreen
    // prctse -->practise , lrntz-->lorentz
    Button btn_spi_hs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button for Lorentz Factor Calculator.
        btn_lrntz_hs =  findViewById(R.id.btn_lorentzcalc_homescreen);
        btn_lrntz_hs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.lorentz_calc);
                Intent startintent = new Intent(getApplicationContext(),lorentzfactor_calculator.class);
                startActivity(startintent);

            }
        });


        //For SPI factor calculator
        btn_spi_hs = findViewById(R.id.btn_spifactor_homescreen);
        btn_spi_hs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startintent3 = new Intent(getApplicationContext(),SPI_factor.class);
                startActivity(startintent3);

            }
        });

    }

}