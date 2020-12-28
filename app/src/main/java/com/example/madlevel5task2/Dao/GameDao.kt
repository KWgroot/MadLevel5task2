package com.example.madlevel5task2.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.madlevel5task2.Viewmodel.Game

@Dao
interface GameDao {

    @Query("SELECT * FROM game_table")
    fun getGame(): LiveData<Game?>

    @Insert
    suspend fun insertGame(game: Game)

    @Delete
    suspend fun deleteGame(game: Game)

    @Query("DELETE FROM game_table")
    suspend fun deleteAll()

    @Update
    suspend fun updateGame(game: Game)
}