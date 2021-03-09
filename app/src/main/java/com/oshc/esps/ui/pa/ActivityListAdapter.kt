package com.oshc.esps.ui.pa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.oshc.esps.R
import com.oshc.esps.databinding.ActivityListItemBinding

class ActivityListAdapter(var activityList: List<Activity>): RecyclerView.Adapter<ActivityListAdapter.ActivityListViewHolder>() {

    inner class ActivityListViewHolder(var binding: ActivityListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(activity: Activity) {
            binding.activity = activity
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityListViewHolder {
        val binding: ActivityListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.activity_list_item, parent, false)
        return ActivityListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActivityListViewHolder, position: Int) {
        holder.bind(activityList[position])

        holder.itemView.setOnClickListener {
            // pass current activity object to details fragment
            val bundle = Bundle()
            bundle.putParcelable(holder.itemView.context.getString(R.string.activity_parcel_key), activityList[position])
            Navigation.findNavController(holder.itemView).navigate(R.id.action_activityFragment_to_activityDetailsFragment, bundle)
        }
    }

    override fun getItemCount(): Int = activityList.size
}


