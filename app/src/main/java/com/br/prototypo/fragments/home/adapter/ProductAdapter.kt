package com.br.prototypo.fragments.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.prototypo.R
import com.br.prototypo.fragments.home.model.Product
import kotlinx.android.synthetic.main.row_product.view.*
import java.text.DecimalFormat

class ProductAdapter(var itens:List<Product> = arrayListOf()):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtDesc = itemView.txtDesc
        val txtPrice = itemView.txtPrice
        val ratingBar = itemView.ratingBar

        fun setItens(item:Product){
            txtDesc.text = item.descProd
            txtPrice.text = getCurrencyFormat(item.price)
            ratingBar.rating = item.like.toFloat()

        }
    }
    fun getCurrencyFormat(valor: Number): String? {
        val currencyFormat = DecimalFormat.getCurrencyInstance()
        return currencyFormat.format(valor)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val v =LayoutInflater.from(parent.context)
            .inflate(R.layout.row_product,parent,false)
        return ProductViewHolder(v)
    }

    override fun getItemCount(): Int = itens.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.setItens(itens[position])
    }
}