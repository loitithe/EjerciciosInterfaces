package com.example.ejerciciosinterfaces

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



class PizzeriaFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(PARAM1)
            param2 = it.getString(PARAM2)
            Log.i("rodri",param1.orEmpty())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pizzeria, container, false)
    }

    companion object {
         const val PARAM1 = "param1"
         const val PARAM2 = "param2"
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PizzeriaFragment().apply {
                arguments = Bundle().apply {
                    putString(this@Companion.PARAM1, param1)
                    putString(PARAM2, param2)
                }
            }
    }
}