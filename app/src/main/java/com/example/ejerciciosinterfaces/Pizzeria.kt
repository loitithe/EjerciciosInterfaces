package com.example.ejerciciosinterfaces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.ejerciciosinterfaces.PizzeriaFragment.Companion.PARAM1
import com.example.ejerciciosinterfaces.PizzeriaFragment.Companion.PARAM2

class Pizzeria : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizzeria)
        // comprobacion que es la primera vez que se crea el fragment
        if (savedInstanceState==null){
            val bundle= bundleOf(PARAM1 to "Rodrigo",
                PARAM2 to "Guido")
            supportFragmentManager.commit {
                // obligatorio!! performance
                setReorderingAllowed(true)
                add<PizzeriaFragment>(R.id.fragmentContainer,args=bundle)
            }
        }
    }
}