package com.example.purselegioner.database

import androidx.room.ColumnInfo
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "main_table")
class MainTable(
    @PrimaryKey
    @ColumnInfo(name =  "_id") var _id: String,
    @ColumnInfo(name =  "time of transaction") var timeTransaction: String,
    @ColumnInfo(name =  "price") var price: String,
    @ColumnInfo(name =  "balance") var currentBalance: String,
    @ColumnInfo(name =  "seller") var seller: String,
    @ColumnInfo(name =  "buying place") var placeBuying: String,
    @ColumnInfo(name = "credit card") var creditCard: String,
    @ColumnInfo(name = "type of products") var typeOfProduct: String
)