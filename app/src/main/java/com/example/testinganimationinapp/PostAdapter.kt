package com.example.testinganimationinapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(private val post_news: List<String>, private val content_post: List<String>, private val context: Context) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val contextTextView = itemView.findViewById<TextView>(R.id.Post_textView)
        val postImageView = itemView.findViewById<ImageView>(R.id.Post_imageView)

        init {
            val postContainer = itemView.findViewById<RelativeLayout>(R.id.PostContainerItem)
            postContainer.setOnClickListener {
                Toast.makeText(itemView.context, "cliquei no post", Toast.LENGTH_SHORT).show()
            }
        }

        fun bindView(content_post: String) {
            val contextAnimation = AnimationUtils.loadAnimation(itemView.context, R.anim.fade_transition)
            contextTextView.text = content_post
            contextTextView.animation = contextAnimation
            postImageView.setImageResource(R.drawable.ic_launcher_background);
            postImageView.animation = contextAnimation
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //lines of recycleView should be like this
        val ItemNewsView =
            LayoutInflater.from(context).inflate(R.layout.activity_item_news, parent, false)
        return ViewHolder(ItemNewsView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contentPost = content_post[position]
        holder.bindView(contentPost)
    }

    override fun getItemCount(): Int {
        return post_news.size
    }
}