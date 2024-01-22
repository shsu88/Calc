package com.example.calc;

import android.widget.Button;
import android.widget.TextView;

import javax.xml.transform.Result;

public class NumButton {
    private Button b;
    private String index;
    private Model model;

    public NumButton(Button raw, String num, Model m) {
        b = raw;
        index = num;
        model = m;
        b.setOnClickListener(v -> {
            model.addDigit(index);
        });
    }
}
