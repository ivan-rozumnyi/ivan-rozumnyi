package com.example.myapplicationivan

import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity(),
    FirstFragment.OnTextSendListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val btnFirst = findViewById<Button>(R.id.btnFirst)
        val btnSecond = findViewById<Button>(R.id.btnSecond)
        val btnTabs = findViewById<Button>(R.id.btnTabs)

        if (savedInstanceState == null) {
            showFirstFragment()
        }

        btnFirst.setOnClickListener {
            showFirstFragment()
        }

        btnSecond.setOnClickListener {
            showSecondFragment("")
        }

        btnTabs.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.fragmentContainer,
                    TabsFragment()
                )
                .addToBackStack(null)
                .commit()
        }
    }

    private fun showFirstFragment() {

        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.fragmentContainer,
                FirstFragment()
            )
            .commit()
    }

    private fun showSecondFragment(text: String) {

        val fragment = SecondFragment.newInstance(text)

        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.fragmentContainer,
                fragment
            )
            .commit()
    }

    override fun onTextSend(text: String) {
        showSecondFragment(text)
    }
}