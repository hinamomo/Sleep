package com.example.sleep

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var greeting = "こんにちは"
        val trialTime = Date()
        val calendar = GregorianCalendar()
        calendar.time = trialTime

        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        if(hour in 1..11){
            greeting = "おはよう"
        } else if (15 < hour) {
            greeting = "こんばんは"
        }

        val sheepNum = 10
        for (i in 1..sheepNum) {
            greeting += "。。。ひつじが" + i + "匹"
        }

        textView.text = greeting
    }
}
