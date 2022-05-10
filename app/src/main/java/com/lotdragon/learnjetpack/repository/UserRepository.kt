package com.lotdragon.learnjetpack.repository

import com.lotdragon.learnjetpack.entity.UserInfo
import com.lotdragon.learnjetpack.network.ApiResponse
import com.lotdragon.learnjetpack.network.UserNetWork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object UserRepository {

    suspend fun login(username: String, password: String) : ApiResponse<UserInfo> {
        return withContext(Dispatchers.IO){
            UserNetWork.login(username, password)
        }
    }

    suspend fun register(username: String, pwd: String, repwd: String) : ApiResponse<UserInfo> {
        return withContext(Dispatchers.IO){
            UserNetWork.register(username,pwd,repwd)
        }
    }
}