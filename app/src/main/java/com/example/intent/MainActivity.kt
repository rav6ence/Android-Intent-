package com.example.intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnIntent: Button
    private lateinit var btnIntentObject: Button
    private lateinit var btnIntentDial: Button
    private lateinit var btnIntentResult: Button
    private lateinit var tvHasil: TextView

    companion object{
        val REQUEST_CODE = 200
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIntent = findViewById(R.id.btn_move_activity)
        val btnIntentData = findViewById<Button>(R.id.btn_move_with_data)
        btnIntentObject = findViewById(R.id.btn_move_with_object)
        btnIntentDial = findViewById(R.id.btn_dial_number)
        btnIntentResult = findViewById(R.id.btn_move_with_result)
        tvHasil = findViewById(R.id.tv_hasil)

        btnIntent.setOnClickListener(this)
        btnIntentData.setOnClickListener(this)
        btnIntentObject.setOnClickListener(this)
        btnIntentDial.setOnClickListener(this)
        btnIntentResult.setOnClickListener(this)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE){
            if(resultCode == HasilAtivity.RESULT_CODE){
                val nilaiPilih = data?.getIntExtra(HasilAtivity.EXTRA_PILIH, 0)
                tvHasil.text = "Nilai Hasil: $nilaiPilih"
            }
        }
    }
    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity,MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_with_data -> run{
                val moveData = Intent(this@MainActivity, MoveWithData::class.java)
                moveData.putExtra(MoveWithData.Extra_Text, "Hello")
                startActivity(moveData)
            }
            R.id.btn_move_with_object -> run {
                val nameObject = NameObject(
                    "Thoriq Arrofif",
                    16,
                    "Serafine",
                    "Jl. Danau Ranau G31"
                )
                val IntentObject = Intent(this@MainActivity, MoveWithObject::class.java)
                IntentObject.putExtra(MoveWithObject.ExtraObject, nameObject)
                startActivity(IntentObject)
            }
            R.id.btn_dial_number ->  {
                val number = "08912380611"
                val IntentNumber = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
                startActivity(IntentNumber)
            }
            R.id.btn_move_with_result -> run {
                val IntentResult = Intent(this@MainActivity, HasilAtivity::class.java)
                startActivityForResult(IntentResult, REQUEST_CODE)
            }
        }
    }
}