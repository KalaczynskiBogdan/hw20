package com.example.myapplication.hw20

import android.content.IntentFilter
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R

class TestMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_main)
        startFirstScreen()
    }
    private fun startFirstScreen(){
        val fragment = StartFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.containerMain, fragment)
            .commit()

        registerReceiver(NetworkChanged(), IntentFilter(WifiManager.NETWORK_STATE_CHANGED_ACTION))
    }
}