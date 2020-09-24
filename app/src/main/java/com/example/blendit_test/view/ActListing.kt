package com.example.blendit_test.view

import androidx.lifecycle.Observer
import com.example.blendit_test.base.ActBind
import com.example.blendit_test.custom.*
import com.example.blendit_test.databinding.ActListingBinding
import com.example.blendit_test.model.User
import com.example.blendit_test.presenter.ActListingPresenter
import com.example.blendit_test.recycler.ItemViewUsers

class ActListing : ActBind<ActListingBinding>(), ActListingPresenter.View{
    override val binding: ActListingBinding by viewBind()
    lateinit var presenter: ActListingPresenter
    private val users = mutableSetOf<User>()

    override fun ActListingBinding.onBinding() {
        presenter = ActListingPresenter(this@ActListing)
        backBtn.onClick { onBackPressed() }
        val adapter = recyclerAdapter<ItemViewUsers>(users)
        userRecycler.adapter = adapter

        presenter.dataSet.observe(this@ActListing, Observer {
            it.run {
                users.addAll(it)
                adapter.notifyDataSetChanged()
            }
        })

        presenter.getUsers()

    }

    override fun onResume() {
        super.onResume()
        updateAdapter()
    }

    fun updateAdapter(){
        users.clear()
        presenter.getUsers()
        binding.userRecycler.adapter?.notifyDataSetChanged()
    }

}