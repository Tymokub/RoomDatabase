package com.example.nauczyciel


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.nauczyciel.data.*
import kotlinx.android.synthetic.main.studentshow_row.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudentShowAdapter(var subjectname: String,val mStudentViewModel: StudentViewModel,val mSubjectViewModel: SubjectViewModel): RecyclerView.Adapter<StudentShowAdapter.MyViewHolder>() {

    //private var studentsRelationList=emptyList<StudentSubjectCrossRef>()
    private val database = MainDatabase.getConnection()
    private var studentList= emptyList<Student>()







    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private val gradeadd_btn: Button=itemView.findViewById(R.id.studentshow_addbtn)
        private val gradein_btn:Button=itemView.findViewById(R.id.studentshow_gradesbtn)


        init {
            gradeadd_btn.setOnClickListener {

                val album_number=itemView.studentshow_number.text.toString().toInt()
                val popupMenu=PopupMenu(itemView.context,it)
                popupMenu.setOnMenuItemClickListener { item->
                    when (item.itemId){

                        R.id.menu_two->{
                            val entity=Grade(0,2.0f,album_number,subjectname)
                            database.gradeDao().addGrade(entity)
                            Toast.makeText(itemView.context,"Added Sucessfuly :D",Toast.LENGTH_SHORT).show()
                            true}
                        R.id.menu_twohalf->{
                            val entity=Grade(0,2.5f,album_number,subjectname)
                            database.gradeDao().addGrade(entity)
                            Toast.makeText(itemView.context,"Added Sucessfuly :D",Toast.LENGTH_SHORT).show()
                            true}
                        R.id.menu_three->{
                            val entity=Grade(0,3f,album_number,subjectname)
                            database.gradeDao().addGrade(entity)
                            Toast.makeText(itemView.context,"Added Sucessfuly :D",Toast.LENGTH_SHORT).show()
                            true}
                        R.id.menu_threehalf->{
                            val entity=Grade(0,3.5f,album_number,subjectname)
                            database.gradeDao().addGrade(entity)
                            Toast.makeText(itemView.context,"Added Sucessfuly :D",Toast.LENGTH_SHORT).show()
                            true}
                        R.id.menu_four->{
                            val entity=Grade(0,4f,album_number,subjectname)
                            database.gradeDao().addGrade(entity)
                            Toast.makeText(itemView.context,"Added Sucessfuly :D",Toast.LENGTH_SHORT).show()
                            true}
                        R.id.menu_fourhalf->{
                            val entity=Grade(0,4.5f,album_number,subjectname)
                            database.gradeDao().addGrade(entity)
                            Toast.makeText(itemView.context,"Added Sucessfuly :D",Toast.LENGTH_SHORT).show()
                            true}
                        R.id.menu_five->{
                            val entity=Grade(0,5f,album_number,subjectname)
                            database.gradeDao().addGrade(entity)
                            Toast.makeText(itemView.context,"Added Sucessfuly :D",Toast.LENGTH_SHORT).show()
                            true}
                        else->false

                    }
                }
                popupMenu.inflate(R.menu.grade_menu)
                popupMenu.show()

            }
            gradein_btn.setOnClickListener {

                val action = StudentShowFragmentDirections.actionStudentShowFragmentToGradesShowFragment(subjectname,itemView.studentshow_number.text.toString().toInt())
                it.findNavController().navigate(action)

            }



        }

        fun loadData(position: Int){
            CoroutineScope(IO).launch{
                val subjectstudents=mSubjectViewModel.getSubjectStudents(subjectname)
                studentList=mStudentViewModel.getStudents(subjectstudents.map { st ->st.album_number  })
                withContext(Main){

                    val currentItem=studentList[position]
                    itemView.studentshow_name.text=currentItem.firstname.toString()
                    itemView.studentshow_lastname.text=currentItem.lastname.toString()
                    itemView.studentshow_number.text=currentItem.album_number.toString()
                }

            }


        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {


        //subjectstudents.value?.get(0)?.album_number



        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.studentshow_row,parent,false))


    }


    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        holder.loadData(position)

    }



    fun setData(student: List<Student>){
        val subjectstudents=mSubjectViewModel.getSubjectStudents(subjectname)
        this.studentList=mStudentViewModel.getStudents(subjectstudents.map { st ->st.album_number  })
        notifyDataSetChanged()

    }

}