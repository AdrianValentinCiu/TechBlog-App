package com.tech.blog.junit;

public class Main {

    public static void main(String[] args) {
        OperatiiDobanda operatiiDobanda = new OperatiiDobanda();
        System.out.println(operatiiDobanda.mapTipDobanda(TipDobanda.MIC));
        System.out.println(operatiiDobanda.mapTipDobanda(TipDobanda.MEDIU));
        System.out.println(operatiiDobanda.mapTipDobanda(TipDobanda.MARE));

        OperatiiDB operatiiDB = new OperatiiDBImplJunit();
        operatiiDobanda = new OperatiiDobanda(operatiiDB);
        //operatiiDobanda.dobandaUser();
        System.out.println(operatiiDobanda.dobandaUser());
    }
}
