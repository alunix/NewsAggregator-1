package com.ua.art.newsaggregator;

import java.util.ArrayList;

public class BaseSourse {

    private static ArrayList<String> idSelectSourceArr = new ArrayList<>();         // id Source
    private static ArrayList<String> nameSelectSourceArr = new ArrayList<>();       // name Source
    private static ArrayList<String> imgSelectSourceArr = new ArrayList<>();        // img-logo Source

    public BaseSourse() {
        idSelectSourceArr.add("ukr_net");
        nameSelectSourceArr.add("ukr.net");
        imgSelectSourceArr.add("@drawable/abc_btn_switch_to_on_mtrl_00012");
        idSelectSourceArr.add("112");
        nameSelectSourceArr.add("112");
        imgSelectSourceArr.add("@drawable/abc_btn_switch_to_on_mtrl_00012");
        idSelectSourceArr.add("pdynPluaOdyn");
        nameSelectSourceArr.add("1+1");
        imgSelectSourceArr.add("@drawable/abc_btn_switch_to_on_mtrl_00012");
        idSelectSourceArr.add("ctb");
        nameSelectSourceArr.add("ctb");
        imgSelectSourceArr.add("@drawable/abc_btn_switch_to_on_mtrl_00012");
    }

    public static ArrayList<String> getIdSelectSourceArr() {
        return idSelectSourceArr;
    }
    public static void setIdSelectSourceArr(ArrayList<String> idSelectSourceArr) {
        BaseSourse.idSelectSourceArr = idSelectSourceArr;
    }
    public static ArrayList<String> getNameSelectSourceArr() {
        return nameSelectSourceArr;
    }
    public static void setNameSelectSourceArr(ArrayList<String> nameSelectSourceArr) {
        BaseSourse.nameSelectSourceArr = nameSelectSourceArr;
    }
    public static ArrayList<String> getImgSelectSourceArr() {
        return imgSelectSourceArr;
    }
    public static void setImgSelectSourceArr(ArrayList<String> imgSelectSourceArr) {
        BaseSourse.imgSelectSourceArr = imgSelectSourceArr;
    }
}
