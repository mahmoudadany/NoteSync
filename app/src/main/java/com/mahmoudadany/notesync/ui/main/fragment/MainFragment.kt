package com.mahmoudadany.notesync.ui.main.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mahmoudadany.notesync.R
import com.mahmoudadany.notesync.data.local.Room.Repo
import com.mahmoudadany.notesync.data.local.Room.RoomDb
import com.mahmoudadany.notesync.pojo.NoteBook
import com.mahmoudadany.notesync.ui.main.NoteBookAdapter
import com.mahmoudadany.notesync.ui.main.NotesAdapter
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.*

class MainFragment : Fragment() {
    val notesArray = ArrayList<NoteBook>()
    lateinit var adapter: NoteBookAdapter
    lateinit var mainadapter: NotesAdapter

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val roomDb = RoomDb.getInstance(requireContext())
        val repo = Repo(roomDb)
        GlobalScope.launch {

            val get = async() {
                roomDb.getDao().getAllNote()
            }

            withContext(Dispatchers.Main) {
                get.join()
                val list = get.await()
                if (list.isEmpty()) {
                    main_fm_iv_create_new.visibility = VISIBLE
                    main_fm_tv_text.visibility = VISIBLE
                } else {
                    main_fm_iv_create_new.visibility = GONE
                    main_fm_tv_text.visibility = GONE
                    adapter = NoteBookAdapter(get.await(), activity?.supportFragmentManager!!)
                    mainadapter =
                        NotesAdapter(get.await(), requireActivity().supportFragmentManager)
                    main_fm_rv_notebooks.adapter = adapter
                    main_rv_mainnote.adapter = mainadapter

                }

            }
        }

        main_fm_rv_notebooks.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        main_fm_rv_notebooks.setHasFixedSize(true)

        main_rv_mainnote.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        main_rv_mainnote.setHasFixedSize(true)

        main_fm_iv_create_new.setOnClickListener(View.OnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.mainactivity_frame, CreateNoteBook())
            transaction?.addToBackStack("main")
            transaction?.commit()
        })


        main_bt_create_note.setOnClickListener() {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.mainactivity_frame, CreateNoteBook())
            transaction?.addToBackStack("main")
            transaction?.commit()
        }


    }
//    companion object {
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            MainFragment().apply {
//                arguments = Bundle().apply {
//                }
//            }
//    }
}