package com.example.purselegioner

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.TextView
import com.example.purselegioner.database.PurseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

/* https://android.jlelse.eu/android-threads-coroutines-for-beginners-f39abc90d927 */

class MainActivity : AppCompatActivity(), CoroutineScope by GlobalScope {

    @SuppressLint("SetTextI18n")
    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * 1. Подготовить Coroutine. Получить значение из Database. Если база данных отсутствует, создать ее(уже реализовано),
         *    тогда текущий баланс = 0
         * */

        val balance = PurseDatabase.currentbalance
        setContentView(R.layout.activity_main)
        val balanceTextView = findViewById<TextView>(R.id.currentBalanceText)
        balanceTextView.text = balance.toString()

        /**
         * 3. Ввести обработку кнопок ДОБАВИТЬ и ПОТРАТИТЬ.
         *  - создать строку в Database
         *  - подсчитать новый баланс
         *  - обновить баланс на экране
         * */

        ButtonsHandler.addBalance(buttonBalancePlus, balanceTextView, inputBalanceChange)
        /*var currentBalance: Double

        buttonBalancePlus.setOnClickListener() {
            currentBalance = try {
                currentBalanceText.text.toString().toDouble()  // текущее значение баланса
            } catch (e: Exception) {
                -1.00
            }
            d("sergio", "currentBalance = $currentBalance")
            if (inputBalanceChange.text.toString() != "") {
                val value = inputBalanceChange.text.toString()
                val regex = "^\\d+(\\.?\\d{1,2}){0,1}\$".toRegex()
                if (regex.matches(value)) {
                    val inputValueChange = inputBalanceChange.text.toString().toDouble()
                    val result: String =
                        String.format("%.2f", (currentBalance + inputValueChange))
                    currentBalanceText.text = result
                }
            } else {
                currentBalanceText.text = currentBalance.toString()
            }
            inputBalanceChange.setText("")
        }*/

    }
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