package com.ryangst.gas_log.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contacts.ui.adapter.SupplyRecordAdapter
import com.example.contacts.ui.listener.SupplyRecordListener
import com.ryangst.gas_log.databinding.FragmentFirstBinding
import com.ryangst.gas_log.viewModel.SupplyRecordViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val adapter = SupplyRecordAdapter()
    private lateinit var viewModel: SupplyRecordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(SupplyRecordViewModel::class.java)
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.recyclerSupplyRecords.layoutManager = LinearLayoutManager(context)
        binding.recyclerSupplyRecords.adapter = adapter

        viewModel.load()
        val listener = object : SupplyRecordListener {
            override fun onClick(id: Int) {
                Log.d("FirstFragment", "onClick: $id")
            }

        }
        adapter.attachListener(listener)
        observe()
        return binding.root
    }

    private fun observe() {
        viewModel.supplyRecords.observe(viewLifecycleOwner) {
            adapter.updateGuests(it)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}