package com.example.nauczyciel.data

import androidx.room.Entity
import org.jetbrains.annotations.NotNull

@Entity(primaryKeys = ["album_number","name"])
data class StudentSubjectCrossRef (@NotNull val album_number: Int,@NotNull val name: String) {




}