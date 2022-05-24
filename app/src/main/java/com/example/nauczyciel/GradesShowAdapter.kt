package com.example.nauczyciel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nauczyciel.data.*

class GradesShowAdapter(val subjectname:String,val album_number:Int): RecyclerView.Adapter<GradesShowAdapter.MyViewHolder>() {




    val database= MainDatabase.getConnection()
    private var gradeList=database.gradeDao().getStudentGradesInSubject(album_number,subjectname)
    inner class MyViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView){

        val value: TextView =itemView.findViewById(R.id.grade_valuetxtview)


        init {


        }

    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.grades_show_row, viewGroup, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return gradeList.size
    }

    override fun onBindViewHolder(holder: GradesShowAdapter.MyViewHolder, position: Int) {
        val currentItem=gradeList[position]
        holder.value.text=currentItem.value.toString()



    }

    fun setData(grade: List<Grade>){

        this.gradeList=grade
        notifyDataSetChanged()

    }

}
