package com.example.nauczyciel.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SubjectRepository(private val subjectDao: SubjectDao) {

    val readAllData: LiveData<List<Subject>> = subjectDao.readAllData()
    private val database = MainDatabase.getConnection()

    fun addSubject(subject: Subject){

        subjectDao.addSubject(subject)

    }

    fun getOneById(id: String): Subject {
        return database.subjectDao().getOneById(id)
    }

    fun assignStudent(subjectwithstudent:StudentSubjectCrossRef){


        subjectDao.assignStudent(subjectwithstudent)


    }

    fun getSubjectStudents(subjectname: String):List<StudentSubjectCrossRef>{

         return subjectDao.getSubjectStudents(subjectname)


    }

    fun delete(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            database.subjectDao().delete(id)
        }
    }

}