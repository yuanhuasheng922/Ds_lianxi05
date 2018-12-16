package com.example.yuan.jiguang;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class Myservice extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals("cn.jpush.android.intent.NOTIFICATION_OPENED"))
        {
        Intent intent2=new Intent(context,Main2Activity.class);
        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);

        context.startActivity(intent2);
        }
    }
}
