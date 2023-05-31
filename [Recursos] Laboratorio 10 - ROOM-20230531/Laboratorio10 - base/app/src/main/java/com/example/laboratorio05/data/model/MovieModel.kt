package com.example.laboratorio05.data.model

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

@Dao
@Entity(tableName = "movie_table")
data class MovieModel (
    @PrimaryKey (autoGenerate = true) val movieId: Int,
    @ColumnInfo (name = "name") val name: String,
    @ColumnInfo (name = "categoru")val category: String,
    @ColumnInfo (name = "description")val description: String,
    @ColumnInfo (name = "qualification")val qualification: String,
)
{
    constructor(name:String, category:String, description: String,qualification: String):
            this(0,name,category,description,qualification)
}