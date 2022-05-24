package com.example.nauczyciel.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentRepository(private val studentDao: StudentDao) {

    val readAllData: LiveData<List<Student>> = studentDao.readAllData()
    private val database = MainDatabase.getConnection()

    fun addStudent(student: Student){

        studentDao.addStudent(student)

    }

    fun getOneByAlbumId(id: Int): Student {
        return database.studentDao().getOneByAlbumId(id)
    }

    fun delete(student: Student) {
        CoroutineScope(Dispatchers.IO).launch {
            database.studentDao().delete(student)
        }
    }

    fun randomStudent(): Student{

        return database.studentDao().randomStudent()

    }



}