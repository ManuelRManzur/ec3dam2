package com.rmanzur.ec3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductAdapter (
    private val productos: List<ProductModel>
    ): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){
        class ProductViewHolder(view: View): RecyclerView.ViewHolder(view){
            val productoName = view.findViewById<TextView>(R.id.product_name)
            val productoPrice = view.findViewById<TextView>(R.id.product_price)
            val productoImage = view.findViewById<ImageView>(R.id.product_image)
            val productoCategory= view.findViewById<TextView>(R.id.product_category)
            val productoDescription = view.findViewById<TextView>(R.id.product_description)
            fun bindProducto(producto:ProductModel){
                productoCategory.text=producto.category
                productoName.text=producto.name
                productoPrice.text=producto.price
                productoDescription.text=producto.description
                Glide.with(productoImage).load(producto.image).into(productoImage)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        )
    }

    override fun getItemCount(): Int = productos.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindProducto(productos.get(position))
    }
    }