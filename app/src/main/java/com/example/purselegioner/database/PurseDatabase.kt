package com.example.purselegioner.database

import android.content.Context
import android.util.Log
import android.util.Log.d
import android.widget.TextView
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.purselegioner.MainActivity
import com.example.purselegioner.R
import io.reactivex.annotations.SchedulerSupport.IO
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.internal.synchronized
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

@Database(entities = [MainTable::class], version = 1 )
abstract class PurseDatabase : RoomDatabase() {

    abstract fun balanceDao(): BalanceDao

    private class PurseDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                  //  val balanceDao = database.balanceDao()

                    val balance =
                        try {
                            d("sergio", "onOpen: balanceDao")
                            database
                                .balanceDao()
                                .getCurrentBalanceTable()
                                .last()
                                .currentBalance
                        } catch (e: Exception) {
                            d("sergio", "onOpen: Shit happened")
                            -1.00
                        }
                    currentbalance = balance
                }
            }
        }
    }

    companion object {
        // Singleton prevents multiple instances of database opening at the same time
        @Volatile
        private var INSTANCE: PurseDatabase? = null
        var currentbalance = 0.0

        @InternalCoroutinesApi
        fun getDatabase(context: Context, scope: CoroutineScope): PurseDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
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