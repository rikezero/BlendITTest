package com.example.blendit_test.recycler



import com.example.blendit_test.custom.ItemViewBuilder
import com.example.blendit_test.databinding.UserItemBinding
import com.example.blendit_test.model.User



class ItemViewUsers : ItemViewBuilder<User, UserItemBinding>() {

    override val binding by lazy { bind(UserItemBinding::class) }

    override fun UserItemBinding.onBind(position: Int) {

        (collection as Set<User>).elementAt(position).run {
            itemName.text = name
            itemTel.text = tel
        }
    }

}
