package com.example.purselegioner.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DaoBalance {

    @Query("SELECT currentBalance from balance_table")
    fun getCurrentBalance(): LiveData<List<BalanceRoom>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(balance: BalanceRoom)

    @Query("DELETE FROM balance_table")
    suspend fun deleteAll()

}