package com.example.blendit_test.presenter

import androidx.lifecycle.MutableLiveData
import com.example.blendit_test.model.User
import com.example.blendit_test.repository.RepositoryDatabase
import com.example.blendit_test.view.ActListing
import com.example.blendit_test.view.ActRegister
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActListingPresenter (view: View ) {

    private var viewListing: View = view
    private val context = (viewListing as ActListing).applicationContext
    val dataSet = MutableLiveData<MutableList<User>>()
    private val repository = RepositoryDatabase(context)

    fun getUsers() = CoroutineScope(Dispatchers.Default).launch {
        dataSet.postValue(repository.getAllUsers().all())
    }

    interface View {

    }
}
