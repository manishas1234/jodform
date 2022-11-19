package com.example.myapplication.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao
{
    @Query("SELECT * FROM userInfo ORDER BY  id DESC")
    fun getAllUserInfo():LiveData<List<UserEntity>>

    @Insert
   suspend fun insertUser(user:UserEntity?)

    @Delete
    suspend fun deleteUser(user: UserEntity?)

    @Update
   suspend fun updateUser(user: UserEntity?)

}