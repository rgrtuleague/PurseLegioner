package com.example.purselegioner.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BalanceDao {

    @Query("SELECT * FROM MainTable")
    fun getCurrentBalance(): MutableList<MainTable>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(balance: MainTable)

    @Query("DELETE FROM MainTable")
    suspend fun deleteAll()

}