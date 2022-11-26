package com.example.myapplication.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Diabates")
data class DiabatesDetail(
    @PrimaryKey(autoGenerate = true)
    var ID: Int?,
    @ColumnInfo(name ="Date")
    var date:String,
    @ColumnInfo(name ="Time")
    var time:String,
    @ColumnInfo(name ="Blood_Pressure")
    var bloodpressure:String,
    @ColumnInfo(name = "Suagr_Level")
    var sugarlevel:String,
    @ColumnInfo(name ="Food")
    var food:String
):Serializable