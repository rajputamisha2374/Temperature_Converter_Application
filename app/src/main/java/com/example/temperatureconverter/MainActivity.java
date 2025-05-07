package com.example.temperatureconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText celcius, fahrenheit;
    Button ctof, ftoc;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        celcius=findViewById(R.id.celcius);
        fahrenheit=findViewById(R.id.fahrenheit);
        ctof = findViewById(R.id.ctof);
        ftoc = findViewById(R.id.ftoc);
        display = findViewById(R.id.display);

        ctof.setOnClickListener(v -> ctof());
        ftoc.setOnClickListener(v -> ftoc());
    }
    public void ctof(){
        double celciusValue = Double.parseDouble(celcius.getText().toString());

        double fahrenheitValue = (celciusValue*(9.0/5.0)) +32;
        display.setText(String.valueOf(fahrenheitValue));

    }
    public void ftoc(){

        double fahrenheitValue = Double.parseDouble(fahrenheit.getText().toString());
        double celciusValue = (fahrenheitValue - 32)*(5.0/9.0);
        display.setText(String.valueOf(celciusValue));

    }
}