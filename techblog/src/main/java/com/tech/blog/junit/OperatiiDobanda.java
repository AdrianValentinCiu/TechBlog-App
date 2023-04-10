package com.tech.blog.junit;

import static com.tech.blog.junit.TipDobanda.*;

public class OperatiiDobanda {

    private OperatiiDB operatiiDB;

    public OperatiiDobanda() {
    }

    public OperatiiDobanda(OperatiiDB operatiiDB) {
        this.operatiiDB = operatiiDB;
    }

    public double calculDobanda(TipDobanda tipDobanda){
        return mapTipDobanda(tipDobanda);
    }

    public double mapTipDobanda(TipDobanda tipDobanda){
        switch(tipDobanda){
            case MIC:
                return 20.0;
            case MEDIU:
                return 50.0;
            case MARE:
                return 100.0;
        }
        return -1;
    }

    public double dobandaUser(){
        switch(operatiiDB.getUser().getRisk()){
            case RISC_MIC:
                return calculDobanda(MIC);
            case RISC_MEDIU:
                return calculDobanda(MEDIU);
            case RISC_RIDICAT:
                return calculDobanda(MARE);
        }
        return -1;
    }
}
