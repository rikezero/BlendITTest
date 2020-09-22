package com.example.blendit_test.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class User (
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age: String,
    @ColumnInfo(name = "tel") val tel: String,
    @ColumnInfo(name = "address") val address: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)