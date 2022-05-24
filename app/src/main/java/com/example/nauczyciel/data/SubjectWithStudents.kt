package com.example.nauczyciel.data

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class SubjectWithStudents(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "name",
        entityColumn = "album_number",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val students: List<Student>
) {
}