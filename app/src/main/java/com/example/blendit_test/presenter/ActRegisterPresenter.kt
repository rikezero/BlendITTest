package com.example.blendit_test.presenter

import com.example.blendit_test.R
import com.example.blendit_test.custom.toast
import com.example.blendit_test.model.User
import com.example.blendit_test.repository.RepositoryCEP
import com.example.blendit_test.repository.RepositoryDatabase
import com.example.blendit_test.view.ActRegister
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActRegisterPresenter(view: View ) {

    private var viewRegister: View = view
    private val context = (viewRegister as ActRegister).applicationContext
    private val repository = RepositoryDatabase(context)

    fun registerUser(name:String,age:String,tel:String,addr:String){
        repository.addUser(User(name,age,tel,addr))
        (viewRegister as android.view.View).toast(context.getString(R.string.RegSuc))
    }

    fun apiCall(cep: String) = CoroutineScope(Dispatchers.Default).launch {
        val response = RepositoryCEP().getCEP(cep)
        CoroutineScope(Dispatchers.Main).launch {
            (viewRegister as ActRegister).binding.addressInput.setText(response.logradouro)
        }
    }

    interface View {

    }
}