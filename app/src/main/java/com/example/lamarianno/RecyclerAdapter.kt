package com.example.lamarianno

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.lamarianno.databinding.ActivityMain2Binding
import com.example.lamarianno.databinding.FragmentGalleryBinding
import com.example.lamarianno.ui.gallery.GalleryFragment

class RecyclerAdapter(private val pizzaList: MutableList<String>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    var context: Context? = null                                                                                                //contextul in care e folosit adaptorul
    private var pizza: MutableList<String> = pizzaList                                                                          //lista de pizza

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))          //inflate item layout
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {                                                          //modifica layout-ul item-ului curent
        holder.itemTitle.text = pizza[position]
    }

    override fun getItemCount() = pizza.size

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {                                                         //actualizam contextul cu cel din clasa recyclerView, nu am testat, dar cred ca daca nu modificam contextul atunci se suprapun item-ele
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var itemTitle: TextView                                                                                                 //aici memoram view-ul corespunzator item-ului curent, ca sa fie returnat in onBindViewHolder o referinta catre view-ul itemului curent

        init{
            itemTitle = itemView.findViewById(R.id.itemTitle)                                                                   //Conectam la textView-ul din interfata cu id-ul itemTitle

            itemView.setOnClickListener {
                                                                                                                                //aici setam cand se apasa pe itemul curent sa se dea share
                val position: Int = bindingAdapterPosition                                                                             //pozitia item-ului curent
                val shareIntent = Intent()                                                                                      //instantiem intent
                shareIntent.action = Intent.ACTION_SEND                                                                         //setam actiunea intentului de tipul send
                shareIntent.type="text/plain"                                                                                   //tipul intentului de este text simplu
                shareIntent.putExtra(Intent.EXTRA_TEXT, "I just ate this pizza: ${pizza[position]}")                       //extra text la share
                context?.startActivity(Intent.createChooser(shareIntent,"Share my pizza"))                                  //lansam intent-ul, nu e nevoie sa asteptam raspuns, spre deosebire de camera
            }

        }
    }

}