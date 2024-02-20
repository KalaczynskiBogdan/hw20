package com.example.myapplication.hw20

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager

class NetworkChanged : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == WifiManager.NETWORK_STATE_CHANGED_ACTION) {

        }
    }
}
