package com.example.myapplication.db

import android.content.Context
import androidx.room.*
import com.example.myapplication.fence
import com.google.gson.Gson


@Database(entities = [UserEntity::class], version = 1  , exportSchema = true)
@TypeConverters(HobbiesTypeConvertor::class)
abstract class RoomAppDb: RoomDatabase() {
    abstract fun userDao(): UserDao?

    companion object {

        @Volatile
        private var INSTANCE: RoomAppDb? = null

        fun getAppDatabase(context: Context): RoomAppDb {
            val tempInstance= INSTANCE
            if (tempInstance != null) {

                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, RoomAppDb::class.java,"AppDB"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}

class HobbiesTypeConvertor
{
    @TypeConverter
    fun listToJsonString(value: List<fence>?): String?= Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String?) = Gson().fromJson(value, Array<fence>::class.java).toList()

}