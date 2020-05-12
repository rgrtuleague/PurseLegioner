package com.example.purselegioner

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.TextView
import com.example.purselegioner.database.BalanceDao
import com.example.purselegioner.database.MainTable
import com.example.purselegioner.database.PurseDatabase
import com.example.purselegioner.repository.PurseRepository
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity(), CoroutineScope by GlobalScope {

     val table : MainTable = MainTable(
         null,
         "time",
         "+20",
         15.00,
         "seller",
         "place",
         "card",
         "type"
     )
    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val balanceTextView = findViewById<TextView>(R.id.currentBalanceText)

        val scope = CoroutineScope(Job() + Dispatchers.Main)

        /*val job =*/ scope.launch(Dispatchers.IO) {
            val db = PurseDatabase.getDatabase(applicationContext, CoroutineScope(coroutineContext))
                .balanceDao()

            val lastBalanceRow = async {
                try {
                    db.getCurrentBalance().last().currentBalance
                } catch (e: Exception) {
                    0.00
                }
            }.await()

            db.insert(table)

            val prices = async {
                db.getCurrentBalance()
            }.await()

            d("sergio", "prices =  ${prices.size}")
            d("sergio", "balance = ${lastBalanceRow} + ${prices.last().currentBalance}")
        }

    }
}




