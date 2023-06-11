package com.example.listasg2.ui.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.listasg2.databinding.TemplateItemRvBinding
import com.example.listasg2.ui.Details
import com.example.listasg2.ui.dataClass.ItemListUser
import com.google.android.material.dialog.MaterialAlertDialogBuilder

//diffutil

class adapterRecycler:RecyclerView.Adapter<adapterRecycler.ContentViews>() {

    lateinit var ct:Context

    class ContentViews(var layout: TemplateItemRvBinding):RecyclerView.ViewHolder(layout.root)

    val callback=object : DiffUtil.ItemCallback<ItemListUser>(){

        override fun areItemsTheSame(oldItem: ItemListUser, newItem: ItemListUser): Boolean {
            return true
        }

        override fun areContentsTheSame(oldItem: ItemListUser, newItem: ItemListUser): Boolean {
           return oldItem.nombres == newItem.nombres
        }

    }

    var dUtil=AsyncListDiffer(this,callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViews {
        ct=parent.context
        var layout:TemplateItemRvBinding

        layout=TemplateItemRvBinding.inflate(LayoutInflater.from(ct),parent,false)
        return ContentViews(layout)

    }

    override fun getItemCount()= dUtil.currentList.size

    override fun onBindViewHolder(holder: ContentViews, position: Int) {

        var itemCurrent=dUtil.currentList[position]

        holder.layout.apply {

            txtNombre.text=itemCurrent.nombres
            txtCargo.text=itemCurrent.cargo

            content.setOnClickListener {

                ct.startActivity(
                    Intent(ct,Details::class.java).apply {
                        putExtra("name",itemCurrent.nombres)
                        putExtra("cargo",itemCurrent.cargo)
                    }
                )
            }

            imgDelete.setOnClickListener {

                MaterialAlertDialogBuilder(ct)
                    .setTitle("Eliminacion de datos")
                    .setMessage("Esta seguro de eliminar al usuario: ${itemCurrent.nombres}")
                    .setPositiveButton("Eliminar"){x,y->

                        //dUtil.currentList.removeAt(position)
                        notifyDataSetChanged()
                        Log.i("result",dUtil.currentList.toString())

                    }
                    .setNegativeButton("Cancelar"){x,y->}
                    .show()

            }

            imgEditar.setOnClickListener {

            }

        }

    }

}