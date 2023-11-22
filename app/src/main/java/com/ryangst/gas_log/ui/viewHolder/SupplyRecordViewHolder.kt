package com.example.contacts.ui.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.ui.listener.SupplyRecordListener
import com.ryangst.gas_log.R
import com.ryangst.gas_log.databinding.RowSupplyRecordBinding
import com.ryangst.gas_log.model.SupplyRecord

class SupplyRecordViewHolder(binding: RowSupplyRecordBinding, private val listener: SupplyRecordListener) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(record: SupplyRecord) {
        RowSupplyRecordBinding.bind(itemView).apply {
            txtTotal.text = record.total.toString()
            txtDate.text = record.date
            txtCityName.text = record.city
            txtFuel.text = "GAS"
            txtDate.setOnClickListener {
                listener.onClick(record.id)
            }

        }
    }
}