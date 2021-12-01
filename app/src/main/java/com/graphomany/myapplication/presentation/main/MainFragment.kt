package com.graphomany.myapplication.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.graphomany.myapplication.databinding.MainFragmentBinding

class MainFragment : Fragment(), MainFragmentViewStatesRenderContract {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.viewState.observe(viewLifecycleOwner, Observer {
            it?.let { render(it) }
        })
        viewModel.initialize()
        binding.fab.setOnClickListener { viewModel.onFabPressed() }
        viewModel.getCounterLiveData().observe(viewLifecycleOwner, Observer {
            it?.let { binding.counterCount = it.count }
        })
        viewModel.getEvenCounterLiveData().observe(viewLifecycleOwner, Observer {
            it?.let { binding.evenCounterCount = it.count }
        })
        viewModel.getIsEvenLiveData().observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.isEven = it
                viewModel.setStates(it)

            }
        })
        return binding.root
    }


    override fun showEvenState() {
        binding.messageEven.visibility = View.VISIBLE
    }

    override fun showOddState() {
        binding.messageEven.visibility = View.GONE
    }

}