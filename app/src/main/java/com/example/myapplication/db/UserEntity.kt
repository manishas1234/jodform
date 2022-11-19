package com.example.myapplication.db

import android.provider.ContactsContract
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.myapplication.fence
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "userInfo")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id:Int =0,
    @ColumnInfo(name ="name") val name: String,
    @ColumnInfo(name="email") val email: String,
    @ColumnInfo(name="hobbies") val hobbies: List<fence>

)

