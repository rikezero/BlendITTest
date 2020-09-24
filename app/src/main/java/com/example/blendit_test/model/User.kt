package com.example.blendit_test.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Users")
data class User (
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "age") var age: String,
    @ColumnInfo(name = "tel") var tel: String,
    @ColumnInfo(name = "address") var address: String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
) : Parcelable