package com.mahmoudadany.notesync.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mahmoudadany.notesync.R
import com.mahmoudadany.notesync.data.local.Room.Repo
import com.mahmoudadany.notesync.data.local.Room.RoomDb
import com.mahmoudadany.notesync.pojo.NoteBook
import kotlinx.android.synthetic.main.fragment_edit_note_book.*

class EditNoteBookFragment : Fragment() {
    private var note: NoteBook? = null
    lateinit var repo: Repo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            note= it.getSerializable("note") as NoteBook?
                repo= Repo(RoomDb.getInstance(requireContext()))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_note_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        edit_note_tv_title.text=note?.title
        edit_note_et_body.setText(note?.body ?: note?.body)


        edit_note_iv_back.setOnClickListener(View.OnClickListener {

            activity?.supportFragmentManager?.beginTransaction()?.replace(
                R.id.mainactivity_frame,
                MainFragment()
            )?.commit()

            val body= edit_note_et_body.text.toString()
            note?.body= body
            repo.update(note!!)
        })

    }

    override fun onStop() {
        super.onStop()
       val body= edit_note_et_body.text
        note?.body= body.toString()
        repo.update(note!!)

    }
    companion object {

        @JvmStatic
        fun newInstance(noteBook: NoteBook) =
            EditNoteBookFragment().apply {
                arguments = Bundle().apply {
                    putSerializable("note", noteBook)
                }
            }
    }
}