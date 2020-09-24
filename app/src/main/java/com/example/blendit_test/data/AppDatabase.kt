package com.example.blendit_test.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.blendit_test.data.dao.AccessUsers
import com.example.blendit_test.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun accessUsers(): AccessUsers

}

object DatabaseBuilder {
    private var instance: AppDatabase? = null

    @JvmStatic
    fun getAppDatabase(context: Context) = instance ?: build(context)

    private fun build(context: Context): AppDatabase {
        val database = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java, "database"
        )
        database.allowMainThreadQueries()
        val appDatabase = database.build()
        instance = appDatabase
        return appDatabase
    }

    @JvmStatic
    fun endInstance() {
        instance = null
    }
}