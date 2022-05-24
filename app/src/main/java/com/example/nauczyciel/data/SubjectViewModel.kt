package com.example.nauczyciel.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SubjectViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Subject>>
    private val repository: SubjectRepository




    init {
        val subjectDao = MainDatabase.getDatabase(application).subjectDao()
        repository= SubjectRepository(subjectDao)
        readAllData= repository.readAllData
    }

    fun addSubject(subject: Subject){

        viewModelScope.launch(Dispatchers.IO) {

            repository.addSubject(subject)

        }

    }

    fun getSubjectStudents(subjectname: String): List<StudentSubjectCrossRef>{



           return repository.getSubjectStudents(subjectname)


    }

}