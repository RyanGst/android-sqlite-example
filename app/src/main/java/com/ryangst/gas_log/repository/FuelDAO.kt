package com.ryangst.gas_log.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ryangst.gas_log.constants.DatabaseConstants
import com.ryangst.gas_log.model.Fuel

@Dao
interface FuelDAO {
    @Insert
    fun save(fuel: Fuel): Long

    @Query("SELECT * FROM ${DatabaseConstants.FUEL.FUEL_TABLE_NAME}")
    fun getAll(): List<Fuel>

    @Query("SELECT * FROM ${DatabaseConstants.FUEL.FUEL_TABLE_NAME} WHERE id = :id")
    fun getById(id: Int): Fuel

    @Delete
    fun delete(fuel: Fuel): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(fuels: List<Fuel>)
}