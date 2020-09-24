package com.example.blendit_test.repository

import android.content.Context
import com.example.blendit_test.data.DatabaseBuilder
import com.example.blendit_test.data.dao.AccessUsers
import com.example.blendit_test.model.User

class RepositoryDatabase(context: Context) {
    private var database = DatabaseBuilder.getAppDatabase(context)
    private var accessUser = database.accessUsers()

    fun getAllUsers(): AccessUsers {
        return accessUser
    }

    fun addUser(user: User){
        accessUser.insert(user)
    }

    fun updateUser(user: User){
        accessUser.insert(user)
    }

    fun deleteUser(user: User){
        accessUser.delete(user)
    }
}