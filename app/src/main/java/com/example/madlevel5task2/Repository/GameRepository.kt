package com.example.madlevel5task2.Repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.madlevel5task2.Dao.GameDao
import com.example.madlevel5task2.Database.GameRoomDatabase
import com.example.madlevel5task2.Viewmodel.Game

class GameRepository(context: Context) {

    private val gameDao: GameDao

    init {
        val database = GameRoomDatabase.getDatabase(context)
        gameDao = database!!.gameDao()
    }

    fun getGames(): LiveData<Game?> {
        return gameDao.getGame()
    }

    suspend fun updateGame(game: Game) {
        gameDao.updateGame(game)
    }

}