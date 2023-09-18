package com.mahmoudadany.notesync.ui.main.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mahmoudadany.notesync.R
import com.mahmoudadany.notesync.data.local.Room.Repo
import com.mahmoudadany.notesync.data.local.Room.RoomDb
import com.mahmoudadany.notesync.pojo.NoteBook
import kotlinx.android.synthetic.main.fragment_create_note_book.*

class CreateNoteBook : Fragment(), View.OnClickListener {
    lateinit var repo: Repo
    var colorId:Int= R.drawable.color_5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repo = Repo(RoomDb.getInstance(requireContext()))


        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_note_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        color_1.setOnClickListener(this)
        color_2.setOnClickListener(this)
        color_3.setOnClickListener(this)
        color_4.setOnClickListener(this)
        color_5.setOnClickListener(this)
        color_6.setOnClickListener(this)
        color_7.setOnClickListener(this)
        color_8.setOnClickListener(this)
        color_9.setOnClickListener(this)

        create_iv_image.setOnClickListener(View.OnClickListener {
            create_cv_background.visibility= View.VISIBLE
        })
        create_bt_save.setOnClickListener(
            View.OnClickListener {
                createNewNote()

            }
        )

        create_ed_title.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                create_bt_save.isEnabled = s != null
                if(create_cv_background.visibility== View.VISIBLE) create_cv_background.visibility=
                    View.GONE

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CreateNoteBook().apply {
                arguments = Bundle().apply {
                }
            }
    }

    fun createNewNote() {
        val title = create_ed_title.text.toString()
        val background: Int = colorId
        val note= NoteBook(title = title, color = background)
        repo.insert(note)
        val transaction=activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.mainactivity_frame,MainFragment())
        transaction?.addToBackStack("main")
        transaction?.commit()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.color_1 ->{
                colorId= R.drawable.color_1
                create_iv_image.setImageResource(colorId)
                create_cv_background.visibility= View.GONE

            }
            R.id.color_2 ->{
                colorId= R.drawable.color_2
                create_iv_image.setImageResource(colorId)
                create_cv_background.visibility= View.GONE
            }
            R.id.color_3 ->{
                colorId= R.drawable.color_3
                create_iv_image.setImageResource(colorId)
                create_cv_background.visibility= View.GONE
            }
            R.id.color_4 ->{
                colorId= R.drawable.color_4
                create_iv_image.setImageResource(colorId)
                create_cv_background.visibility= View.GONE
            }
            R.id.color_5 ->{
                colorId= R.drawable.color_5
                create_iv_image.setImageResource(colorId)
                create_cv_background.visibility= View.GONE
            }
            R.id.color_6 ->{
                colorId= R.drawable.color_6
                create_iv_image.setImageResource(colorId)
                create_cv_background.visibility= View.GONE
            }
            R.id.color_7 ->{
                colorId= R.drawable.color_7
                create_iv_image.setImageResource(colorId)
                create_cv_background.visibility= View.GONE
            }
            R.id.color_8 ->{
                colorId= R.drawable.color_8
                create_iv_image.setImageResource(colorId)
                create_cv_background.visibility= View.GONE
            }
            R.id.color_9 ->{
                colorId= R.drawable.color_9
                create_iv_image.setImageResource(colorId)
                create_cv_background.visibility= View.GONE
            }
        }
    }

}