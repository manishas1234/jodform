package com.example.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.db.RoomAppDb
import com.example.myapplication.db.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class viewModel(app:Application):AndroidViewModel(app)
{
    val readallData:LiveData<List<UserEntity>>
     val repositor:repositor

    init {
      val dao= RoomAppDb.getAppDatabase(getApplication()).userDao()
        repositor= dao?.let { com.example.myapplication.repositor(it) }!!
        readallData =repositor.readAll
    }



     fun insertUserInfo(entity: UserEntity)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
           repositor.addNotes(entity)
        }

    }


}