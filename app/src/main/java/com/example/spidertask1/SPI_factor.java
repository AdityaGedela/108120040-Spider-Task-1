package com.example.spidertask1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class SPI_factor extends AppCompatActivity {

    Button btn_calculate_spi;
    TextView result_spifactor;
    private static final String TAG = "SPI_factor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spi_calc);

        btn_calculate_spi =  findViewById(R.id.btn_calculate_spifactor);
        result_spifactor =  findViewById(R.id.textview_result_spifactor);
        Calendar cal = Calendar.getInstance();
        btn_calculate_spi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double hour_value = cal.get(Calendar.HOUR);
                double minute_value = cal.get(Calendar.MINUTE);
                double second_value = cal.get(Calendar.SECOND);
                double result_spi;
                double fact=1;//factorial of hours
                while(true)
                {
                    if(hour_value>0)
                    {
                        fact = fact * hour_value;
                        hour_value-=1;
                    }
                    else
                        break;
                }
                result_spi = fact/((Math.pow(minute_value,3))+second_value);

                result_spifactor.setText("CURRENT SPI FACTOR ="+(String.format("%.6f",result_spi))+"");
                Log.d(TAG, "onClick: Sucessfull");


            }
        });
    }
}