package com.example.myapplication.AppDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.Dao.DiabatesDao
import com.example.myapplication.Models.DiabatesDetail

@Database(entities = [DiabatesDetail::class], version = 1)
abstract class Appdatabase: RoomDatabase(){

    abstract fun DiabatesDao():DiabatesDao
    companion object{
        private var dbInstance: Appdatabase? =null
        fun getDatabase(context:Context): Appdatabase? {
            if(dbInstance!=null)
            {
                return dbInstance
            }
            val db= Room.databaseBuilder(context , Appdatabase::class.java , "Diabates_db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
            dbInstance=db
            return dbInstance
            //Create Database

        }
    }
}