package com.example.purselegioner.repository

import androidx.lifecycle.LiveData
import com.example.purselegioner.database.BalanceDao
import com.example.purselegioner.database.MainTable

class PurseRepository (private val balanceDao: BalanceDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.

    val allPrice: MutableList<MainTable> = balanceDao.getCurrentBalanceTable()

    suspend fun insert(row: MainTable) {
        balanceDao.insert(row)
    }
}