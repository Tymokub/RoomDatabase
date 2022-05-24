package com.example.nauczyciel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.nauczyciel.data.MainDatabase
import com.example.nauczyciel.data.Student
import com.example.nauczyciel.data.StudentSubjectCrossRef
import com.example.nauczyciel.data.StudentViewModel


class StudentAsiggnAdapter(val subjectname:String): RecyclerView.Adapter<StudentAsiggnAdapter.MyViewHolder>() {

    private var studentList=emptyList<Student>()


    inner class MyViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView){

        val name:TextView=itemView.findViewById(R.id.studentasiggnname_txtview)
        val lastname:TextView=itemView.findViewById(R.id.studentasiggnlastname_txtview)
        val number:TextView=itemView.findViewById(R.id.studentasiggnnumber_txtview)
        val database=MainDatabase.getConnection()


        private val studentasiggn_button: Button = itemView.findViewById(R.id.studentasiggn_button)
        init {

            studentasiggn_button.setOnClickListener {

                val studentrelation: StudentSubjectCrossRef= StudentSubjectCrossRef(number.text.toString().toInt(),subjectname)
                database.subjectDao().assignStudent(studentrelation)

                Toast.makeText(itemView.context, "Added successfully :D", Toast.LENGTH_LONG).show()


            }

        }

    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.studentasiggn_row, viewGroup, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentAsiggnAdapter.MyViewHolder, position: Int) {
        val currentItem=studentList[position]
        holder.name.text=currentItem.firstname
        holder.lastname.text=currentItem.lastname
        holder.number.text=currentItem.album_number.toString()


    }

    fun setData(student: List<Student>){

        this.studentList=student
        notifyDataSetChanged()

    }

}