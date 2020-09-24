package com.example.blendit_test.recycler


import com.example.blendit_test.custom.ItemViewBuilder
import com.example.blendit_test.custom.onClick
import com.example.blendit_test.databinding.UserItemBinding

import com.example.blendit_test.model.User
import com.example.blendit_test.repository.RepositoryDatabase
import com.example.blendit_test.view.ActListing


class ItemViewUsers : ItemViewBuilder<User, UserItemBinding>() {

    override val binding by lazy { bind(UserItemBinding::class) }

    override fun UserItemBinding.onBind(position: Int) {

        (collection as Set<User>).elementAt(position).run {
            itemName.text = name
            itemTel.text = tel
            itemDelete.onClick {
                RepositoryDatabase(context).deleteUser(this@run)
                (context as ActListing).updateAdapter()
            }
        }

    }
}