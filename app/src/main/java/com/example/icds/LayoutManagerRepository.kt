package com.example.icds

import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LayoutManagerRepository(private val apiService: ApiService) {

    suspend fun fetchLayoutManager(layoutManagerId: Int): RecyclerView.LayoutManager? {
        return withContext(Dispatchers.IO) {
            try {
                apiService.getLayoutManager(layoutManagerId)
            } catch (e: Exception) {
                // Handle network errors
                null
            }
        }
    }
}
