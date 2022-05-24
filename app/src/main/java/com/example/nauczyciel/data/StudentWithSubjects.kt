package com.example.nauczyciel.data

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class StudentWithSubjects(
    @Embedded val student: Student,
    @Relation(
        parentColumn="album_number",
        entityColumn = "name",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>
    ) {
}