package com.example.calc;

import androidx.lifecycle.MutableLiveData;

public class Compute {
    private String res = "0";
    private String saveOp = "+";
    private String saveRes = "0";
    private String currentResult = "0";


    public void addDigit(String d) {
        if (res.equals("0")) {
            res = "";
        }
        res += d;
        currentResult = res;
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
        currentResult = res;
        res = "";
    }

    public void clearAll() {
        saveRes = "";
        saveOp = "+";
        res = "";
        currentResult = res;
    }

    public void addDec() {
        res += ".";
        currentResult = res;
    }

    public String getResult() {
        return currentResult;
    }
}
