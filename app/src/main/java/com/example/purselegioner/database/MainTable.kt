package com.example.purselegioner.database

import androidx.room.ColumnInfo
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MainTable(
    @PrimaryKey
    val _id: Int?,
    @ColumnInfo(name =  "time of transaction") val timeTransaction: String,
    @ColumnInfo(name =  "price") val price: String,
    @ColumnInfo(name =  "balance") val currentBalance: String,
    @ColumnInfo(name =  "seller") val seller: String,
    @ColumnInfo(name =  "buying place") val placeBuying: String,
    @ColumnInfo(name = "credit card") val creditCard: String,
    @ColumnInfo(name = "type of products") val typeOfProduct: String

)