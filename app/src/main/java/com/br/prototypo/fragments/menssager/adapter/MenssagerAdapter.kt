package com.br.prototypo.fragments.menssager.adapter

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.br.prototypo.R
import com.br.prototypo.fragments.menssager.model.Menssager
import kotlinx.android.synthetic.main.row_menssager.view.*

class MenssagerAdapter(var itens:List<Menssager> = arrayListOf()): RecyclerView.Adapter<MenssagerAdapter.MenssagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenssagerViewHolder {
       val v = LayoutInflater.from(parent.context)
           .inflate(R.layout.row_menssager,parent,false)
        return MenssagerViewHolder(v)
    }

    override fun getItemCount(): Int = itens.size

    override fun onBindViewHolder(holder: MenssagerViewHolder, position: Int) {
        holder.setItens(itens[position])
    }

    fun update(itens:List<Menssager>){
        this.itens = itens
        notifyDataSetChanged()
    }
    inner class MenssagerViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val txtMsg = itemView.txtMsg
        val cardMenssager = itemView.cardMenssager
        val txtName = itemView.txtName
        val txtHr = itemView.txtHr

        fun setItens(item:Menssager){
            txtMsg.text = item.msg
            txtName.text= item.name
            txtHr.text = item.hr

            if(item.myMsg) {
                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    weight = 1.0f
                    gravity = Gravity.END
                }
                cardMenssager.layoutParams = params
            }
        }
    }

}