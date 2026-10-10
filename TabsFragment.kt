package com.example.myapplicationivan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class TabsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(
            R.layout.fragment_tabs,
            container,
            false
        )
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(view, savedInstanceState)

        val tab1 = view.findViewById<Button>(R.id.tab1)
        val tab2 = view.findViewById<Button>(R.id.tab2)
        val tab3 = view.findViewById<Button>(R.id.tab3)

        if (savedInstanceState == null) {
            showTab(0)
        }

        tab1.setOnClickListener {
            showTab(0)
        }

        tab2.setOnClickListener {
            showTab(1)
        }

        tab3.setOnClickListener {
            showTab(2)
        }
    }

    private fun showTab(position: Int) {

        val fragment = TabFragment.newInstance(position)

        childFragmentManager
            .beginTransaction()
            .replace(
                R.id.tabFragmentContainer,
                fragment
            )
            .commit()
    }
}