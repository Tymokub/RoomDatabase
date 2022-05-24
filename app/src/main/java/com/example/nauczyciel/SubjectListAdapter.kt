package com.example.nauczyciel


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.nauczyciel.data.Subject
import kotlinx.android.synthetic.main.subject_row.view.*

class SubjectListAdapter: RecyclerView.Adapter<SubjectListAdapter.MyViewHolder>() {

    private var subjectList=emptyList<Subject>()




    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){


        private val button_assign: Button = itemView.findViewById(R.id.button_assign)
        private val subjectname: TextView=itemView.findViewById(R.id.subject_nametxtview)
        private val button_in:Button=itemView.findViewById(R.id.button_in)


        init {
            button_assign.setOnClickListener {

                val action = showClassesFragmentDirections.actionShowClassesFragmentToStudentAsiggnFragment(subjectname.text.toString())
                it.findNavController().navigate(action)
            }

            button_in.setOnClickListener {

                val action = showClassesFragmentDirections.actionShowClassesFragmentToStudentShowFragment(subjectname.text.toString())
                it.findNavController().navigate(action)

            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {



        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.subject_row,parent,false))


    }

    override fun getItemCount(): Int {
        return subjectList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem=subjectList[position]
        holder.itemView.subject_nametxtview.text=currentItem.name
        holder.itemView.subject_daytxtview.text=currentItem.day
        holder.itemView.subject_blocktxtview.text=currentItem.block




    }

    fun setData(subject: List<Subject>){

        this.subjectList=subject
        notifyDataSetChanged()

    }

}