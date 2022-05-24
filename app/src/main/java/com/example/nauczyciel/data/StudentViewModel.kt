package com.example.nauczyciel.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentViewModel(application: Application): AndroidViewModel(application) {

    val readAllData:LiveData<List<Student>>
    private val repository: StudentRepository

    init {
        val studentDao = MainDatabase.getDatabase(application).studentDao()
        repository= StudentRepository(studentDao)
        readAllData= repository.readAllData
    }

    fun addStudent(student: Student){

        viewModelScope.launch(Dispatchers.IO) {

            repository.addStudent(student)

        }

    }

    fun getStudents(students:List<Int>):List<Student>{

        val allStudents=repository.readAllData
        return allStudents.value?.filter { student -> students.contains(student.album_number) }!!

    }

    //fun randomStudent(){

       // repository.randomStudent()

    //}

}