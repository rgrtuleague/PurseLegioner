package com.example.purselegioner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.purselegioner.livedata.PurseViewModel
import kotlinx.coroutines.InternalCoroutinesApi

class MainActivity : AppCompatActivity() {

    @InternalCoroutinesApi
    private lateinit var rowViewModel: PurseViewModel

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = BalanceListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        rowViewModel = ViewModelProvider(this).get(PurseViewModel::class.java)

        rowViewModel.allPrice.observe(this, Observer { rows ->
            rows?.let { } // see CONNECT WITH THE DATA chapter
        })

       // addBalance(buttonBalancePlus, currentBalanceText, inputBalanceChange)
       // minusBalance(buttonBalanceMinus, currentBalanceText, inputBalanceChange)

        // android:text="@string/current_balance_text"
    }
}




