package com.example.sleep

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var sheepCount = 0
    var mp: MediaPlayer ?= null

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

        greeting += "ねむれませんか？"

        textview.text = greeting
        mp = MediaPlayer.create(applicationContext, R.raw.sheep_cry1)

        rootLayout.setOnClickListener {
            sheepCount++
            val sheepText = "ひつじが$sheepCount 匹"
            textview.text = sheepText

            when(sheepCount % 2) {
                0 -> {
                    imageView1.setImageResource(R.drawable.sheep_1)
                    mp?.start()
                }
                else -> imageView1.setImageResource(R.drawable.sheep_2)
            }
        }
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        textview.text = "前回は$sheepCount 回羊を数えました。"
    }


}
