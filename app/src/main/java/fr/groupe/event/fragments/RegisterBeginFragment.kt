package fr.groupe.event.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import fr.groupe.event.R
import fr.groupe.event.RegisterAndLoginActivity

class RegisterBeginFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

       val view = inflater.inflate(R.layout.fragment_register_begin,container, false )
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        val btn = view.findViewById<CardView>(R.id.register_btn)

        btn.setOnClickListener{
            viewPager?.currentItem = 1
        }

        return view


    }

}