package com.example.android.ktorsample

import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.android.ktorsample.databinding.FragmentTopBinding

class TopFragment : Fragment() {

    companion object {
        fun newInstance() = TopFragment()
        private const val TAG = "TopFragment"
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

        display()
    }

    /**
     * https://source.android.com/docs/core/display/hdr?hl=ja#display
     *
     * 対応してれば、こんな感じで出力される。
     * pixelだと8からしか対応してない
     * HdrCapabilities{mSupportedHdrTypes=[2, 3, 4], mMaxLuminance=1000.0, mMaxAverageLuminance=120.0, mMinLuminance=5.0E-4}
     */
    private fun display() {
        if (Build.VERSION.SDK_INT > 30) {
            Log.d(TAG, context?.display?.hdrCapabilities.toString())
            Log.d(TAG, context?.display?.isHdr.toString())
            return
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}