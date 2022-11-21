package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.view.View
import android.widget.Button
import android.widget.RadioGroup

class HasilAtivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var rgPilih : RadioGroup
    private lateinit var btnPilih : Button

    companion object {
        val RESULT_CODE = 210
        val EXTRA_PILIH = "Extra Pilih"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil_ativity)

        rgPilih = findViewById(R.id.radio_1)
        btnPilih = findViewById(R.id.btn_result)

        btnPilih.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_result) {
            if (rgPilih.checkedRadioButtonId!=0) {
                var nilai = 0
                when (rgPilih.checkedRadioButtonId) {
                    R.id.id_1 -> nilai = 1
                    R.id.id_2 -> nilai = 2
                    R.id.id_3 -> nilai = 3
                    R.id.id_4 -> nilai = 4
                }
                val resultActivity = Intent()
                resultActivity.putExtra(EXTRA_PILIH, nilai)
                setResult(RESULT_CODE, resultActivity)
                finish()
            }
        }
    }
}