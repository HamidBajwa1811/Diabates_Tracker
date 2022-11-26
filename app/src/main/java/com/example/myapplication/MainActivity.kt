package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.AppDatabase.Appdatabase
import com.example.myapplication.Models.DiabatesDetail
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adddetail.setOnClickListener {
            startActivity(Intent(this,Add_Record::class.java))
        }
        checkdetail.setOnClickListener {
            startActivity(Intent(this,RecordActivity::class.java))
        }

    }


}