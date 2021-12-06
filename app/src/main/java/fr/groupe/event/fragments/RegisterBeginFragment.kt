package fr.groupe.event.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import fr.groupe.event.R
import fr.groupe.event.RegisterAndLoginActivity

class RegisterBeginFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

       val view = inflater.inflate(R.layout.fragment_register_begin,container, false )
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        val btn = view.findViewById<CardView>(R.id.register_btn)
        val linkToLogin = view.findViewById<TextView>(R.id.link)

        linkToLogin.setOnClickListener{
            findNavController().navigate(R.id.action_viewPagerFragment2_to_loginFragment)
        }

        btn.setOnClickListener{
            viewPager?.currentItem = 1
        }

        return view


    }

}