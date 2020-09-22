package com.example.blendit_test.data.dao

import androidx.room.*
import com.example.blendit_test.model.User

@Dao
interface AccessUsers {
    @Query("SELECT * FROM Users")
    fun all(): MutableList<User>

    @Query("SELECT COUNT(id) FROM Users")
    fun getCount():Int

    @Query("SELECT * FROM Users WHERE name LIKE :name")
    fun findByName(name: String): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Delete
    fun delete(user: User)

    @Update
    fun update(user: User)
}
