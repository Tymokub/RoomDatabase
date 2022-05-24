package com.example.nauczyciel.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class,Subject::class,StudentSubjectCrossRef::class,Grade::class], version = 4,exportSchema = false)
abstract class MainDatabase: RoomDatabase(){
    abstract fun studentDao(): StudentDao
    abstract fun subjectDao(): SubjectDao
    abstract fun gradeDao(): GradeDao

    companion object{
        @Volatile
        private var INSTANCE: MainDatabase?=null

        fun getDatabase(context: Context ): MainDatabase{

            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    MainDatabase::class.java,
                    "main_database"
                ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
                INSTANCE=instance
                return instance
            }

        }

        fun getConnection(): MainDatabase {
            return INSTANCE!!
        }
    }

    override fun clearAllTables() {
        clearAllTables()
    }

}
