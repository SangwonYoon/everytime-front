package com.wink.knockmate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class UserSetting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_setting)

        findViewById<Button>(R.id.edit_profile).setOnClickListener {
            val intent = Intent(this,EditProfile::class.java)
            startActivity(intent)
        }
    }
}