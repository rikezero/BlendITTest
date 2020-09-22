package com.example.blendit_test.presenter

import android.app.Application
import android.content.Context
import com.example.blendit_test.model.User
import com.example.blendit_test.repository.RepositoryDatabase
import com.example.blendit_test.view.ActRegister

class ActRegisterPresenter(view: View ) {

    private var viewRegister: View = view
    private val context = (viewRegister as ActRegister).applicationContext
    private val repository = RepositoryDatabase(context)

    fun registerUser(name:String,age:String,tel:String,addr:String){
        repository.addUser(User(name,age,tel,addr))
    }

    interface View {


    }
}