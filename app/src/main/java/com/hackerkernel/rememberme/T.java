package com.hackerkernel.rememberme;

import android.content.Context;
import android.widget.Toast;

public class T {

    public static void show(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
}
