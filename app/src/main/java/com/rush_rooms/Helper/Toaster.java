package com.rush_rooms.Helper;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;



import com.google.android.material.snackbar.Snackbar;

import com.rush_rooms.Managers.BaseManager.ApplicationManager;
import com.rush_rooms.R;

public class Toaster {

    public static void toast1(String message) {
        message = (message == null) ? "" : message;
        Toast.makeText(ApplicationManager.getContext(), message, Toast.LENGTH_SHORT).show();
    }


    public static void toast(Context context,String message) {
        Toast.makeText(context, String.valueOf(message), Toast.LENGTH_SHORT).show();
    }

    public static void toastRangeen(String message) {
        message = (message == null) ? "" : message;
        Context context = ApplicationManager.getContext();
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.custom_toast, null);
        TextView text = (TextView) layout.findViewById(R.id.toast_text);

        Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER, 0, 45);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        text.setText(message);
        toast.show();
    }


    public static void kalaToast(String message) {
        message = (message == null) ? "" : message;
        Context context = ApplicationManager.getContext();
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.custom_toast, null);
        TextView text = (TextView) layout.findViewById(R.id.toast_text);
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.TOP, 0, 45);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        text.setText(message);
        toast.show();
    }


    public static void customToast(String message) {
        message = (message == null) ? "" : message;
        Context context = ApplicationManager.getContext();
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.custom_toast, null);
        TextView tvMessage = (TextView) layout.findViewById(R.id.toast_text);

        //Creating the Toast object
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setView(layout);
        tvMessage.setText(message);
        toast.show();
    }

    public static void showSnack(View view, String message) {
        Snackbar snackbar = Snackbar
                .make(view, message + "", Snackbar.LENGTH_LONG);
        snackbar.show();
    }

//    public static void toastOTP(String s) {
//        //comment it out when in release mode
//        toast1("OTP: " +s);
//    }
}
