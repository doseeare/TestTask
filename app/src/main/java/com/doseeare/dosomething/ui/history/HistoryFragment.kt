package com.doseeare.dosomething.ui.history

import com.doseeare.dosomething.base.BaseFragment
import com.doseeare.dosomething.databinding.FragmentHistoryBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryFragment : BaseFragment<FragmentHistoryBinding>(FragmentHistoryBinding::inflate) {
    private val viewModel: HistoryViewModel by viewModel()

    override fun initViews() {

    }

    override fun initObservers() {

    }

}