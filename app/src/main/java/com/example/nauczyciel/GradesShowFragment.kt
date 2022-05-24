package com.example.nauczyciel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_grades_show.view.*


class GradesShowFragment : Fragment() {


    private val args: GradesShowFragmentArgs by navArgs()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_grades_show, container, false)
        val adapter=GradesShowAdapter(args.subjectname,args.albumNumber)
        val recyclerView=view.grades_show_recycler
        recyclerView.adapter=adapter
        recyclerView.layoutManager= LinearLayoutManager(requireContext())





        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}