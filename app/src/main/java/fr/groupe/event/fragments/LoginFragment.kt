package fr.groupe.event.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import fr.groupe.event.R


class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_login, container, false)
         val linkToRegister = view.findViewById<TextView>(R.id.link)
        linkToRegister.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_viewPagerFragment2)
        }
        return view
    }

}