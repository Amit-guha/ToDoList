package com.example.todosample.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todosample.data.model.ItemName

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addItem(itemName: ItemName)


    @Query("SELECT * from ItemName ORDER BY Id")
    fun readalldata(): LiveData<List<ItemName>>
}