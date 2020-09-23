package com.example.blendit_test.repository

import com.example.blendit_test.model.CEPResponse
import com.example.blendit_test.retrofit.RetroInit


class RepositoryCEP {
    private var url = "http://viacep.com.br/ws/"
    private var service = ServiceCEP::class
    private val serviceCEP = RetroInit(url).create(service)


    suspend fun getCEP(cep: String): CEPResponse {
        return serviceCEP.getCEPResponse(cep)
    }




}