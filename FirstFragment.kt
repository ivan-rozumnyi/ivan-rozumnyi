package com.example.myapplicationivan

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {

    interface OnTextSendListener {
        fun onTextSend(text: String)
    }

    private var listener: OnTextSendListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is OnTextSendListener) {
            listener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(
            R.layout.fragment_first,
            container,
            false
        )
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(view, savedInstanceState)

        val editTextInput =
            view.findViewById<EditText>(R.id.editTextInput)

        val btnSend =
            view.findViewById<Button>(R.id.btnSend)

        btnSend.setOnClickListener {

            val text = editTextInput.text
                .toString()
                .trim()

            listener?.onTextSend(text)
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}