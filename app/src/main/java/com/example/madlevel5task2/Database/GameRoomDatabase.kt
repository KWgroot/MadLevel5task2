package com.example.madlevel5task2.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.madlevel5task2.Converters.Converters
import com.example.madlevel5task2.Dao.GameDao
import com.example.madlevel5task2.Viewmodel.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

@Database(entities = [Game::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class GameRoomDatabase : RoomDatabase() {

    abstract fun gameDao(): GameDao

    //static
    companion object{
        private const val DATABASE_NAME = "GAME_DATABASE"

        @Volatile
        private var gameReleaseRoomDatabaseInstance: GameRoomDatabase? = null

        fun getDatabase(context: Context): GameRoomDatabase?{
            if (gameReleaseRoomDatabaseInstance == null){
                synchronized(GameRoomDatabase::class.java){
                    if (gameReleaseRoomDatabaseInstance == null){
                        gameReleaseRoomDatabaseInstance = Room.databaseBuilder(
                            context.applicationContext,
                            GameRoomDatabase::class.java,
                            DATABASE_NAME
                        ).build()
                    }
                }
            }
            return gameReleaseRoomDatabaseInstance
        }
    }

}