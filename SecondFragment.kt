package com.example.myapplicationivan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class SecondFragment : Fragment() {

    companion object {

        private const val ARG_TEXT = "text"

        fun newInstance(text: String): SecondFragment {

            val fragment = SecondFragment()

            val bundle = Bundle()
            bundle.putString(ARG_TEXT, text)

            fragment.arguments = bundle

            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(
            R.layout.fragment_second,
            container,
            false
        )
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(view, savedInstanceState)

        val textView1 =
            view.findViewById<TextView>(R.id.textView1)

        val textView2 =
            view.findViewById<TextView>(R.id.textView2)

        val textView3 =
            view.findViewById<TextView>(R.id.textView3)

        val text = arguments?.getString(ARG_TEXT) ?: ""

        textView1.text = text
        textView2.text = text
        textView3.text = text
    }
}