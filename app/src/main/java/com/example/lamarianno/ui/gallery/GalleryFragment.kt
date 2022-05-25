package com.example.lamarianno.ui.gallery

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.lamarianno.R
import com.example.lamarianno.RecyclerAdapter
import com.example.lamarianno.databinding.FragmentGalleryBinding
import java.util.*

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null                //data binding - explicat mai amanuntit in celelalte fragmente
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView                     //referinta la recyclerView
    private lateinit var recyclerAdapter: RecyclerAdapter               //referinta la adaptorul dintre

    private var pizzaList = mutableListOf<String>()                     //referinta la pizza din memorie
    private var displayList = mutableListOf<String>()                   //referinta la pizza care este trebuie afisata (se modifica in urma cautarii de exmplu)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)                                         //Report that this fragment would like to participate in populating the options menu by receiving a call to #onCreateOptionsMenu and related methods.

        if (pizzaList.isEmpty()) {
            pizzaList.add("Margherita")
            pizzaList.add("Marinara")
            pizzaList.add("Quattro Stagioni")
            pizzaList.add("Carbonara")
            pizzaList.add("Frutti di Mare")
            pizzaList.add("Quattro Formaggi")
            pizzaList.add("Crudo")
            pizzaList.add("Napoletana")
            pizzaList.add("Pugliese")
            pizzaList.add("Montanara")
            pizzaList.add("Emiliana")
            pizzaList.add("Romana")
            pizzaList.add("Fattoria")
            pizzaList.add("Schiacciata")
            pizzaList.add("Prosciutto")
            pizzaList.add("Cardinale")
            pizzaList.add("Americana")
            pizzaList.add("Prosciutto e Funghi")
            pizzaList.add("Braccio di Ferro")
            pizzaList.add("Sarda")
            pizzaList.add("Tonno")
            pizzaList.add("Valtellina")
            pizzaList.add("Gorgonzola")
            pizzaList.add("Calzone")
            pizzaList.add("Pizza al Pesto")
            pizzaList.add("Mediterranea")
            pizzaList.add("Ortolana")
            pizzaList.add("Diavola")
            pizzaList.add("Rustica")
            pizzaList.add("Contadina")
            pizzaList.add("Parmigiana")
            pizzaList.add("Capricciosa")
            pizzaList.add("Ricotta e Spinaci")
            pizzaList.add("Mare e Monti")
            pizzaList.add("Padana")
            pizzaList.add("Tedesca")
            pizzaList.add("Tirolese")
            pizzaList.add("Boscaiola")
            pizzaList.add("Campagnola")
            pizzaList.add("Vegetariana")
            pizzaList.add("Bufalina")
            pizzaList.add("Fontana")
            pizzaList.add("Francescana")
            pizzaList.add("Pizza tartufata")
            pizzaList.add("Tricolore")
            pizzaList.add("Valdostana")
            pizzaList.add("Caprese")
            pizzaList.add("Fiori di zucca")
            pizzaList.add("Bismarck")
            pizzaList.add("Funghi")
            pizzaList.add("Mimosa")
            displayList.addAll(pizzaList)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //var pizzaView = inflater.inflate(R.layout.fragment_gallery, container, false)
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)               //inflam view-ul principal al fragmentului

        recyclerView = binding.recyclerView                                                             //referinta la widget-ul recyclerView din layout-ul fragmentului
        recyclerAdapter = RecyclerAdapter(displayList)                                                  //referinta la un obiect de tip recyclerAdapter facut pentru lista de pizza care trebuie afisata

        recyclerView.adapter = recyclerAdapter                                                          //modificam cu data binding o proprietate a recyclerView din layout-ul fragmentului

        val root: View = binding.root
        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main2,menu)                                                             //inflam meniul (butonul) pentru cautare in cadrul recyclerView-ului

        var item: MenuItem = menu.findItem(R.id.action_search)                                          //referinta catre meniul (butonul) de mai sus

        var searchView = item.actionView as SearchView                                                  //searchView este in widget care ofera UI pentru search si trimite requestul de search la provider. Arata o lista de iteme rezultat si itemele pot fi accesate

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{                      //onQueryTextListener este un obiect folosit de widget
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(searchText: String?): Boolean {                              //cand este scris ceva de catre user

                if(searchText!!.isNotEmpty())                                                           //cat timp este ceva scris in search bar
                {
                    displayList.clear()                                                                 //stergem ce era in lista de pizza de afisat
                    var search = searchText.toLowerCase(Locale.getDefault())                            //textul introdus de user in search bar
                    for(p in pizzaList)                                                                 //cautam prin array pizza care sa fie rezultat al cautarii
                    {
                        if(p.toString().toLowerCase(Locale.getDefault()).contains(search)){             //daca am gasit o pizza care satisface conditia o adaugam la lista pentru display
                            displayList.add(p)
                        }
                        recyclerView.adapter!!.notifyDataSetChanged()                                   //facem recyclerView-ul sa re-randeze

                    }
                }else{                                                                                  //daca userul nu a introdus nimic in caseta de search atunci aratam toata pizzele
                    displayList.clear()
                    displayList.addAll(pizzaList)
                    recyclerView.adapter!!.notifyDataSetChanged()                                       //facem recyclerView-ul sa re-randeze
                }
                return true
            }
        }
        )
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}