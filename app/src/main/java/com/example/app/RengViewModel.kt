package com.example.app

import androidx.lifecycle.liveData
import com.example.app.entity.Repo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RengViewModel {
    var repos = liveData {
        emit(loadUsers())
    }

    private suspend fun loadUsers(): List<Repo> {
        var retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val api = retrofit.create(GitHubService::class.java)
        return api.listRepos("sungentim")

    }
}