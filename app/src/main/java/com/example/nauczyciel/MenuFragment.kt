package com.example.nauczyciel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.nauczyciel.data.Student
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlinx.android.synthetic.main.fragment_menu.view.*


class MenuFragment : Fragment() {

    private lateinit var mMenuViewModel: MenuViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mMenuViewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
        val view=inflater.inflate(R.layout.fragment_menu, container, false)


        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        (view.findViewById<Button>(R.id.btn_add_classes)).setOnClickListener{


            it.findNavController().navigate(R.id.action_menuFragment_to_classesAddFragment)

        }
        (view.findViewById<Button>(R.id.btn_add_student)).setOnClickListener{

            it.findNavController().navigate(R.id.action_menuFragment_to_studentAddFragment)

        }
        (view.findViewById<Button>(R.id.btn_show_classes)).setOnClickListener{

            it.findNavController().navigate(R.id.action_menuFragment_to_showClassesFragment)

        }

        view.btn_clear_database.setOnClickListener {

            mMenuViewModel.deleteAll()

        }


        (view.findViewById<Button>(R.id.button)).setOnClickListener {

            if(mMenuViewModel.lucky()!=null) {
                luckyname.text = mMenuViewModel.lucky().firstname
                luckylastname.text = mMenuViewModel.lucky().lastname
                luckynumber.text = mMenuViewModel.lucky().album_number.toString()

                val txt = "Lucky one!"
                Toast.makeText(requireContext(), txt, Toast.LENGTH_SHORT).show()
            }


        }


    }
}