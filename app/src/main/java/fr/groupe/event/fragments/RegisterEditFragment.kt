package fr.groupe.event.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import fr.groupe.event.R

class RegisterEditFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater?.inflate(R.layout.fragment_register_edit, container, false)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        val btn = view.findViewById<Button>(R.id.next)
        btn.setOnClickListener{
            viewPager?.currentItem = 2
        }
        return view
    }

}