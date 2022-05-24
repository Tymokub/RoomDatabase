package com.example.nauczyciel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nauczyciel.data.SubjectViewModel
import com.example.nauczyciel.databinding.FragmentShowClassesBinding
import kotlinx.android.synthetic.main.fragment_show_classes.view.*


class showClassesFragment : Fragment() {

    private lateinit var mSubjectViewModel: SubjectViewModel
    private var _binding: FragmentShowClassesBinding? = null
    private val binding get() = _binding!!




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_show_classes, container, false)


        val adapter=SubjectListAdapter()
        val recyclerView=view.subject_recyclerview
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(requireContext())

        mSubjectViewModel=ViewModelProvider(this).get(SubjectViewModel::class.java)
        mSubjectViewModel.readAllData.observe(viewLifecycleOwner, Observer { subject->
            adapter.setData(subject)
        })



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }



}