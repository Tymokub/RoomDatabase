package com.example.nauczyciel.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GradeRepository {
    private val database = MainDatabase.getConnection()

    fun addGrade(entity: Grade) {
        CoroutineScope(Dispatchers.IO).launch {
            database.gradeDao().addGrade(entity)
        }
    }

    fun add(value: Float, subjectId: String, albumId: Int) {
        val entity = Grade(
            value = value,
            subjectId = subjectId,
            studentId = albumId,
        )
        addGrade(entity)
    }


    fun delete(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            database.gradeDao().delete(id)
        }
    }


}