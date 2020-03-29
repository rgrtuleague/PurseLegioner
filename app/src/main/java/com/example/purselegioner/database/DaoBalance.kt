package com.example.purselegioner.database

import androidx.room.Dao
import androidx.room.Query

@Dao
interface DaoBalance {

    @Query("SELECT currentBalance from balance_table")
    fun getCurrentBalance(): String
    
}