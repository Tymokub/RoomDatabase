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
import com.example.nauczyciel.data.SubjectViewModel
import kotlinx.android.synthetic.main.fragment_student_show.view.*


class StudentShowFragment : Fragment() {
    private val args: StudentAsiggnFragmentArgs by navArgs()
    private lateinit var mSubjectViewModel: SubjectViewModel
    private lateinit var mStudentViewModel:StudentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_student_show, container, false)
        mSubjectViewModel=ViewModelProvider(this)[SubjectViewModel::class.java]
        mStudentViewModel= ViewModelProvider(this).get(StudentViewModel::class.java)
        val adapter=StudentShowAdapter(args.subjectname,mStudentViewModel,mSubjectViewModel)
        val recyclerView=view.studentshow_recycler
        recyclerView.adapter=adapter
        recyclerView.layoutManager= LinearLayoutManager(requireContext())



        mStudentViewModel.readAllData.observe(viewLifecycleOwner, Observer { student->
            adapter.setData(student)
        })


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}