package com.example.inventory.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao public abstract interface ItemDao {
    //insertar
    @Query("SELECT * from item ORDER BY name ASC")
    fun getItems(): Flow<List<Item>>
    //selecionar
    @Query("SELECT * from item WHERE id = :id")
    fun getItem(id: Int): Flow<Item>
    //insertar
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)
    //actualizar
    @Update
    suspend fun update(item: Item)
    //eliminar
    @Delete
    suspend fun delete(item: Item)

}