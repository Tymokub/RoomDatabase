package com.example.nauczyciel.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GradeDao {

    @Insert
    fun addGrade(user: Grade)

    @Query("DELETE FROM grade_table WHERE id = :id")
    fun delete(id: Int)

    @Query("SELECT * FROM grade_table WHERE studentId = :album_number AND subjectId = :name")
    fun getStudentGradesInSubject(album_number: Int, name: String): List<Grade>

    @Query("DELETE FROM grade_table")
    fun deleteAll()

}