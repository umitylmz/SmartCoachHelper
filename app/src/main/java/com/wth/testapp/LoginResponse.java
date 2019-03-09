package com.wth.testapp;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;

public class LoginResponse {
    public static ArrayList<String> tokens = new ArrayList<>();


    @SerializedName("EmailAddress")
    public String userName;

    @Override
    public String toString() {

        Log.e("POSTLOGIN_MODEL" , userName+"||");
        return "{\n" +
                "  \"credentials\" : {\n" +
                "    \"identifier\": \""+userName+"\",\n" +
                "      \"password\":\"12345678\"},\n" +
                "  \n" +
                "  \"deviceCommand\" : {\n" +
                "    \"deviceId\" :\"0\", \n" +
                "    \"deviceType\":\"Android\",\n" +
                "    \"osVersion\":\"10.3.3\",\n" +
                "    \"appVersion\": \"1.0.0\",\n" +
                "    \"model\":\"Note 4\",\n" +
                "    \"language\":\"tr-tr\"\n" +
                "  }\n" +
                "}";

    }


    public static void addList(String s){
        tokens.add(s);
    }
}