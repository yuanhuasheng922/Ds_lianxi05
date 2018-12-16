package com.example.yuan.ds_lianxi05.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.yuan.ds_lianxi05.view.MainActivity;

public class Myreceice extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("cn.jpush.android.intent.NOTIFICATION_OPENED"))
        {
            Intent intent1=new Intent(context,MainActivity.class);
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent1);
        }
    }
}
