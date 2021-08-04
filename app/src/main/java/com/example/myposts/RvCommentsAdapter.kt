package com.example.myposts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class RvCommentsAdapter(var commentList: List<Comments<Any?>>):RecyclerView.Adapter<CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.comment_list,parent,false)
        return CommentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var currentComments=commentList.get(position)
        holder.tvName.text=currentComments.name
        holder.tvEmail.text=currentComments.email
        holder.tvCommentsec.text=currentComments.body

    }

    override fun getItemCount(): Int {
        return commentList.size
    }
}

class CommentViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
    var tvName=itemView.findViewById<TextView>(R.id.tvCommentName)
    var tvEmail=itemView.findViewById<TextView>(R.id.tvCommentEmail)
    var tvCommentsec=itemView.findViewById<TextView>(R.id.tvCommentBody)

}
