package com.example.purselegioner

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*

class ButtonsHandler {

    companion object {

        @SuppressLint("SetTextI18n")
        fun addBalance(buttonBalancePlus: Button, currentBalanceText: TextView, inputBalanceChange: TextInputEditText) {
            var currentBalance: Double

            buttonBalancePlus.setOnClickListener() {
                currentBalance = try {
                    currentBalanceText.text.toString().toDouble()  // текущее значение баланса
                } catch (e: Exception) {
                    -1.00
                }
                //Log.d("sergio", "currentBalance = $currentBalance")
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
            }
        }

        fun minusBalance(button: Button, currentBalanceText: TextView, inputBalanceChange: View) {
            button.setOnClickListener() {
                val currentBalance = currentBalanceText.text.toString().format("%.2f", it)
                    .toDouble()  // текущее значение баланса
                //val currentBalance = currentBalanceText.getDoubleTypeValueTextView() // не работает.
//        if (!inputBalanceChange.text.isNullOrEmpty()) {
                if (!inputBalanceChange.toString().isEmpty()) {
//            val value = inputBalanceChange.text.toString().format("%.2f", it)
                    val value = inputBalanceChange.toString().format("%.2f", it)
                    val regex = "^\\d+(\\.?\\d{1,2}){0,1}\$".toRegex()
                    if (regex.matches(value)) {
//                val inputValueChange = inputBalanceChange.text.toString().toDouble()
                        val inputValueChange = inputBalanceChange.toString().toDouble()
                        val result: String =
                            String.format("%.2f", (currentBalance - inputValueChange))
                        currentBalanceText.text = result
                    }
                }
            }
        }
    }
}