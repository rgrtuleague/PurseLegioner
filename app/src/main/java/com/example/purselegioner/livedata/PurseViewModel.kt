package com.example.purselegioner.livedata

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.purselegioner.database.MainTable
import com.example.purselegioner.database.PurseDatabase
import com.example.purselegioner.repository.PurseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class PurseViewModel (application : Application) : AndroidViewModel(application) {



    private val repository : PurseRepository

    val allPrice: MutableList<MainTable>

    init {
        val balancesDao = PurseDatabase.getDatabase(application, viewModelScope).balanceDao()
        repository = PurseRepository(balancesDao)
        allPrice = repository.allPrice
    }

    fun insert(row: MainTable) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(row)
    }
}