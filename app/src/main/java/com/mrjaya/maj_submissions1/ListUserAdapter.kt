package com.mrjaya.maj_submissions1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ListUserAdapter(private val listUser: ArrayList<User>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_user, parent, false)
        return ListViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val users = listUser[position]
        holder.avatar.setImageResource(users.avatar)
        holder.name.text = users.name
        holder.username.text = users.username
    }

    override fun getItemCount(): Int = listUser.size

    class ListViewHolder(itemView: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        var avatar: ImageView = itemView.findViewById(R.id.item_photo)
        var name: TextView = itemView.findViewById(R.id.item_name)
        var username: TextView = itemView.findViewById(R.id.item_username)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }
}