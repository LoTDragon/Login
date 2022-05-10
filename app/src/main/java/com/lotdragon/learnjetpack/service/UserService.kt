package com.lotdragon.learnjetpack.service



import com.lotdragon.learnjetpack.entity.UserInfo
import com.lotdragon.learnjetpack.network.ApiResponse
import retrofit2.*
import retrofit2.http.*

interface UserService {


    @FormUrlEncoded
    @POST("user/login")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ) : Call<ApiResponse<UserInfo>>


    @FormUrlEncoded
    @POST("user/register")
    fun register(
        @Field("username") username: String, @Field("password") pwd: String, @Field(
            "repassword"
        ) rpwd: String
    ): Call<ApiResponse<UserInfo>>

}