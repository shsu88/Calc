package com.example.calc;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.ViewModelInitializer;

public class Model extends ViewModel {
    private String res = "0";
    private String saveOp = "+";
    private String saveRes = "0";
    private MutableLiveData<String> currentResult;


    public void addDigit(String d) {
        if (res.equals("0")) {
            res = "";
        }
        res += d;
        getResult();
    }

    public void calculate(String op) {
        double dres = Double.parseDouble(res);
        double dsave = Double.parseDouble(saveRes);

        if (saveOp.equals("+")) {
            dsave += dres;
        } else if (saveOp.equals("-")) {
            dsave -= dres;
        } else if (saveOp.equals("×")) {
            dsave *= dres;
        } else if (saveOp.equals("÷")) {
            dsave /= dres;
        } else if (saveOp.equals("=")) {
            dsave = dres;
        }
        saveRes = String.valueOf(dsave);
        res = saveRes;
        saveOp = op;
        getResult();
        res = "";
    }

    public void clearAll() {
        saveRes = "";
        saveOp = "+";
        res = "";
        getResult();
    }

    public void addDec() {
        res += ".";
        getResult();
    }

    public MutableLiveData<String> getResult() {
        if (currentResult == null) {
            currentResult = new MutableLiveData<String>("0");
        } else {
            currentResult.setValue(res);
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
