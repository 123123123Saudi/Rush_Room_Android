package com.rush_rooms.Fragment.Booking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.rush_rooms.Adapter.Booking.CommonAdapter
import com.rush_rooms.R
import com.rush_rooms.databinding.FragmentCompletedBinding

class CompletedFragment : Fragment(),CommonAdapter.Click {
    lateinit var binding :FragmentCompletedBinding
    private var adpter: CommonAdapter? = null
    private var changeText = "Completed"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentCompletedBinding.inflate(layoutInflater)
        initView()
        lstnr()
        return binding.root
    }

    private fun initView() {
        binding.rvCompleted.layoutManager = LinearLayoutManager(requireContext())
        adpter = CommonAdapter(requireContext(),changeText,this)
        binding.rvCompleted.adapter = adpter
        adpter!!.notifyDataSetChanged()
    }

    private fun lstnr() {

    }

    override fun onCheckIn(pos: Int) {
        TODO("Not yet implemented")
    }

    override fun onCheckOut(pos: Int) {
        TODO("Not yet implemented")
    }

}