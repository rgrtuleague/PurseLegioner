package com.example.purselegioner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addBalance(buttonBalancePlus)
        minusBalance(buttonBalanceMinus)
    }

    private fun addBalance(button: Button) {
        button.setOnClickListener() {
            val currentBalance = currentBalanceText.text.toString().format("%.2f", this).toDouble()  // текущее значение баланса
            //val x = currentBalanceText.getDoubleValue()
            if (!inputBalanceChange.text.isNullOrEmpty()) {
                val value = inputBalanceChange.text.toString().format("%.2f", this)
                val regex = "^\\d+(\\.?\\d{1,2}){0,1}\$".toRegex()
                if (regex.matches(value)) {
                    val inputValueChange = inputBalanceChange.text.toString().toDouble() ///// !!!!
                    val result : String = String.format("%.2f", (currentBalance + inputValueChange))
                    currentBalanceText.text = result
                }
            }
        }
    }

    private fun minusBalance(button: Button) {
        button.setOnClickListener() {
            val currentBalance = currentBalanceText.text.toString().format("%.2f", this).toDouble()  // текущее значение баланса
            //val x = currentBalanceText.getDoubleValue()
            if (!inputBalanceChange.text.isNullOrEmpty()) {
                val value = inputBalanceChange.text.toString().format("%.2f", this)
                val regex = "^\\d+(\\.?\\d{1,2}){0,1}\$".toRegex()
                if (regex.matches(value)) {
                    val inputValueChange = inputBalanceChange.text.toString().toDouble() ///// !!!!
                    val result : String = String.format("%.2f", (currentBalance - inputValueChange))
                    currentBalanceText.text = result
                }
            }
        }
    }

    fun  <EditText> EditText.getDoubleValue() : Double {
        return this@MainActivity.toString().toDouble()
    }
}



