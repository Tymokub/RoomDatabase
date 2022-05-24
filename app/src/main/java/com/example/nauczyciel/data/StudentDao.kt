package com.example.nauczyciel.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    //Zapytaj o korutyny
    fun addStudent(student: Student)

    @Query("SELECT * FROM student_table ORDER BY album_number ASC")
    fun readAllData(): LiveData<List<Student>>

    @Query("SELECT * FROM student_table WHERE album_number = :id")
    fun getOneByAlbumId(id: Int): Student

    @Query("DELETE FROM student_table")
    fun deleteStudents()

    @Query("DELETE FROM studentsubjectcrossref")
    fun deleteStudentsRel()

    @Query ("SELECT * FROM student_table ORDER BY RANDOM() LIMIT 1 ")
    fun randomStudent(): Student

    @Delete
    fun delete(student: Student)
}