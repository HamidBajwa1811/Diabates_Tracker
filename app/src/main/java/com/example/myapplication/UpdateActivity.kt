package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.AppDatabase.Appdatabase
import com.example.myapplication.Models.DiabatesDetail
import kotlinx.android.synthetic.main.activity_add_record.*
import kotlinx.android.synthetic.main.activity_update.*
import kotlinx.android.synthetic.main.activity_update.edtbloodpressure
import kotlinx.android.synthetic.main.activity_update.edtdate
import kotlinx.android.synthetic.main.activity_update.edtfood
import kotlinx.android.synthetic.main.activity_update.edtsugarlvl
import kotlinx.android.synthetic.main.activity_update.edttime

class UpdateActivity : AppCompatActivity() {
    lateinit var dia: DiabatesDetail;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        if(intent.getSerializableExtra("diabetes")!=null){
            dia=intent.getSerializableExtra("diabetes") as DiabatesDetail
        }
        updatebtn.setOnClickListener {
            val database= Appdatabase.getDatabase(this)
            var Date=edtdate.text.toString()
            var Time=edttime.text.toString()
            var Bloodpressure=edtbloodpressure.text.toString()
            var Sugarlvl=edtsugarlvl.text.toString()
            var Food=edtfood.text.toString()
            if (Date.isNullOrEmpty()){
                edtdate.error="Enter Date"
                return@setOnClickListener
            }
            else  if (Time.isNullOrEmpty()){
                edttime.error="Enter Current Time"
                return@setOnClickListener
            }
            else  if (Bloodpressure.isNullOrEmpty()){
                edtbloodpressure.error="Enter Blood Pressure"
                return@setOnClickListener
            }
            else  if (Sugarlvl.isNullOrEmpty()){
                edtsugarlvl.error="Enter Sugar Level"
                return@setOnClickListener
            }
            else  if (Food.isNullOrEmpty()){
                edtfood.error="Enter Food"
                return@setOnClickListener
            }
            if(dia !=null)
            {
                val db=DiabatesDetail(dia.ID,Date,Time,Bloodpressure,Sugarlvl,Food)
                database?.DiabatesDao()?.Update(db)
                var i= Intent(this,RecordActivity::class.java)
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(i)
            }
        }
    }
}