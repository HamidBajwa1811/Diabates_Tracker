package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Models.DiabatesDetail
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.card_view.view.*

class DiabatesListAdapter(var clickListener: RecordActivity) :RecyclerView.Adapter<DiabatesListAdapter.DiabatesVH>() {

    lateinit var finalDiabatesList:ArrayList<DiabatesDetail>
class DiabatesVH(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiabatesVH {
        val diabatesview=LayoutInflater.from(parent.context).inflate(R.layout.card_view,parent,false)
        return DiabatesVH(diabatesview)
    }

    override fun onBindViewHolder(holder: DiabatesVH, position: Int) {
        val diabates=finalDiabatesList[position]
        holder.itemView.date.text=diabates.date
        holder.itemView.time.text=diabates.time
        holder.itemView.bloodpressure.text=diabates.bloodpressure
        holder.itemView.sugarlvl.text=diabates.sugarlevel
        holder.itemView.food.text=diabates.food
holder.itemView.update.setOnClickListener {
    clickListener.Editrecord(diabates)
}
        holder.itemView.delete.setOnClickListener {
            clickListener.Deleterecord(diabates)
        }
//        if(diabates.bloodlevel>70 && di)
//        holder.itemView.date.text=diabates.date


//        holder.itemView.setOnClickListener{
//            clickListener.Editrecord(diabates)
//        }
    }

    override fun getItemCount(): Int {
        return finalDiabatesList.count()
    }

    fun getDiabatesList(diabateslist:ArrayList<DiabatesDetail>){
        finalDiabatesList=diabateslist
    }
}