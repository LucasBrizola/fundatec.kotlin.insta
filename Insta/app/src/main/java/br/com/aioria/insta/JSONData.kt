package com.example.filmes
import com.google.gson.annotations.SerializedName


data class Post(
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("desc")
    val desc: String,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String,
    @SerializedName("likes")
    val likes: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("username")
    val username: String
)