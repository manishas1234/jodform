package com.example.myapplication

import androidx.lifecycle.LiveData
import com.example.myapplication.db.UserDao
import com.example.myapplication.db.UserEntity

class repositor(private val dao: UserDao) {

    val readAll: LiveData<List<UserEntity>> = dao.getAllUserInfo()
    suspend fun addNotes(entity:UserEntity)
    {
        dao.insertUser(entity)
    }


}