package com.example.calc;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.ViewModelInitializer;

public class Model extends ViewModel {
    private double res = 0;
    private MutableLiveData<String> currentResult;


    public void addDigit(int d) {
        res = res * 10 + d;
        getResult();
    }

    public MutableLiveData<String> getResult() {
        if (currentResult == null) {
            currentResult = new MutableLiveData<String>("0");
        } else {
            currentResult.setValue(String.format("%.0f", res));
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
