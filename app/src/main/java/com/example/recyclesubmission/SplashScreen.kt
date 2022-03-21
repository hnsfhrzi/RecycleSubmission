package com.example.recyclesubmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val durationSplash = 2000L

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val imgSplash:ImageView = findViewById(R.id.img_splash)
        imgSplash.alpha = 0f
        imgSplash.animate().setDuration(durationSplash).alpha(1f).withEndAction{
            val mainMovedIntent = Intent(this, MainActivity::class.java)
            startActivity(mainMovedIntent)
            overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in, androidx.appcompat.R.anim.abc_fade_out)
            finish()
        }
    }
}