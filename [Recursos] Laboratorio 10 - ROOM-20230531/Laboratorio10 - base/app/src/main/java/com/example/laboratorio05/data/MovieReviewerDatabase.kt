package com.example.laboratorio05.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.laboratorio05.data.dao.ActorDao
import com.example.laboratorio05.data.dao.CastDao
import com.example.laboratorio05.data.dao.MovieDao
import com.example.laboratorio05.data.model.ActorModel
import com.example.laboratorio05.data.model.CastModel
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.ui.movie.viewmodel.MovieViewModel

@Database(entities = [MovieModel:: class, ActorModel::class ,CastModel::class], version = 2)
abstract class MovieReviewerDatabase : RoomDatabase(){
    abstract fun movieDao(): MovieDao
    abstract fun actorDao(): ActorDao
    abstract fun castDao(): CastDao

    companion object{
        @Volatile
        private var INSTANCE : MovieReviewerDatabase? = null

        fun newIntance(application: Application): MovieReviewerDatabase {
            val instace = Room
                .databaseBuilder(
                    application.applicationContext,
                    MovieReviewerDatabase::class.java,
                    "movie_reviewer"
                ).fallbackToDestructiveMigration().build()
            INSTANCE = instace
            return instace
            }
        }
    }
