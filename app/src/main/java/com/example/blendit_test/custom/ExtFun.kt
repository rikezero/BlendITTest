package com.example.blendit_test.custom

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.example.blendit_test.base.ContextFinder

import kotlin.reflect.KClass
import kotlin.reflect.KFunction0

val Context.inflater get() = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

@Suppress("UNCHECKED_CAST")
inline fun <reified Binding : ViewBinding> ContextFinder.viewBind() = lazy {
    Binding::class.java.getMethod("inflate", LayoutInflater::class.java)
        .invoke(null, cont.inflater) as Binding
}

@Suppress("UNCHECKED_CAST")
fun <Binding : ViewBinding> Context.viewBind(klass: KClass<Binding>) =
    klass.java.getMethod("inflate", LayoutInflater::class.java)
        .invoke(null, inflater) as Binding

val Context.activity: Activity
    get() = when (this) {
        is Activity -> this
        else -> (this as ContextWrapper).baseContext.activity
    }

fun View.onClick(block: View.() -> Unit) = setOnClickListener { block.invoke(this) }

fun View.onClick(function: KFunction0<*>) = setOnClickListener { function() }

fun View.onClickStart(kClass: KClass<out Activity>) = setOnClickListener {
    context.startActivity(Intent(context, kClass.java))
}

fun View.toast(message: String) = Toast.makeText(context, message, Toast.LENGTH_LONG).show()

fun <T : Any> Context.launchActivity(clazz: Class<T>, extras: Bundle.() -> Unit = {}) {
    val intent = Intent(this, clazz)
    startActivity(intent.putExtras(Bundle().apply(extras)))
}