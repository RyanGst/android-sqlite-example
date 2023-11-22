package com.ryangst.gas_log.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ryangst.gas_log.constants.DatabaseConstants

@Entity(tableName = DatabaseConstants.SUPPLY_RECORDS.SUPPLY_RECORDS_TABLE_NAME)
class SupplyRecord {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var id: Int = 0;
    @ColumnInfo
    var date: String = ""
    @ColumnInfo
    var amount: Double = 0.0
    @ColumnInfo
    var total: Double = 0.0
    @ColumnInfo
    var city: String = ""
    @ColumnInfo
    var fuel_id: Int = 0
}