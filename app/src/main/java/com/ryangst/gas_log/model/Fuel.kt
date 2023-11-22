package com.ryangst.gas_log.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ryangst.gas_log.constants.DatabaseConstants

@Entity(tableName = DatabaseConstants.FUEL.FUEL_TABLE_NAME)
class Fuel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var id: Int = 0;
    @ColumnInfo
    var name: String = ""
    @ColumnInfo
    var price: Double = 0.0
}