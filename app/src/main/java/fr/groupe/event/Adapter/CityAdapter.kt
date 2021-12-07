package fr.groupe.event.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.groupe.event.R

class CityAdapter():RecyclerView.Adapter<CityAdapter.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        var nom_ville=view.findViewById<TextView>(R.id.city_name)
        var ville=view.findViewById<RecyclerView>(R.id.second_container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.fragment_ville,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.ville.adapter=EventAdapter()
    }

    override fun getItemCount(): Int =7
}