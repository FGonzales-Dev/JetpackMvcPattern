package com.francisgonzales.jetpackmvcpattern.service

import com.francisgonzales.jetpackmvcpattern.model.ApiResponse
import retrofit2.http.GET
import retrofit2.Call

interface ApiService {
    @GET("notes")
    fun getNotes(): Call<ApiResponse>
}