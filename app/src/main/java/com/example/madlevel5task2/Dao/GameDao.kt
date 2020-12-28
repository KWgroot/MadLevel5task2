package com.example.madlevel5task2.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.madlevel5task2.Viewmodel.Game

@Dao
interface GameDao {

    @Insert
    suspend fun insertGame(game: Game)

    @Query("SELECT * FROM game_table")
    fun getAllGames(): LiveData<List<Game>>

    @Delete
    suspend fun deleteGame(game: Game)

    @Query("DELETE FROM game_table")
    suspend fun deleteAll()
}