package com.example.myapplicationivan

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class TabFragment : Fragment() {

    private lateinit var editText: EditText
    private lateinit var viewModel: TabsViewModel

    companion object {

        private const val ARG_POSITION = "position"

        fun newInstance(position: Int): TabFragment {

            val fragment = TabFragment()

            val bundle = Bundle()
            bundle.putInt(ARG_POSITION, position)

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
            R.layout.fragment_tab,
            container,
            false
        )
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(view, savedInstanceState)

        editText = view.findViewById(R.id.editTextTab)

        val position =
            arguments?.getInt(ARG_POSITION) ?: 0

        val title =
            view.findViewById<TextView>(R.id.tvTabTitle)

        title.text = "Фрагмент ${position + 1}"

        viewModel =
            ViewModelProvider(requireActivity())
                .get(TabsViewModel::class.java)

        viewModel.text.observe(
            viewLifecycleOwner
        ) { text ->

            if (editText.text.toString() != text) {

                editText.setText(text)

                editText.setSelection(
                    editText.text.length
                )
            }
        }

        editText.addTextChangedListener(
            object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(
                    s: CharSequence?,
                    start: Int,
                    before: Int,
                    count: Int
                ) {

                    viewModel.setText(s.toString())
                }

                override fun afterTextChanged(
                    s: Editable?
                ) {
                }
            }
        )
    }
}