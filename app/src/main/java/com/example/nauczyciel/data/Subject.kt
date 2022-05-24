package com.example.nauczyciel.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="subject_table")
data class Subject(
    @PrimaryKey(autoGenerate = false)
    val name: String,
    val day: String,
    val block: String,

)
