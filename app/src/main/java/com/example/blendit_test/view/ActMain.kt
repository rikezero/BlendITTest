package com.example.blendit_test.view

import com.example.blendit_test.base.ActBind
import com.example.blendit_test.custom.activity
import com.example.blendit_test.custom.onClick
import com.example.blendit_test.custom.onClickStart
import com.example.blendit_test.custom.viewBind
import com.example.blendit_test.databinding.ActMainBinding


class ActMain : ActBind<ActMainBinding>() {
    override val binding: ActMainBinding by viewBind()

    override fun ActMainBinding.onBinding() {
        regBtn.onClickStart(ActRegister::class)
        listBtn.onClickStart(ActListing::class)
    }

}