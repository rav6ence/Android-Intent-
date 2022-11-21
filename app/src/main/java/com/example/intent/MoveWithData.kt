package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MoveWithData : AppCompatActivity(), View.OnClickListener {

    companion object{
        const val Extra_Text = "EXTRA TEKS"
    }
    private lateinit var tvReceiver : TextView
    private lateinit var btnIntentKembali : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        tvReceiver = findViewById(R.id.tv_data_move)

        val textReceived = intent.getStringExtra(Extra_Text)
        val text = "Teks yang diterima : $textReceived"

        tvReceiver.text = text

        btnIntentKembali = findViewById(R.id.btn_kembali)
        btnIntentKembali.setOnClickListener(this)
    }

    override fun onClick(v: View){
        when (v.id){
            R.id.btn_kembali -> {
                val IntentKembali = Intent(this@MoveWithData, MainActivity::class.java)
                startActivity(IntentKembali)
            }
        }
    }
}