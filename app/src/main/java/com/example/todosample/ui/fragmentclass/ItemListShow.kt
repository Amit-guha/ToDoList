package com.example.todoapp

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todosample.R
import com.example.todosample.ui.adapter.ItemAdapter
import com.example.todosample.ui.viewmodel.ItemViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ItemListShow : Fragment(R.layout.itemlistshow) {

    private val viewModel: ItemViewModel by viewModels()


    private lateinit var recyclerView: RecyclerView
    private lateinit var floatingActionButton: FloatingActionButton

    override fun onViewCreated(v: View, savedInstanceState: Bundle?) {
        super.onViewCreated(v, savedInstanceState)


        recyclerView = v.findViewById(R.id.recycler_item)
        floatingActionButton = v.findViewById(R.id.floatingActionButton)

        floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_itemListShow_to_itemAdd4)
        }

        val adapter = ItemAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)

        viewModel.alldata.observe(viewLifecycleOwner, Observer { salesitemlist ->
            adapter.setData(salesitemlist)
        })

    }
}