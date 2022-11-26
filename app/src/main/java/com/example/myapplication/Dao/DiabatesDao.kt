package com.example.myapplication.Dao

import androidx.room.*
import com.example.myapplication.Models.DiabatesDetail

@Dao
interface DiabatesDao {
    @Insert
    fun Insert(DiabatesDetail: DiabatesDetail)

    @Update
    fun Update(DiabatesDetail: DiabatesDetail)

    @Delete
    fun Delete(DiabatesDetail: DiabatesDetail)

    @Query("Select * From diabates")
    fun getRecordlist():List<DiabatesDetail>
}
