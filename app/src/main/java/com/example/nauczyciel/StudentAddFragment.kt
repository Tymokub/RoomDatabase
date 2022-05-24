package com.example.nauczyciel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.nauczyciel.data.Student
import com.example.nauczyciel.data.StudentViewModel
import com.example.nauczyciel.databinding.FragmentStudentAddBinding
import kotlinx.android.synthetic.main.fragment_student_add.*
import kotlinx.android.synthetic.main.fragment_student_add.view.*


class StudentAddFragment : Fragment() {

    private lateinit var mStudentViewModel: StudentViewModel
    private var _binding: FragmentStudentAddBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_student_add, container, false)

        _binding = FragmentStudentAddBinding.inflate(inflater, container, false)

        mStudentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)

        view.btn_add_student_true.setOnClickListener {

            insertDataToDatabase()

        }
        return view
    }

    private fun insertDataToDatabase() {

        val firstname = txtview_student_firstname.text.toString()
        val lastname = txtview_student_lastname.text.toString()
        var number = txtview_student_number.text.toString()

        if (inputCheck(number, firstname, lastname)) {
            var number = number.toInt()
            val student = Student(number, firstname, lastname)

            mStudentViewModel.addStudent(student)
            Toast.makeText(requireContext(), "Added successfully :D", Toast.LENGTH_LONG).show()

        } else {

            Toast.makeText(requireContext(), "Input correct data", Toast.LENGTH_LONG).show()

        }

    }

    private fun inputCheck(number: String, firstname: String, lastname: String): Boolean {

        binding.txtviewStudentFirstname.error = ""
        binding.txtviewStudentLastname.error = ""
        binding.txtviewStudentNumber.error = ""
        val nameIsValid = firstname.length in 3..60
        val surnameIsValid = lastname.length in 3..60
        val albumIdIsValid =
            (number.toIntOrNull()?.let { true } ?: false) && (number.length in 3..10)
        when {
            nameIsValid.not() -> {
                binding.txtviewStudentFirstname.error = resources.getString(R.string.wrong_input);
            }
            surnameIsValid.not() -> {
                binding.txtviewStudentLastname.error = resources.getString(R.string.wrong_input);
            }
            albumIdIsValid.not() -> {
                binding.txtviewStudentNumber.error = resources.getString(R.string.wrong_input);
            }

        }
        nameIsValid and surnameIsValid and albumIdIsValid

        if(nameIsValid and surnameIsValid and albumIdIsValid)
        {return true}
        else{return false}
    }
}