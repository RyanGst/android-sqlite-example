package com.ryangst.gas_log.repository

import android.content.Context
import com.ryangst.gas_log.model.SupplyRecord

class SupplyRecordRepository constructor(context: Context) {
    private val db = AppDatabase.getDatabase(context).supplyRecordDAO()

    fun save(supplyRecord: SupplyRecord): Boolean {
        return db.save(supplyRecord) > 0
    }

    fun getAll(): List<SupplyRecord> {
        return db.getAll()
    }
}