package com.example.nauczyciel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.nauczyciel.data.MainDatabase
import com.example.nauczyciel.data.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MenuViewModel(application: Application): AndroidViewModel(application) {

    private val database = MainDatabase.getDatabase(application)
    fun deleteAll() {

        CoroutineScope(Dispatchers.IO).launch {
            database.gradeDao().deleteAll()
            database.subjectDao().deleteAll()
            database.studentDao().deleteStudents()
            database.studentDao().deleteStudentsRel()
        }
    }

    fun lucky(): Student{

        return database.studentDao().randomStudent()

    }
}