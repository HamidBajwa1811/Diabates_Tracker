package com.example.myapplication

import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.AppDatabase.Appdatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_record.*
import kotlinx.android.synthetic.main.card_view.*
import java.io.Serializable
import com.example.myapplication.Models.DiabatesDetail as DiabatesDetail1

class RecordActivity : AppCompatActivity(),ListClickListener {

    val diabatesAdapter=DiabatesListAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val database=Appdatabase.getDatabase(this)
        setContentView(R.layout.activity_record)

        recyclerview.apply {
            layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

            adapter=diabatesAdapter
        }
        getRecordlist()
    }

    private fun getRecordlist() {
        val database=Appdatabase.getDatabase(this)
        diabatesAdapter.notifyDataSetChanged();
        var list=database?.DiabatesDao()?.getRecordlist() as ArrayList<DiabatesDetail1>
        diabatesAdapter.getDiabatesList(list)
    }

    override fun Editrecord(Diabatesdetail: DiabatesDetail1) {
        update.setOnClickListener {
            var intent=Intent(this,UpdateActivity::class.java)
            intent.putExtra("diabetes",Diabatesdetail)
            startActivity(intent)
        }
    }

    override fun Deleterecord(Diabatesdetail:DiabatesDetail1) {
        val dialog: AlertDialog.Builder= AlertDialog.Builder(this)
        dialog.setTitle("Do You want To Delete?")
        dialog.setMessage("Are You Sure To Delete This Record?")
        dialog.setPositiveButton("Yes")
        {
                dialog,which->val database=Appdatabase.getDatabase(this)
            database?.DiabatesDao()?.Delete(Diabatesdetail)
            startActivity(Intent(this,MainActivity::class.java))
        }
        dialog.setNegativeButton("No"){dialog,which->dialog.dismiss()}
        dialog.show()
    }

}
