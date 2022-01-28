package com.example.todosample.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class ItemName(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val namesItem: String
) : Parcelable
