package com.ryangst.gas_log.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ryangst.gas_log.model.SupplyRecord
import com.ryangst.gas_log.repository.SupplyRecordRepository

class SupplyRecordViewModel(application: Application): AndroidViewModel(application) {
    private val repository = SupplyRecordRepository(application.applicationContext)

    private val _supplyRecords = MutableLiveData<List<SupplyRecord>>().apply {
        value = listOf()
    }

    val supplyRecords: LiveData<List<SupplyRecord>> = _supplyRecords

    fun load() {
        _supplyRecords.value = repository.getAll()
    }
}
