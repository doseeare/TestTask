package com.doseeare.dosomething.ui.home

import android.widget.Toast
import androidx.core.view.isVisible
import com.doseeare.dosomething.base.BaseFragment
import com.doseeare.dosomething.databinding.FragmentHomeBinding
import com.doseeare.dosomething.util.IntentUtil
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment
<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val viewModel: HomeViewModel by viewModel()

    override fun initViews() {
        viewModel.getRandomActivity()

        binding.acceptBtn.setOnClickListener {
            //viewModel.insertActivity()
        }

        binding.refreshBtn.setOnClickListener {
            viewModel.getRandomActivity()
        }

        binding.inviteBtn.setOnClickListener {
            IntentUtil.invite(requireContext(), binding.activityContentTv.text.toString())
        }
    }

    override fun initObservers() {
        viewModel.randomActivityResult.observe(viewLifecycleOwner) {
            binding.activityContentTv.text = it.activity
            val description = "type: ${it.type}\n " +
                    "price: ${it.price} energy\n" +
                    "accessibility: ${it.accessibility}\n" +
                    "participants: ${it.participants}"
            binding.activityDescriptionTv.text = description
            binding.activityLinkTv.isVisible = it.link.isNotEmpty()
            binding.activityLinkTv.text = it.link
            binding.inviteBtn.isVisible = it.participants > 1
        }

        viewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }
}