package com.example.nauczyciel.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName = "student_table")
data class Student(
    @PrimaryKey(autoGenerate = false)
    val album_number: Int,
    val firstname: String,
    val lastname: String,
)