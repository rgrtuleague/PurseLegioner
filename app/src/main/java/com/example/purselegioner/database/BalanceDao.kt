package com.example.purselegioner.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BalanceDao {

    @Query("SELECT price from main_table")
    fun getCurrentBalance(): LiveData<List<MainTable>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(balance: MainTable)

    @Query("DELETE FROM main_table")
    suspend fun deleteAll()

}