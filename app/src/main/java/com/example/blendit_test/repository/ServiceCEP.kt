package com.example.blendit_test.repository

import com.example.blendit_test.model.CEPResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceCEP {

    @GET("{CEP}/json/")
    suspend fun getCEPResponse(@Path("CEP") CEP : String): CEPResponse


}
