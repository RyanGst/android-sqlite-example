package com.ryangst.gas_log.repository

import android.content.Context
import com.ryangst.gas_log.model.Fuel

class FuelRepository  constructor(context: Context){
    private val db = AppDatabase.getDatabase(context).fuelDAO()

    fun getById(id: Int): Fuel? {
        return db.getById(id)
    }


    fun getAll(): List<Fuel> {
        return db.getAll()
    }
}