package com.example.blendit_test.presenter

import com.example.blendit_test.R
import com.example.blendit_test.custom.toast
import com.example.blendit_test.model.User
import com.example.blendit_test.repository.RepositoryCEP
import com.example.blendit_test.repository.RepositoryDatabase
import com.example.blendit_test.view.ActUpdate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActUpdatePresenter(view: View ) {

    private var viewUpdate: View = view
    private val context = (viewUpdate as ActUpdate).applicationContext
    private val repository = RepositoryDatabase(context)

    fun updateUser(user: User){
        repository.updateUser(user)
        (viewUpdate as ActUpdate).binding.registerBtn.toast(context.getString(R.string.updateSuc))
    }

    fun apiCall(cep: String) = CoroutineScope(Dispatchers.Default).launch {
        val response = RepositoryCEP().getCEP(cep)
        CoroutineScope(Dispatchers.Main).launch {
            (viewUpdate as ActUpdate).binding.addressInput.setText(response.logradouro)
        }
    }

    interface View {

    }
}