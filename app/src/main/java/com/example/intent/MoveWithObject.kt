package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MoveWithObject : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvReceive: TextView
    private lateinit var btnIntentKembali: Button
    companion object{
        const val ExtraObject = "ExtraObject"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        tvReceive = findViewById(R.id.tv_data_move_object)

        val nameObject = intent.getParcelableExtra<NameObject>(ExtraObject) as NameObject
        val text = "Nama : ${nameObject.nama.toString()}\nUmur: ${nameObject.umur.toString()}\nAlamat: ${nameObject.alamat.toString()}\nNickname: ${nameObject.nickname.toString()}"

        tvReceive.text = text

        btnIntentKembali = findViewById(R.id.btn_kembali)
        btnIntentKembali.setOnClickListener(this)
    }

    override fun onClick(v: View){
        when (v.id){
            R.id.btn_kembali -> {
                val IntentKembali = Intent(this@MoveWithObject, MainActivity::class.java)
                startActivity(IntentKembali)
            }
        }
    }
}