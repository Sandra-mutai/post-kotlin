package com.example.myposts

import android.content.ClipData
import android.content.ContentProvider
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewPost : AppCompatActivity() {
    var postId =0
    lateinit var tvIdentity: TextView
    lateinit var tvNo:TextView
    lateinit var rvPostItem: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_post)
        postId=intent.getIntExtra("POST_ID",0)
    }
    fun fetchPostById(){
        var apiClient=ApiClient.buildApiClient(aPiInterfce::class.java)

        var request=apiClient.getPostById(postId)
        request.enqueue(object : Callback<Post<Any?>> {
            override fun onResponse(call: Call<Post<Any?>>, response: Response<Post<Any?>>) {
                if (response.isSuccessful){
                    var post=response.body()
                    if (post != null) {
                        tvIdentity.text=post?.title
                        tvNo.text=post?.body

                    }
                }
            }

            override fun onFailure(call: Call<Post<Any?>>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }

        })

    }
}