package com.example.contacts.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.ui.listener.SupplyRecordListener
import com.example.contacts.ui.viewHolder.SupplyRecordViewHolder
import com.ryangst.gas_log.databinding.RowSupplyRecordBinding
import com.ryangst.gas_log.model.SupplyRecord

class SupplyRecordAdapter : RecyclerView.Adapter<SupplyRecordViewHolder>() {

    private var list = mutableListOf<SupplyRecord>()
    private lateinit var recordListener: SupplyRecordListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupplyRecordViewHolder {
        RowSupplyRecordBinding.inflate(LayoutInflater.from(parent.context), parent, false).apply {
            return SupplyRecordViewHolder(this, recordListener)
        }
    }

    override fun onBindViewHolder(holder: SupplyRecordViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.count();
    }

    fun updateGuests(records: List<SupplyRecord>) {
        list = records.toMutableList()
        notifyDataSetChanged()
    }

    fun attachListener(listener: SupplyRecordListener) {
        recordListener = listener
    }
}