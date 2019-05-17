package com.example.labo7.Repository

import androidx.lifecycle.LiveData
import com.example.labo7.database.GithubRepo
import com.example.labo7.database.GithubDAO

class GitHubRepository(private val repoDAO: GithubDAO){

   suspend fun insert(repo: GithubRepo){
        repoDAO.insert(repo)
    }

    fun getALL(): LiveData<List<GithubRepo>> = repoDAO.getAllRepos()

    fun nuke() = repoDAO.nukeTable()

}