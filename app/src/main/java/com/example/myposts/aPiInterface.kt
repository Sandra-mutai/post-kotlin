package com.example.myposts

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface aPiInterfce {
    @GET("posts")
   fun getPosts():Call<List<Post<Any?>>>

   @GET("posts/{id}")
   fun getPostById(@Path("id") postId:Int):Call<Post<Any?>>
   @GET("posts/{id}/comments")
   fun getComments(@Path("id")id:Int):Call<List<Comments<Any?>>>

}