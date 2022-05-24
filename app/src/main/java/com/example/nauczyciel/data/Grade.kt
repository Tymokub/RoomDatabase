package com.example.nauczyciel.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "grade_table")
data class Grade (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val value: Float,
    val studentId: Int,
    val subjectId: String,
)
