package com.oshc.esps.ui.websites

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.oshc.esps.R
import com.oshc.esps.databinding.UsefulWebsitesListItemBinding


class UsefulWebsitesListAdapter(val websiteList: List<Website>): RecyclerView.Adapter<UsefulWebsitesListAdapter.UsefulWebsiteViewHolder>() {

    inner class UsefulWebsiteViewHolder(val binding: UsefulWebsitesListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(website: Website) {
            binding.website = website
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsefulWebsiteViewHolder {
        val binding: UsefulWebsitesListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.useful_websites_list_item, parent, false)
        return UsefulWebsiteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsefulWebsiteViewHolder, position: Int) {
        holder.bind(websiteList[position])
        val view = holder.binding.root
        view.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(websiteList[position].url))
            view.context.startActivity(browserIntent)
        }
    }

    override fun getItemCount(): Int = websiteList.size


}