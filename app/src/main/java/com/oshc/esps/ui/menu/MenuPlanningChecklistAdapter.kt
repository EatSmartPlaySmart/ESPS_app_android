package com.oshc.esps.ui.menu

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.oshc.esps.R
import com.oshc.esps.databinding.MenuPlanningChecklistItemBinding

class MenuPlanningChecklistAdapter(val checklist: List<CheckListData>): RecyclerView.Adapter<MenuPlanningChecklistAdapter.MenuPlanningChecklistViewHolder>() {


    inner class MenuPlanningChecklistViewHolder(val binding: MenuPlanningChecklistItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(checklist: CheckListData) {
            binding.checklist = checklist
            binding.executePendingBindings()
        }

        var descBtn = binding.root.findViewById<ImageView>(R.id.ivMenuPlanningCheckListItemDesc)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuPlanningChecklistViewHolder {
        val binding: MenuPlanningChecklistItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.menu_planning_checklist_item, parent, false)
        return MenuPlanningChecklistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuPlanningChecklistViewHolder, position: Int) {
        checklist.get(position).let { holder.bind(it) }

        if (checklist[position].desc.isNotEmpty()) {
            holder.descBtn.setOnClickListener {
                val dialog = AlertDialog.Builder(it.context)
                dialog.setTitle("Note")
                dialog.setMessage(checklist[position].desc)
                dialog.create().show()
            }
        } else {
            holder.descBtn.visibility = View.INVISIBLE
        }
    }

    override fun getItemCount(): Int = checklist.size
}