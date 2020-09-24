package com.example.blendit_test.model


import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class CEPResponse(
    @SerializedName("bairro")
    val bairro: String,
    @SerializedName("cep")
    val cep: String,
    @SerializedName("complemento")
    val complemento: String,
    @SerializedName("ddd")
    val ddd: String,
    @SerializedName("gia")
    val gia: String,
    @SerializedName("ibge")
    val ibge: String,
    @SerializedName("localidade")
    val localidade: String,
    @SerializedName("logradouro")
    val logradouro: String,
    @SerializedName("siafi")
    val siafi: String,
    @SerializedName("uf")
    val uf: String
) : Parcelable