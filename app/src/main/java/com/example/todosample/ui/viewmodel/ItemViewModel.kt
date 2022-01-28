package com.example.todosample.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.todosample.data.database.ItemDatabase
import com.example.todosample.data.model.ItemName
import com.example.todosample.data.repository.ItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemViewModel(application: Application) : AndroidViewModel(application) {
    val  alldata : LiveData<List<ItemName>>
    private val repository: ItemRepository

    init {
        val Dao = ItemDatabase.getdatabase(application).itemDao()
        repository= ItemRepository(Dao)
        alldata=repository.readall
    }

    fun addnewItem(itemName: ItemName){
        viewModelScope.launch(Dispatchers.IO){
            repository.add(itemName)
        }
    }
}