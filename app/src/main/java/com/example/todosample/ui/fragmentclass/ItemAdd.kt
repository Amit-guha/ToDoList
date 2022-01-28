package com.example.todoapp

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContentProviderCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.todosample.R
import com.example.todosample.data.model.ItemName
import com.example.todosample.ui.viewmodel.ItemViewModel

/*

  <ImageButton
              android:id="@+id/btn_circle"
              android:layout_weight=".3"
              android:layout_width="0dp"
              android:layout_height="30dp"
              android:backgroundTint="#FFFFFF"
              android:layout_gravity="center"
              android:src="@drawable/ic_baseline_radio_button_unchecked_24"/>

 */

class ItemAdd : Fragment(R.layout.itemadd) {

    private lateinit var ettask: EditText
    private lateinit var buttonname: Button

    private val viewModel: ItemViewModel by viewModels()

    override fun onViewCreated(v: View, savedInstanceState: Bundle?) {
        super.onViewCreated(v, savedInstanceState)

        ettask = v.findViewById(R.id.et_dayofTAsk)
        buttonname = v.findViewById(R.id.btn_add)

        buttonname.setOnClickListener {
            var writetask = ettask.text.toString()

            createDataase(writetask)
        }

    }


    //take all data from edit text and previous fragment
    private fun createDataase(custo: String) {
        if (TextUtils.isEmpty(custo)) {
            Toast.makeText(requireContext(), "Something Wrong !", Toast.LENGTH_LONG).show()
        } else {
            //  Toast.makeText(requireContext(), tot.toString(), Toast.LENGTH_LONG).show()

            val dataset = ItemName(0, custo)

            viewModel.addnewItem(dataset)
            //println("$custo")
            Toast.makeText(requireContext(), "Successfully done !", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_itemAdd4_to_itemListShow)

        }

    }

}
