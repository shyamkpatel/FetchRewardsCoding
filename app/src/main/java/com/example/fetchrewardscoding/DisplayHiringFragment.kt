package com.example.fetchrewardscoding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DisplayHiringFragment : Fragment() {

    private val viewModel: DisplayHiringViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View =  inflater.inflate(R.layout.fragment_display_hiring, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.hiring_rv)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = ViewListAdapter()
        recyclerView.adapter = adapter
        viewModel.hiringLiveData.observe(viewLifecycleOwner, {
            it?.let {
                adapter.dataSet = it
            }
        })

        return view
    }

    companion object {
        fun getInstance(): DisplayHiringFragment = DisplayHiringFragment()
    }
}