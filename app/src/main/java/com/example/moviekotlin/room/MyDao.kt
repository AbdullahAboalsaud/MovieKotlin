package com.example.moviekotlin.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviekotlin.models.MovieModel
import com.example.moviekotlin.models.Result
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(list: List<Result>): Completable

    @Query("select * from Result")
    fun getMovies(): Single<List<Result>>


}







