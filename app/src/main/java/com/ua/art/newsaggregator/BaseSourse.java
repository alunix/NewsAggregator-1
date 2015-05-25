package com.ua.art.newsaggregator;

import java.util.ArrayList;

public class BaseSourse {

    public static ArrayList<String[]> selectSourceArr = new ArrayList<>();

    public static ArrayList<String> idSelectSourceArr = new ArrayList<>();       // id Source
    public static ArrayList<String> nameSelectSourceArr = new ArrayList<>();       // name Source
    public static ArrayList<String> imgSelectSourceArr = new ArrayList<>();    // img-logo Source

    public BaseSourse() {

//        idSelectSourceArr = new ArrayList<>();
//        nameSelectSourceArr = new ArrayList<>();
//        imgSelectSourceArr = new ArrayList<>();


    }

    public static void addBaseNews() {
        idSelectSourceArr.add("ukr_net");
        idSelectSourceArr.add("112");
        idSelectSourceArr.add("pdynPluaOdyn");
        idSelectSourceArr.add("ctb");

        idSelectSourceArr.add("ukr_net");
        idSelectSourceArr.add("112");
        idSelectSourceArr.add("onePlusOne");
        idSelectSourceArr.add("onePlusOne");
        idSelectSourceArr.add("onePlusOne");


        nameSelectSourceArr.add("ukr.net");
        nameSelectSourceArr.add("112");
        nameSelectSourceArr.add("1+1");
        nameSelectSourceArr.add("ctb");

        nameSelectSourceArr.add("ukr.net");
        nameSelectSourceArr.add("112");
        nameSelectSourceArr.add("1+1");
        nameSelectSourceArr.add("1+1");
        nameSelectSourceArr.add("1+1");

        imgSelectSourceArr.add("@drawable/abc_btn_switch_to_on_mtrl_00012");
        imgSelectSourceArr.add("@drawable/abc_btn_switch_to_on_mtrl_00012");
        imgSelectSourceArr.add("@drawable/abc_btn_switch_to_on_mtrl_00012");
        imgSelectSourceArr.add("@drawable/abc_btn_switch_to_on_mtrl_00012");

        imgSelectSourceArr.add("@drawable/abc_btn_switch_to_on_mtrl_00012");
        imgSelectSourceArr.add("@drawable/abc_btn_switch_to_on_mtrl_00012");
        imgSelectSourceArr.add("@drawable/abc_btn_switch_to_on_mtrl_00012");
        imgSelectSourceArr.add("@drawable/abc_btn_switch_to_on_mtrl_00012");
        imgSelectSourceArr.add("@drawable/abc_btn_switch_to_on_mtrl_00012");
    }

//    public static int sizeSourceArr() {
//        return idSelectSourceArr.size();
//    }
//
//    public static ArrayList<String> getIdSelectSourceArr() {
//        return idSelectSourceArr;
//    }
//
//    public static void setIdSelectSourceArr(ArrayList<String> idSelectSourceArr) {
//        BaseSourse.idSelectSourceArr = idSelectSourceArr;
//    }
//
//    public static ArrayList<String> getNameSelectSourceArr() {
//        return nameSelectSourceArr;
//    }
//
//    public static void setNameSelectSourceArr(ArrayList<String> nameSelectSourceArr) {
//        BaseSourse.nameSelectSourceArr = nameSelectSourceArr;
//    }
//
//    public static ArrayList<String> getImgSelectSourceArr() {
//        return imgSelectSourceArr;
//    }
//
//    public static void setImgSelectSourceArr(ArrayList<String> imgSelectSourceArr) {
//        BaseSourse.imgSelectSourceArr = imgSelectSourceArr;
//    }
}