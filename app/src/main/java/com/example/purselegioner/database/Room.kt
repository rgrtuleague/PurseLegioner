package com.example.purselegioner.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity (tableName = "balance_table")
class Room(@PrimaryKey @ColumnInfo(name = "currentBalance") var currentBalance: String) {

}