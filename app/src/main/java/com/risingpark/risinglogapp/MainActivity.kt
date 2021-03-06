package com.risingpark.risinglogapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.risingpark.risinglog.RisingLog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RisingLog.apply {
            TAG = "RisingLog"
            isDebug = true
            isShowClassMethod = true
        }

        RisingLog.d("Hello RisingLog")
        RisingLog.e("TAG","Hello RisingLog")

        val jsonStr = "{\"json-array\": [{\"key\": \"value\"} ], \"json-object\": {\"key\": \"value\"} }"
        RisingLog.j(jsonStr)
    }
}