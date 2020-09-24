package com.example.blendit_test.view

import android.widget.Toast
import com.example.blendit_test.R
import com.example.blendit_test.base.ActBind
import com.example.blendit_test.custom.activity
import com.example.blendit_test.custom.onClick
import com.example.blendit_test.custom.toast
import com.example.blendit_test.custom.viewBind
import com.example.blendit_test.databinding.ActRegisterBinding
import com.example.blendit_test.presenter.ActRegisterPresenter
import kotlinx.android.synthetic.main.act_register.*

class ActRegister : ActBind<ActRegisterBinding>(), ActRegisterPresenter.View{
    override val binding: ActRegisterBinding by viewBind()
    lateinit var presenter:ActRegisterPresenter


    override fun ActRegisterBinding.onBinding() {
        presenter = ActRegisterPresenter(this@ActRegister)
        backBtn.onClick { onBackPressed() }
        registerBtn.onClick {
            if(nameInput.text.isNullOrBlank() ||
                ageInput.text.isNullOrBlank() ||
                telInput.text.isNullOrBlank()||
                addressInput.text.isNullOrBlank()){

                toast(context.getString(R.string.fill_spaces))

            }
            else{
                presenter.registerUser(
                    nameInput.text.toString(),
                    ageInput.text.toString(),
                    telInput.text.toString(),
                    addressInput.text.toString())
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

}