package com.example.android.ktorsample

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.android.ktorsample.databinding.FragmentTopBinding

class TopFragment : Fragment() {

    companion object {
        fun newInstance() = TopFragment()
    }

    private lateinit var viewModel: TopViewModel
    private var _binding: FragmentTopBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTopBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.button1.setOnClickListener {
            val action = TopFragmentDirections.actionTopFragmentToGameFragment()
            view.findNavController().navigate(action)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[TopViewModel::class.java]
        // TODO: Use the ViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}