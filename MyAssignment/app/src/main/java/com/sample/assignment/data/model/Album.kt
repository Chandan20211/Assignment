package com.sample.assignment.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Album")
data class Album(

    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("userId")
    val userId: String?,
    @SerializedName("title")
    val title: String?


)