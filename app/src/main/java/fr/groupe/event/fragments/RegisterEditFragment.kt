package fr.groupe.event.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import fr.groupe.event.R

class RegisterEditFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register_edit, container, false)

        val Username = view.findViewById<EditText>(R.id.edit_text_username)
        val UserEmail = view.findViewById<EditText>(R.id.edit_text_mail)
        val pwd = view.findViewById<EditText>(R.id.edit_text_pwd)
        val Confpwd = view.findViewById<EditText>(R.id.edit_text_conf_pwd)

        val btn = view.findViewById<Button>(R.id.next)
        btn.setOnClickListener{


            //fireBase Here



            findNavController().navigate(R.id.action_viewPagerFragment2_to_loginFragment)
        }
        return view
    }

}