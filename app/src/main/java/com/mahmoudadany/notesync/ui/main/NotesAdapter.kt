package com.mahmoudadany.notesync.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mahmoudadany.notesync.R
import com.mahmoudadany.notesync.pojo.NoteBook
import com.mahmoudadany.notesync.ui.main.fragment.EditNoteBookFragment
import kotlinx.android.synthetic.main.note_items.view.*

class NotesAdapter(val list:List<NoteBook>,val manger:FragmentManager): RecyclerView.Adapter<NotesAdapter.ViewHolder>() {
    val bundle: Bundle = Bundle()
    lateinit var context:Context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.note_items,null,false)
        context=parent.context.applicationContext
       return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        if (list==null) return 0
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.note_item_title.text=list.get(position).title
        holder.itemView.note_item_body.text=list.get(position).body

        Glide.with(context)
            .load(list.get(position).color)
            .circleCrop()
            .into(holder.itemView.note_item_icon)


        holder.itemView.setOnClickListener(View.OnClickListener {
            val editNoteBookFragment= EditNoteBookFragment.newInstance(list.get(position))
            manger.beginTransaction().replace(R.id.mainactivity_frame,editNoteBookFragment).addToBackStack(null).commit()

        })

//        val url=URL(list.get(position).color.toString())
//        Glide.with(holder.itemView.context).load(url).apply(RequestOptions.circleCropTransform()).into(holder.itemView.note_item_icon)

    }
}