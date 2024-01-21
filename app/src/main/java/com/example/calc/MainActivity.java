package com.example.calc;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "Calc";
    private Model model = null;
    private TextView resText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        model = new ViewModelProvider(
                this,
                ViewModelProvider.Factory.from(Model.initializer)
        ).get(Model.class);


        resText = findViewById(R.id.result);
        // Create the observer which updates the UI.
        final Observer<String> resObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newResult) {
                // Update the UI, in this case, a TextView.
                resText.setText(newResult);
            }
        };
        model.getResult().observe(this, resObserver);


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
            numButton[i] = new NumButton(findViewById(ids[i]), i, model);
        }

        notNumButton[] NotNumButton = new notNumButton[5];
        int[] ops = new int[] {
                R.id.addButton,
                R.id.minusButton,
                R.id.multButton,
                R.id.divButton,
                R.id.equalsButton
        };
        for (int i = 0; i < 5; i++) {
            Button b = findViewById(ops[i]);
            NotNumButton[i] = new notNumButton(b, b.getText().toString(), model);
        }

        findViewById(R.id.clearButton).setOnClickListener(v -> {
            model.clearAll();
        });

    }
}