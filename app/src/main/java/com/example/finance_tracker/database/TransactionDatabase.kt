package com.example.finance_tracker.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.finance_tracker.dao.TransactionDao
import com.example.finance_tracker.model.Transaction

@Database(entities = [Transaction::class], version = 1, exportSchema = false)
abstract class TransactionDatabase : RoomDatabase() {

    abstract fun myTransactionDao(): TransactionDao

    companion object
    {

        private var INSTANCE: TransactionDatabase?=null
        fun getDatabaseInstance(context: Context): TransactionDatabase {
            val tempInstance= INSTANCE
            if (tempInstance!=null){
                return tempInstance
            }
            synchronized(this)
            {
                val roomDatabaseInstance = Room.databaseBuilder(context,
                    TransactionDatabase::class.java,"Transaction").allowMainThreadQueries().build()
                INSTANCE =roomDatabaseInstance
                return roomDatabaseInstance
            }
        }
    }
}