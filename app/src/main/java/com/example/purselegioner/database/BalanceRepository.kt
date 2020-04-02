package com.example.purselegioner.database

import androidx.lifecycle.LiveData

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class BalanceRepository(private val DaoBalance: DaoBalance) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allBalance: LiveData<List<BalanceRoom>> = DaoBalance.getCurrentBalance()

    suspend fun insert(balance: BalanceRoom) {
        DaoBalance.insert(balance)
    }
}