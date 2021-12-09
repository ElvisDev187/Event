package fr.groupe.event

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.groupe.event.Adapter.CityAdapter
import fr.groupe.event.Adapter.EventAdapter

class fragment_ville : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_ville, container, false)
        val child_item=view.findViewById<RecyclerView>(R.id.second_container)
        child_item.adapter  =EventAdapter()
        return view
    }


}