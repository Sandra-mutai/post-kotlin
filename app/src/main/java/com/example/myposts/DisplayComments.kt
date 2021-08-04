package com.example.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.AnyRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Comment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DisplayComments : AppCompatActivity() {
    var postId=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv_comment_adapter)
        postId=intent.getIntExtra("postId",0)
        getComments()
    }
    fun getComments() {
        var rvComment=findViewById<RecyclerView>(R.id.rvComment)
        var apiClient=ApiClient.buildApiClient(aPiInterfce::class.java)
        var request=apiClient.getPostById(postId)
        request.enqueue(object: Callback<List<Comments>> {
            override fun onResponse(
                call: Call<List<Comment>>,
                response: Response<List<Comment>>
            ) {
                var commentsList=response.body()
                var commentsAdapter=RvCommentsAdapter(Comment<Any>)
                rvComment.adapter=RvCommentsAdapter(Comment<Any>)
                rvComment.layoutManager= LinearLayoutManager(baseContext)
            }

            override fun onFailure(call: Call<List<Comment?>>, t: Throwable) {
                Toast.makeText(baseContext,t.message, Toast.LENGTH_LONG)
            }


        })}



    }

