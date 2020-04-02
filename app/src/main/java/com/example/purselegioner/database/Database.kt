package com.example.purselegioner.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(BalanceRoom::class), version = 1, exportSchema = false)
    public abstract class BalanceRoomDatabase: RoomDatabase () {

    abstract fun daoBalance () : DaoBalance

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: BalanceRoomDatabase? = null

        fun getDatabase(context: Context): BalanceRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BalanceRoomDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}