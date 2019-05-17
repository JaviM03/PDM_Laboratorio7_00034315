package com.example.labo7

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.labo7.Repository.GitHubRepository
import com.example.labo7.database.GithubRepo
import com.example.labo7.database.RoomDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubRepoViewModel(app: Application): AndroidViewModel(app){
    private val repository: GitHubRepository

    init{
        val repoDao= RoomDB.getInstance(app).repoDao()
        repository = GitHubRepository(repoDao)
    }

    fun insert(repo:GithubRepo)=viewModelScope.launch(Dispatchers.IO){
        repository.insert(repo)
    }
    fun getAll(): LiveData<List<GithubRepo>> = repository.getALL()

    fun nukeAll() = repository.nuke()

}