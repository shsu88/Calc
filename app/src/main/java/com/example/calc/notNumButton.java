package com.example.calc;

import android.widget.Button;

public class notNumButton {
    private Button b;
    private String op;
    private Model model;
    public notNumButton (Button raw, String operate, Model m) {
        b = raw;
        op = operate;
        model = m;
        b.setOnClickListener(v -> {
            model.calculate(op);
        });
    }
}
