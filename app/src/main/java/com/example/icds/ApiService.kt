package com.example.icds

import androidx.recyclerview.widget.RecyclerView
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("layoutmanagers/{id}")
    suspend fun getLayoutManager(@Path("id") layoutManagerId: Int): RecyclerView.LayoutManager
}
