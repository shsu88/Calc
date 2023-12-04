package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "Calc";
    private Model model = new Model();
    private TextView resText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resText = findViewById(R.id.result);
        resText.setText(model.getResult());

        NumButton[] numButton = new NumButton[10];
        int[] ids = new int[] {
                R.id.num0,
                R.id.num1,
                R.id.num2,
                R.id.num3,
                R.id.num4,
                R.id.num5,
                R.id.num6,
                R.id.num7,
                R.id.num8,
                R.id.num9
        };
        for (int i = 0; i < 10; i++) {
            numButton[i] = new NumButton(findViewById(ids[i]), i, model, resText);
        }

    }
}