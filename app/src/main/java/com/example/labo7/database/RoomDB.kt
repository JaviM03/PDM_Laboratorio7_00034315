package com.example.labo7.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GithubRepo::class],version=1,exportSchema = false)
public abstract  class RoomDB: RoomDatabase(){
    abstract fun repoDao():GithubDAO

    companion object{
        private var INSTACE: RoomDB?=null

        fun getInstance(AppContext: Context):RoomDB{
            val tempInstance = INSTACE
            if(tempInstance !=null) return tempInstance
            synchronized(this){
                val instance = Room
                    .databaseBuilder(AppContext,RoomDB::class.java,"RepoDB")
                    .build()
                INSTACE=instance
                return instance
            }
        }
    }

}