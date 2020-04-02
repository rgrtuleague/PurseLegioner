package com.example.purselegioner

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.purselegioner.database.BalanceRepository
import com.example.purselegioner.database.BalanceRoom
import com.example.purselegioner.database.BalanceRoomDatabase
import kotlinx.coroutines.launch

class PurseViewModel(application: Application) : AndroidViewModel(application) {

    private val repository : BalanceRepository

    val allBalance : LiveData<List<BalanceRoom>>

    init {
        // Gets reference to WordDao from WordRoomDatabase to construct
        // the correct WordRepository.
        val balanceDao = BalanceRoomDatabase.getDatabase(application).daoBalance()
        repository = BalanceRepository(balanceDao)
        allBalance = repository.allBalance
    }

    /**
     * The implementation of insert() in the database is completely hidden from the UI.
     * Room ensures that you're not doing any long running operations on
     * the main thread, blocking the UI, so we don't need to handle changing Dispatchers.
     * ViewModels have a coroutine scope based on their lifecycle called
     * viewModelScope which we can use here.
     */
    fun insert(balance: BalanceRoom) = viewModelScope.launch {
        repository.insert(balance)
    }
}