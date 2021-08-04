package com.example.myposts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter (var postList:List<Post<Any?>>, var context: Context):RecyclerView.Adapter<PostAdapter.PostViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.post_item,parent,false)
            return PostViewHolder(itemView)
    }


    class PostViewHolder(var itemView:View):RecyclerView. ViewHolder(itemView) {
        //    var cvPost: Any
        var tvid = itemView.findViewById<TextView>(R.id.tvid)
        var tvuserid = itemView.findViewById<TextView>(R.id.tvuserid)
        var tvtitle = itemView.findViewById<TextView>(R.id.tvtitle)
        var tvbody = itemView.findViewById<TextView>(R.id.tvbody)
        var cvPost = itemView.findViewById<CardView>(R.id.cvPost)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var currentPost=postList.get(position)
        holder.tvid.text=currentPost.Id.toString()
        holder.tvtitle.text=currentPost.title
        holder.tvbody.text=currentPost.body
        holder.cvPost.setOnClickListener {
            var intent=Intent(context,ViewPost::class.java)
            intent.putExtra("POST_ID",currentPost.Id)
             intent.putExtra("title",currentPost.title)
             intent.putExtra("body",currentPost.body)
             intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
             context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}


