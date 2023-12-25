package com.example.calc;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;

import javax.xml.transform.Result;

public class ResultTextView extends AppCompatTextView {

    public ResultTextView(Context context) {
        super(context);
    }

    public ResultTextView(Context context, AttributeSet set) {
        super(context, set);
    }

    private Model model;

    public void setModel(Model m) {
        model = m;
    }
    public void update() {
        this.setText(model.getResult());
    }
}
