package com.example.todosample.data.repository

import androidx.lifecycle.LiveData
import com.example.todosample.data.dao.ItemDao
import com.example.todosample.data.model.ItemName

class ItemRepository(private val itemDao: ItemDao)  {

    val readall: LiveData<List<ItemName>> = itemDao.readalldata()

    suspend fun add(itemName: ItemName){
        itemDao.addItem(itemName)
    }
}