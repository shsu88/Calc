package com.example.calc;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.ViewModelInitializer;

public class Model extends ViewModel {
    private MutableLiveData<String> currentResult;
    private Compute c = new Compute();


    public void addDigit(String d) {
        c.addDigit(d);
        getResult();
    }

    public void calculate(String op) {
        c.calculate(op);
        getResult();
    }

    public void clearAll() {
        c.clearAll();
        getResult();
    }

    public void addDec() {
        c.addDec();
        getResult();
    }

    public MutableLiveData<String> getResult() {
        if (currentResult == null) {
            currentResult = new MutableLiveData<String>("0");
        } else {
            currentResult.setValue(c.getResult());
        }
        return currentResult;
    }


    static final ViewModelInitializer<Model> initializer = new ViewModelInitializer<>(
            Model.class,
            creationExtras -> {
                return new Model();
            }
    );
}
