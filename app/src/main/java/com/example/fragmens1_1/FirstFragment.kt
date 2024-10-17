package com.example.fragmens1_1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Locale

@Suppress("UNREACHABLE_CODE")
class FirstFragment : Fragment() {

    private var listAdapter: CustomAdapter? = null

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_first, container, false)


    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addBTN: Button = view.findViewById(R.id.addBTN)
        val addET: EditText = view.findViewById(R.id.addET)
        val recyclerViewRV: RecyclerView = view.findViewById(R.id.recyclerviewRV)

        var currentDate = java.util.Date()
        val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        val timeFormat = SimpleDateFormat("HH.mm", Locale.getDefault())
        var id = 0
        listAdapter = CustomAdapter(Note.notes)
        recyclerViewRV.adapter = listAdapter
        listAdapter?.notifyDataSetChanged()

        recyclerViewRV.setHasFixedSize(true)



        addBTN.setOnClickListener {
            id++
            val text = addET.text.toString()
            val date = "${dateFormat.format(currentDate)} ${timeFormat.format(currentDate)}"
            val check = false
            val note = Note(id, text, date, check)
            Note.notes.add(note)
            listAdapter?.notifyDataSetChanged()


        }
    }


}