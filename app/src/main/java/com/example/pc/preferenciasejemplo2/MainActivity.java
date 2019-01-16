package com.example.pc.preferenciasejemplo2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;
    RadioButton radio4;
    RadioButton radio5;
    RadioGroup radiog1;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radio1 = findViewById(R.id.radioButton);
        radio2 = findViewById(R.id.radioButton2);
        radio3 = findViewById(R.id.radioButton3);
        radio4 = findViewById(R.id.radioButton4);
        radio5 = findViewById(R.id.radioButton5);
        radiog1 = findViewById(R.id.radioGroup1);
        prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);
        String variableCiudad = prefs.getString("Ciudad", null);
        if(variableCiudad.equals("Sevilla"))
        {
            radio1.setChecked(true);
        }
        else if(variableCiudad.equals("Madrid"))
        {
            radio2.setChecked(true);
        }
        else if(variableCiudad.equals("Asturias"))
        {
            radio3.setChecked(true);
        }
        else if(variableCiudad.equals("Segovia"))
        {
            radio4.setChecked(true);
        }
        else if(variableCiudad.equals("Barcelona"))
        {
            radio5.setChecked(true);
        }
        else
        {
            radio1.setChecked(true);
        }
        radiog1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                SharedPreferences.Editor editor = prefs.edit();
                String ciudad="";
                if(radio1.isChecked())
                {
                    ciudad="Sevilla";
                }
                else if(radio2.isChecked())
                {
                    ciudad="Madrid";
                }
                else if(radio3.isChecked())
                {
                    ciudad="Asturias";
                }else if(radio4.isChecked())
                {
                    ciudad="Segovia";
                }
                else if(radio5.isChecked())
                {
                    ciudad="Barcelona";
                }
                editor.putString("Ciudad", ciudad);
                editor.commit();
            }
        });
    }
}
