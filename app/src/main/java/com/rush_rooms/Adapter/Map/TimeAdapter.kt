package com.rush_rooms.Adapter.Map

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rush_rooms.databinding.TimeItemBinding

class TimeAdapter(val con: Context) : RecyclerView.Adapter<TimeAdapter.MyViewHolder>() {
    class MyViewHolder (val mView:TimeItemBinding):RecyclerView.ViewHolder(mView.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       return MyViewHolder(TimeItemBinding.inflate(LayoutInflater.from(con),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 6
    }
}