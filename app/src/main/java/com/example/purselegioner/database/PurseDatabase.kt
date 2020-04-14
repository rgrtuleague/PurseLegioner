package com.example.purselegioner.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import kotlinx.coroutines.launch

@Database(entities = [Room::class], version = 1, exportSchema = false )
abstract class PurseDatabase : RoomDatabase() {

    abstract fun balanceDao() : BalanceDao

    private class PurseDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var balanceDao = database.balanceDao()

                    balanceDao.deleteAll()

                    var row = MainTable("0001",
                        "2020/04/13-12:59:34",
                        "+456.50",
                        "540.50",
                        "DA",
                        "Fryazino Nahimova",
                        "Tinkov black",
                        "food")
                    balanceDao.insert(row)
                }
            }
        }
    }

    companion object {
        // Singleton prevents multiple instances of database opening at the same time
        @Volatile
        private var INSTANCE: PurseDatabase? = null

        @InternalCoroutinesApi
        fun getDatabase(context: Context, scope: CoroutineScope): PurseDatabase {
            return INSTANCE?: synchronized(this) {
                val instance =  Room.databaseBuilder(
                    context.applicationContext,
                    PurseDatabase::class.java,
                    "purse_database"
                ).addCallback(PurseDatabaseCallback(scope))
                 .build()
                INSTANCE = instance
                instance
            }
        }
    }
}