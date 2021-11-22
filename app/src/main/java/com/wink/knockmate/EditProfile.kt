package com.wink.knockmate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class EditProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_profile)

        val userName : EditText = findViewById(R.id.user_name) // 이름
        val userPhoneNum : EditText = findViewById(R.id.user_phoneNum) // 연락처
        val userEmail : EditText = findViewById(R.id.user_email) // 이메일
        val userNickName : EditText = findViewById(R.id.user_nickName) // 닉네임
        val userBirth : EditText = findViewById(R.id.user_birth) // 생년월일
        val userIntroduce : EditText = findViewById(R.id.user_introduce) // 자기 소개
        val radioGroup : RadioGroup = findViewById(R.id.radio_group)

        // 서버에서 회원 정보 받아와서 EditText에 표시

        findViewById<Button>(R.id.edit_button).setOnClickListener {
            // EditText에 쓰여있는 내용 서버로 전달

            // 프레퍼런스에 알림 On/Off 저장
            val checkedRadio = radioGroup.checkedRadioButtonId
            val checkedButton : RadioButton = findViewById(checkedRadio)
            val pref = getSharedPreferences("notification", MODE_PRIVATE)
            val editor = pref.edit()
            if(checkedButton.text.toString() == "수신 동의"){
                editor.putBoolean("notice", true) // 알림 수신 동의
            } else{
                editor.putBoolean("notice", false) // 알림 수신 거부
            }
            editor.apply()

            val intent = Intent(this,UserSetting::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.withdraw_button).setOnClickListener {
            // 서버에서 회원 정보 삭제

            val intent = Intent(this,UserSetting::class.java)
            startActivity(intent)
        }
    }
}