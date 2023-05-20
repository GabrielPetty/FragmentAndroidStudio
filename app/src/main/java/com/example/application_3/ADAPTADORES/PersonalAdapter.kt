package com.example.application_3.ADAPTADORES

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.application_3.R
import com.example.application_3.TABLAS.Personal
import com.example.application_3.databinding.ItemListBinding


class PersonalAdapter(private val dataSet: List<Personal>) :
    RecyclerView.Adapter<PersonalAdapter.ViewHolder>() {

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_list, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        var item=dataSet?.get(position)
        viewHolder.enlazarItem(item!!)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet!!.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = ItemListBinding.bind(view)
        var context=view.context

        fun enlazarItem(personal: Personal) {
            //todo enlazar elementos
            binding.idNombre.text=personal.nombre
            binding.idEmail.text=personal.email
            binding.idDni.text= personal.iddni.toString()
            binding.idLenguajes.text=personal.lenguajes
        }
    }

}
