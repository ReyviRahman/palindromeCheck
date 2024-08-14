package com.rey.palindromecheck.ui.third

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rey.palindromecheck.data.remote.retrofit.response.DataItem
import com.rey.palindromecheck.databinding.ItemUserBinding

class UserAdapter(private val sendUsername: (String) -> Unit) :
    PagingDataAdapter<DataItem, UserAdapter.MyViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding, sendUsername)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) {
            holder.bind(data)
        }
    }

    class MyViewHolder(private val binding: ItemUserBinding, private val sendUsername: (String) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataItem) {
            Glide.with(binding.root.context)
                .load(data.avatar)
                .into(binding.ivUser)
            val fullName = "${data.firstName} ${data.lastName}"
            binding.tvName.text = fullName
            binding.tvEmail.text = data.email
            itemView.setOnClickListener {
                sendUsername(fullName)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataItem>() {
            override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem.id == newItem.id
            }
        }

        const val EXTRA_NAME = "extra_name"
    }
}