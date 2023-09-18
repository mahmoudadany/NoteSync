package com.mahmoudadany.notesync.ui.main

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mahmoudadany.notesync.R
import com.mahmoudadany.notesync.pojo.NoteBook
import com.mahmoudadany.notesync.ui.main.fragment.EditNoteBookFragment
import kotlinx.android.synthetic.main.notebook_items.view.*

class NoteBookAdapter(val notebooks: List<NoteBook>,val manger: FragmentManager): RecyclerView.Adapter<NoteBookAdapter.NoteBookViewHolder>() {
//    lateinit var notebooks: List<NoteBook>
//fun setList(){
//    this.notebooks=notebooks
//}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteBookViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.notebook_items,null,false)
        return NoteBookViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(notebooks==null) return 0
        return if (notebooks.size<=10)
            notebooks.size
        else
            10
    }

    override fun onBindViewHolder(holder: NoteBookViewHolder, position: Int) {
        holder.itemView.notebook_name.text=notebooks[position].title
        holder.itemView.image.setImageResource(notebooks[position].color)

        holder.itemView.setOnClickListener(View.OnClickListener {
            val editNoteBookFragment= EditNoteBookFragment.newInstance(notebooks.get(position))
            manger.beginTransaction().replace(R.id.mainactivity_frame,editNoteBookFragment).addToBackStack(null).commit()

        })
    }

    class NoteBookViewHolder(itemView: View): ViewHolder(itemView){

    }
}
