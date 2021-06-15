package com.example.spidertask1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

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

public class lorentzfactor_calculator extends AppCompatActivity {
    Button btn_calculate_lrntz;
    Button btn_checklrntz_lrntz_practise;

    TextView result_lrntzfactor;

    TextView result_lrntzfctr_prctse;
    EditText input_speed_lrntzfactor;

    EditText input_speed_lrntzfctr_prctse;
    EditText input_lrntzvalue_lrntzfctr_prctse;
    Vibrator vibrate;

    private static final String TAG = "lorentzfactor_calculato";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lorentz_calc);

        input_speed_lrntzfactor =  findViewById(R.id.plaintext_speedofobject_lorentzfactorcalculator);
        btn_calculate_lrntz = findViewById(R.id.btn_calculate_lorentzfactorcalculator);
        result_lrntzfactor = findViewById(R.id.textview_result_lorentzfactorcalculator);
        btn_calculate_lrntz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double speed_lrntzcalc=Double.parseDouble(input_speed_lrntzfactor.getText().toString());
                double result_lrntz;
                double speedoflight =  3 * Math.pow(10,8);
                if((speed_lrntzcalc<speedoflight)&&(speed_lrntzcalc>(-1*speedoflight)))
                {
                    result_lrntz = 1/Math.pow((1-(Math.pow(speed_lrntzcalc,2)/Math.pow(speedoflight,2))),0.5);
                    result_lrntzfactor.setText("LORENTZ FACTOR ="+(String.format("%.6f",result_lrntz))+"");
                    Log.d(TAG, "onClick: Sucessfull ");

                }
                else
                {
                    result_lrntzfactor.setText("CHECK THE VALUE OF SPEED");
                    Toast.makeText(getApplicationContext(),"ENTER A VALID VALUE FOR SPEED",Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onClick: opened");
                }

            }
        });
        input_speed_lrntzfctr_prctse =  findViewById(R.id.plaintext_speedofobject_lorentzfactor_practisesession);
        input_lrntzvalue_lrntzfctr_prctse =  findViewById(R.id.edittext_lorentzfacvtorvalue_lorentzfactor_practisesession);
        btn_checklrntz_lrntz_practise =  findViewById(R.id.btn_checkanswer_lorentzfactor_practisesession);
        result_lrntzfctr_prctse = findViewById(R.id.textview_result_lorentzfactor_practisesession);
        btn_checklrntz_lrntz_practise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double speed_lrntz_prctse=Double.parseDouble(input_speed_lrntzfctr_prctse.getText().toString());
                double lorentzfactor_prctse= Double.parseDouble(input_lrntzvalue_lrntzfctr_prctse.getText().toString());
                double result_prctse;
                ConstraintLayout layout =  findViewById(R.id.constraintLayout);
                vibrate = (Vibrator)getSystemService(VIBRATOR_SERVICE);

                double SPEED_OF_LIGHT =  3 * Math.pow(10,8);
                double value;
                if((speed_lrntz_prctse<SPEED_OF_LIGHT)&&(speed_lrntz_prctse>(-1*SPEED_OF_LIGHT)))
                {
                    result_prctse = (1/Math.pow((1-(Math.pow(speed_lrntz_prctse,2)/Math.pow(SPEED_OF_LIGHT,2))),0.5));
                    value = Math.abs(lorentzfactor_prctse-result_prctse);
                    if(value<=0.000005)
                    {
                        layout.setBackgroundColor(Color.GREEN);
                        result_lrntzfctr_prctse.setText("CORRECT ANSWER");
                        Log.d(TAG, "onClick: Sucessfull");
                    }
                    else
                    {
                        layout.setBackgroundColor(Color.RED);
                        vibrate.vibrate(1000);
                        result_lrntzfctr_prctse.setText("LORENTZ FACTOR ="+(String.format("%.6f",result_prctse))+"");
                        Log.d(TAG, "onClick: Vibrated");
                    }

                }
                else
                {
                    result_lrntzfctr_prctse.setText("CHECK VALUE OF SPEED");
                    Toast.makeText(getApplicationContext(),"ENTER A VALID VALUE FOR SPEED",Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onClick: Opened");
                }

            }
        });

    }
}