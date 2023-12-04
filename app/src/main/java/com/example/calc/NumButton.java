package com.example.calc;

import android.widget.Button;
import android.widget.TextView;

public class NumButton {
    private Button b;
    private int index;
    private Model model;

    public NumButton(Button raw, int num, Model m, TextView resText) {
        b = raw;
        index = num;
        model = m;
        b.setOnClickListener(v -> {
            model.addDigit(index);
            resText.setText(model.getResult());
        });
    }
}
