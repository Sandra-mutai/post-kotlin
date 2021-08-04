package com.example.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback


import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var rvPost:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvPost=findViewById(R.id.cvPost)
        rvPost.layoutManager=LinearLayoutManager(baseContext)
        fetchPosts()
    }

fun fetchPosts(){
    var retrofit=ApiClient.buildApiClient(aPiInterfce::class.java)
    var request=retrofit.getPosts()
    request.enqueue(object : Callback<List<Post<Any?>>> {
        override fun onResponse(call: Call<List<Post<Any?>>>, response: Response<List<Post<Any?>>>) {
            if (response.isSuccessful){
                var postList=response.body()!!
                rvPost=findViewById(R.id.cvPost)
                var postadapter=PostAdapter(postList)
                rvPost.layoutManager=LinearLayoutManager(baseContext)
                rvPost.adapter=postadapter
//                    Toast.makeText(baseContext,postList.size,Toast.LENGTH_LONG).show()
                Toast.makeText(baseContext, "${postList!!.size} posts", Toast.
                LENGTH_LONG).show()
                var postDate= mutableListOf<Post<Any?>>()
                for (x in 1..postList.size){
                    postDate.add(Post(3,85,"Developer","Information not there, Sorry try again later"))
                }
            }
        }
        override fun onFailure(call: Call<List<Post<Any?>>>, t: Throwable) {
            Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
        }
    })
}
}






