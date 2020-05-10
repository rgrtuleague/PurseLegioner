package com.example.purselegioner

import android.view.View
import android.widget.Button
import android.widget.TextView

fun addBalance(button: Button, currentBalanceText: TextView, inputBalanceChange: View) {

    button.setOnClickListener() {
        val currentBalance = currentBalanceText.text.toString().format("%.2f", it).toDouble()  // текущее значение баланса
        //val currentBalance = currentBalanceText.getDoubleTypeValueTextView() // не работает.
//        if (!inputBalanceChange.text.isNullOrEmpty()) {
        if (!inputBalanceChange.toString().isEmpty()) {
//            val value = inputBalanceChange.text.toString().format("%.2f", it)
            val value = inputBalanceChange.toString().format("%.2f", it)
            val regex = "^\\d+(\\.?\\d{1,2}){0,1}\$".toRegex()
            if (regex.matches(value)) {
//                val inputValueChange = inputBalanceChange.text.toString().toDouble()
                val inputValueChange = inputBalanceChange.toString().toDouble()
                val result : String = String.format("%.2f", (currentBalance + inputValueChange))
                currentBalanceText.text = result
            }
        }
    }
}

fun minusBalance(button: Button, currentBalanceText: TextView, inputBalanceChange: View) {
    button.setOnClickListener() {
        val currentBalance = currentBalanceText.text.toString().format("%.2f", it).toDouble()  // текущее значение баланса
        //val currentBalance = currentBalanceText.getDoubleTypeValueTextView() // не работает.
//        if (!inputBalanceChange.text.isNullOrEmpty()) {
        if (!inputBalanceChange.toString().isEmpty()) {
//            val value = inputBalanceChange.text.toString().format("%.2f", it)
           val value = inputBalanceChange.toString().format("%.2f", it)
            val regex = "^\\d+(\\.?\\d{1,2}){0,1}\$".toRegex()
            if (regex.matches(value)) {
//                val inputValueChange = inputBalanceChange.text.toString().toDouble()
                val inputValueChange = inputBalanceChange.toString().toDouble()
                val result : String = String.format("%.2f", (currentBalance - inputValueChange))
                currentBalanceText.text = result
            }
        }
    }
}

class EditText <T> (textItem: T)  {
    var  item = textItem
    //this.toString().format("%.2f", this).toDouble()
}

fun  <T> T.getDoubleTypeValueTextView() : Double {
    return this.toString().format("%.2f", this).toDouble()
}