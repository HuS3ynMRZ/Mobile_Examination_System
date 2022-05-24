package com.example.mobilimtahansistemi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilimtahansistemi.databinding.RecyclerRowBinding
import com.example.mobilimtahansistemi.model.Post

class FeedRecyclerAdapter (private val postList: ArrayList<Post>): RecyclerView.Adapter<FeedRecyclerAdapter.PostHolder>() {
    class PostHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostHolder(binding)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.binding.recyclerEmailText.text = postList.get(position).email
        holder.binding.recyclerCommentText1.text = postList.get(position).sual1
        holder.binding.recyclerCommentText2.text = postList.get(position).sual2
        holder.binding.recyclerCommentText3.text = postList.get(position).sual3

    }

    override fun getItemCount(): Int {
        return postList.size
    }
}