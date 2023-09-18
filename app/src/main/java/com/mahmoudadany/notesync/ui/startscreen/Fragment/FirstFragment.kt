package com.mahmoudadany.notesync.ui.startscreen.Fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mahmoudadany.notesync.R
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, parent, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        first_bt_next.setOnClickListener(){
            val transaction=activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.main_frame, SecondFragment())
            transaction?.commit()
        }

    }

    companion object {

        @JvmStatic
        fun newInstance(context: Context) =
            FirstFragment().apply {

            }
    }
}