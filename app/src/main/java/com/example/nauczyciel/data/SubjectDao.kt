package com.example.nauczyciel.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubjectDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addSubject(subject: Subject)

    @Query("SELECT * FROM `subject_table` WHERE name = :id")
    fun getOneById(id: String): Subject

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun assignStudent(studentSubjectCrossRef:StudentSubjectCrossRef)

    @Query( "SELECT * FROM 'studentsubjectcrossref' WHERE name=:subjectname")
    fun getSubjectStudents(subjectname:String): List<StudentSubjectCrossRef>

    @Query("SELECT * FROM subject_table ORDER BY name ASC")
    fun readAllData(): LiveData<List<Subject>>

    @Query("DELETE FROM `subject_table` WHERE name = :id")
    fun delete(id: Int)

    @Query("DELETE FROM `subject_table`")
    fun deleteAll()
}