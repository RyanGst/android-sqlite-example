package com.ryangst.gas_log.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ryangst.gas_log.R
import com.ryangst.gas_log.databinding.FragmentSecondBinding
import com.ryangst.gas_log.viewModel.SupplyRecordFormViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private lateinit var viewModel: SupplyRecordFormViewModel
    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(SupplyRecordFormViewModel::class.java)
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        viewModel.load()
        observe()
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupFuelOptions()

        binding.buttonSave.setOnClickListener {
            onClickSave()
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    private fun setupFuelOptions() {
        val fuelNames = viewModel.fuelOptions.value!!.map { it.name }
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            fuelNames
        )
        binding.fuelType.setAdapter(adapter)
    }

    private fun onClickSave() {
        val city = binding.etCity.editText?.text.toString()
        val quantity = binding.etQnt.editText?.text.toString()

        val menu = binding.fuelType.text.toString()

        val fuelId = viewModel.fuelOptions.value!!.find { it.name == menu }!!.id
        val total = viewModel.calculateTotal(quantity, fuelId)

        val today_date: String = java.text.SimpleDateFormat("dd/MM/yyyy").format(java.util.Date())
        viewModel.save(total, today_date, quantity.toDouble(), city, fuelId)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observe() {
        viewModel.fuelOptions.observe(viewLifecycleOwner) {
            setupFuelOptions()
        }
    }
}