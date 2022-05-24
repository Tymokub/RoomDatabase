package com.example.nauczyciel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nauczyciel.data.StudentViewModel

import kotlinx.android.synthetic.main.fragment_studentasiggn.view.*


class StudentAsiggnFragment : Fragment() {
    private lateinit var mStudentViewModel: StudentViewModel
    private val args: StudentAsiggnFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_studentasiggn, container, false)

        val adapter=StudentAsiggnAdapter(args.subjectname)
        val recyclerView=view.studentasiggn_recyclerview
        recyclerView.adapter=adapter
        recyclerView.layoutManager= LinearLayoutManager(requireContext())

        mStudentViewModel= ViewModelProvider(this).get(StudentViewModel::class.java)
        mStudentViewModel.readAllData.observe(viewLifecycleOwner, Observer { student->
            adapter.setData(student)
        })


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}

