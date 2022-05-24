package com.example.nauczyciel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.nauczyciel.databinding.FragmentClassesAddBinding
import com.example.nauczyciel.data.Subject
import com.example.nauczyciel.data.SubjectViewModel
import kotlinx.android.synthetic.main.fragment_classes_add.*
import kotlinx.android.synthetic.main.fragment_classes_add.view.*


class ClassesAddFragment : Fragment() {

    private lateinit var mSubjectViewModel: SubjectViewModel
    private var _binding: FragmentClassesAddBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_classes_add, container, false)
        mSubjectViewModel= ViewModelProvider(this).get(SubjectViewModel::class.java)
        _binding = FragmentClassesAddBinding.inflate(inflater, container, false)

        view.btn_add_subject_true.setOnClickListener {

            insertDataToDatabase()

        }
        return view
    }

    private fun insertDataToDatabase(){

        val name=txtview_subject_name.text.toString()
        val day=txtview_subject_day.text.toString()
        val block=txt_subject_block.text.toString()

        if(inputCheck(name,day,block)){

            val subject= Subject(name,day,block)
            mSubjectViewModel.addSubject(subject)
            Toast.makeText(requireContext(),"Added successfully :D", Toast.LENGTH_LONG).show()

        }
        else{

            Toast.makeText(requireContext(),"Fill all the fields!", Toast.LENGTH_LONG).show()

        }

    }

    private fun inputCheck(name:String,day:String,block:String):Boolean{

        binding.txtSubjectBlock.error = ""
        binding.txtviewSubjectDay.error = ""
        binding.txtviewSubjectName.error = ""
        val tmp=day.toString()
        val nameIsValid = name.length in 3..20
        val dayIsValid = day.length in 3..13
        val blockIsValid = block.length in 1..11

        when {
            nameIsValid.not() -> {
                binding.txtviewSubjectName.error = resources.getString(R.string.wrong_input)
            }
            dayIsValid.not() -> {
                binding.txtviewSubjectDay.error = resources.getString(R.string.wrong_input)
            }
            blockIsValid.not() -> {
                binding.txtSubjectBlock.error = resources.getString(R.string.wrong_input)
            }

        }
        nameIsValid and dayIsValid and blockIsValid

        if(nameIsValid and dayIsValid and blockIsValid)
        {return true}
        else{return false}
    }
}