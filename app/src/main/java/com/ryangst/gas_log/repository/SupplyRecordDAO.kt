package com.ryangst.gas_log.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ryangst.gas_log.constants.DatabaseConstants
import com.ryangst.gas_log.model.SupplyRecord

@Dao
interface SupplyRecordDAO {
    @Insert
    fun save(supply: SupplyRecord): Long

    @Query("SELECT * FROM ${DatabaseConstants.SUPPLY_RECORDS.SUPPLY_RECORDS_TABLE_NAME}")
    fun getAll(): List<SupplyRecord>
}