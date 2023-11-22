package com.ryangst.gas_log.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ryangst.gas_log.model.Fuel
import com.ryangst.gas_log.model.SupplyRecord
import com.ryangst.gas_log.repository.FuelRepository
import com.ryangst.gas_log.repository.SupplyRecordRepository

class SupplyRecordFormViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = SupplyRecordRepository(application.applicationContext)
    private val fuelRepository = FuelRepository(application.applicationContext)
    private var _saveRecord = MutableLiveData<Boolean>()
    private val _fuelOptions = MutableLiveData<List<Fuel>>().apply {
        value = listOf()
    }

    val fuelOptions: LiveData<List<Fuel>> = _fuelOptions

    fun save(total: Double, date: String, amount: Double, city: String, id: Int) {
        val record = SupplyRecord().apply {
            this.total = total
            this.date = date
            this.amount = amount
            this.city = city
            this.fuel_id = id
        }
        _saveRecord.value = repository.save(record)
    }

    fun load() {
        _fuelOptions.value = fuelRepository.getAll()
    }

    fun calculateTotal(quantity: String, fuelId: Int): Double {
        val fuel = fuelRepository.getById(fuelId)
        return quantity.toDouble() * fuel!!.price
    }
}
