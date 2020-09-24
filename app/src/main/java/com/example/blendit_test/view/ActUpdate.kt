package com.example.blendit_test.view

import android.os.Bundle
import android.widget.Toast
import com.example.blendit_test.R
import com.example.blendit_test.base.ActBind
import com.example.blendit_test.custom.activity
import com.example.blendit_test.custom.onClick
import com.example.blendit_test.custom.toast
import com.example.blendit_test.custom.viewBind
import com.example.blendit_test.databinding.ActRegisterBinding
import com.example.blendit_test.databinding.ActUpdateBinding
import com.example.blendit_test.model.User
import com.example.blendit_test.presenter.ActRegisterPresenter
import com.example.blendit_test.presenter.ActUpdatePresenter
import kotlinx.android.synthetic.main.act_register.*

class ActUpdate : ActBind<ActUpdateBinding>(), ActUpdatePresenter.View {
    override val binding: ActUpdateBinding by viewBind()
    lateinit var presenter: ActUpdatePresenter
    lateinit var user: User


    override fun ActUpdateBinding.onBinding() {
        presenter = ActUpdatePresenter(this@ActUpdate)
        nameInput.setText(user.name)
        ageInput.setText(user.age)
        telInput.setText(user.tel)
        addressInput.setText(user.address)
        backBtn.onClick { onBackPressed() }
        registerBtn.onClick {
            if (nameInput.text.isNullOrBlank() ||
                ageInput.text.isNullOrBlank() ||
                telInput.text.isNullOrBlank() ||
                addressInput.text.isNullOrBlank()
            ) {
                toast(context.getString(R.string.fill_spaces))
            } else {
                user.name = nameInput.text.toString()
                user.age = ageInput.text.toString()
                user.tel = telInput.text.toString()
                user.address = addressInput.text.toString()
                presenter.updateUser(user)

            }
        }
        cepBtn.onClick {
            when {
                cepInput.text.isNullOrBlank() -> {
                    toast(context.getString(R.string.fillCEP))
                }
                cepInput.text.toString().length != 8 -> {
                    toast(context.getString(R.string.CEPsize))
                }
                else -> {
                    presenter.apiCall(cepInput.text.toString().trim())
                }
            }
        }
    }

    override fun Bundle.onExtras() {
        user = getParcelable("USER") ?: User("", "", "", "")
    }

}