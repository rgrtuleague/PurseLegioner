package com.example.purselegioner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.TextView
import com.example.purselegioner.database.MainTable
import com.example.purselegioner.database.PurseDatabase
import kotlinx.coroutines.*

/* https://android.jlelse.eu/android-threads-coroutines-for-beginners-f39abc90d927 */

class MainActivity : AppCompatActivity(), CoroutineScope by GlobalScope {

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * 1. Подготовить Coroutine. Получить значение из Database. Если база данных отсутствует, создать ее(уже реализовано),
         *    тогда текущий баланс = 0
         * */
        val scope = CoroutineScope(Job() + Dispatchers.IO)
        var balance = 0.00
        scope.async {
            balance = 7.00//getCurrentBalance()

        }

        /**
         * 2. setContentView(Activity)
         * */
        setContentView(R.layout.activity_main)
        val balanceTextView = findViewById<TextView>(R.id.currentBalanceText)
        balanceTextView.text = balance.toString()


        /**
         * 3. Ввести обработку кнопок ДОБАВИТЬ и ПОТРАТИТЬ.
         *  - создать строку в Database
         *  - подсчитать новый баланс
         *  - обновить баланс на экране
         * */

    }

    private suspend fun getCurrentBalance() {}
}
    /*fun other() {

        scope.launch(Dispatchers.IO) {
            async{
                val db = PurseDatabase.getDatabase(applicationContext, CoroutineScope(coroutineContext))
                    .balanceDao()

                /**
                 * До начала работы нам нужно получить значение текущего баланса для отображения его на экране
                 * */
                var lastBalance =
                    try {
                        db.getCurrentBalanceTable().last().currentBalance
                    } catch (e: Exception) {
                        d("sergio", "Shit happened")
                        0.00
                    }
                lastBalance += 20.00

                val table : MainTable = MainTable(
                    null,
                    "time",
                    20.00,
                    lastBalance,
                    "seller",
                    "place",
                    "card",
                    "type"
                )

                db.insert(table)

                val price = db.getCurrentBalanceTable().last().price

                db.insert(table)

                val prices = async {
                    db.getCurrentBalanceTable()
                }.await()


                d("sergio", "prices =  ${prices.size}")
                d("sergio", "balance = $lastBalance + ${prices.last().currentBalance} = ${lastBalance + prices.last().currentBalance}")
                balance = prices.last().currentBalance
            }.await()


        }
    }

}




*/