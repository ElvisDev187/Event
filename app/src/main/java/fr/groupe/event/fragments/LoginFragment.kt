package fr.groupe.event.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import fr.groupe.event.MainActivity
import fr.groupe.event.R
import org.w3c.dom.Text


class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_login, container, false)
           val email  = view.findViewById<EditText>(R.id.edit_text_mail)
        val pwd = view.findViewById<EditText>(R.id.edit_text_pwd)
        val btnLogin = view.findViewById<Button>(R.id.btn_login)



        btnLogin.setOnClickListener {
            //fireBase Here
        }

         val linkToRegister = view.findViewById<TextView>(R.id.link)
        linkToRegister.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_viewPagerFragment2)
        }


        return view
    }

}