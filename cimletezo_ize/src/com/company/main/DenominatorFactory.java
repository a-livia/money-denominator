package com.company.main;

public class DenominatorFactory {
    public Denominator getDenominator(String type){
            switch (type) {
                case "HUF":
                    return new HufDenom();

                case "CUC":
                    return new CucDenom();
            }
            return null;
    }
}
