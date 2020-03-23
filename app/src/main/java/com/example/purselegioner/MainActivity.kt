package com.example.purselegioner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addBalance(buttonBalancePlus, 10.00)
        minusBalance(buttonBalanceMinus, 15.00)
    }

    private fun addBalance(button: Button, addValue: Double) {
        button.setOnClickListener() {
            var number = currentBalanceText.text.toString().toDouble()
            currentBalanceText.text = (number + addValue).toString()
        }
    }

    private fun minusBalance(button: Button, minusValue: Double) {
        button.setOnClickListener() {
            var number = currentBalanceText.text.toString().toDouble()
            currentBalanceText.text = (number - minusValue).toString()
        }
    }
}

