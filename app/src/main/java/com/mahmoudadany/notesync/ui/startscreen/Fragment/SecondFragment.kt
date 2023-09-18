package com.mahmoudadany.notesync.ui.startscreen.Fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mahmoudadany.notesync.R
import com.mahmoudadany.notesync.data.local.Shared
import com.mahmoudadany.notesync.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_secend.*

class SecondFragment : Fragment() {

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
        val view=inflater.inflate(R.layout.fragment_secend, container, false)
        return view
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        second_bt_back.setOnClickListener(){
            val transient=activity?.supportFragmentManager?.beginTransaction()
            transient?.replace(R.id.main_frame, FirstFragment())
            transient?.commit()
        }
        second_bt_next.setOnClickListener(){
            try {
                val shard= Shared.getInstance(context!!)
                shard.setData(true)
                startActivity(Intent(activity, MainActivity::class.java))
                Toast.makeText(context,""+shard.getData(),Toast.LENGTH_SHORT).show()
                activity?.finish()
            }catch (e:Exception){
                Toast.makeText(context,"dfjkj",Toast.LENGTH_SHORT).show()
            }

        }

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}