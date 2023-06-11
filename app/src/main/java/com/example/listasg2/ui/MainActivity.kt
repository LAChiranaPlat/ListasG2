package com.example.listasg2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listasg2.databinding.ActivityMainBinding
import com.example.listasg2.ui.adapter.adapterRecycler
import com.example.listasg2.ui.dataClass.ItemListUser

class MainActivity : AppCompatActivity() {

    lateinit var layout: ActivityMainBinding
    var lista:ArrayList<ItemListUser> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout= ActivityMainBinding.inflate(layoutInflater)

        setContentView(layout.root)

        lista.add(
            ItemListUser("Alejandro","Contador")
        )

        lista.add(ItemListUser("Miguel","Soporte"))
        lista.add(ItemListUser("Julio","Ventas"))
        lista.add(ItemListUser("Nestor","Gerente"))
        lista.add(ItemListUser("Michel","Administrador"))
        lista.add(
            ItemListUser("Alejandro","Contador")
        )

        lista.add(ItemListUser("Miguel","Soporte"))
        lista.add(ItemListUser("Julio","Ventas"))
        lista.add(ItemListUser("Nestor","Gerente"))
        lista.add(ItemListUser("Michel","Administrador"))
        lista.add(
            ItemListUser("Alejandro","Contador")
        )

        lista.add(ItemListUser("Miguel","Soporte"))
        lista.add(ItemListUser("Julio","Ventas"))
        lista.add(ItemListUser("Nestor","Gerente"))
        lista.add(ItemListUser("Michel","Administrador"))
        lista.add(
            ItemListUser("Alejandro","Contador")
        )

        lista.add(ItemListUser("Miguel","Soporte"))
        lista.add(ItemListUser("Julio","Ventas"))
        lista.add(ItemListUser("Nestor","Gerente"))
        lista.add(ItemListUser("Michel","Administrador"))

        val myAdapter=adapterRecycler()
        myAdapter.dUtil.submitList(lista)

        layout.apply {

            rvLista.layoutManager=LinearLayoutManager(this@MainActivity)
            //rvLista.layoutManager=GridLayoutManager(this@MainActivity,3)
            rvLista.adapter=myAdapter

            svFind.setOnQueryTextListener(object : SearchView.OnQueryTextListener{

                override fun onQueryTextSubmit(query: String?): Boolean {
                    TODO("Not yet implemented")
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    var resFiltro=lista.filter { item->
                        item.nombres.lowercase().contains(newText!!.lowercase())
                    }

                    myAdapter.dUtil.submitList(resFiltro)
                    myAdapter.notifyDataSetChanged()
                    return true

                }

            })
        }

    }
}