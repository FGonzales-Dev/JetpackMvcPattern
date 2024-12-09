package com.francisgonzales.jetpackmvcpattern.Controller

import android.util.Log
import com.francisgonzales.jetpackmvcpattern.model.ApiResponse
import com.francisgonzales.jetpackmvcpattern.model.Note
import com.francisgonzales.jetpackmvcpattern.service.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotesController {
    private val apiService = RetrofitClient.apiService

    fun fetchNotes(callback: (List<Note>) -> Unit) {
        apiService.getNotes().enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    response.body()?.notes?.let {
                        callback(it)
                        Log.d("Test","successful")
                        Log.d("Test", response.body()!!.notes.toString())
                    }
                } else {
                    Log.d("Test","not successful")
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.d("Test","error")
            }
        })
    }
}