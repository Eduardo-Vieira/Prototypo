package com.br.prototypo.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration

import com.br.prototypo.R
import com.br.prototypo.fragments.home.adapter.ProductAdapter
import com.br.prototypo.fragments.home.model.Category
import com.br.prototypo.fragments.home.model.Product
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    private var category:ArrayList<Category> = arrayListOf()
    private var product:ArrayList<Product> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        montarDataMock()

        categoryTabLayout.removeAllTabs()
        category.forEach {
            categoryTabLayout.addTab(categoryTabLayout.newTab().setText(it.category))
        }

        val adapter = ProductAdapter(product)
        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

        productRecyclerView.addItemDecoration(divider)
        productRecyclerView.adapter = adapter

    }

    fun montarDataMock(){
        category.add(Category("Todos",""))
        category.add(Category("Xiaomin",""))
        category.add(Category("Samsung",""))
        category.add(Category("Motorola",""))

        product.add(Product("Celular Xiaomi Redmi 8A Versão Global 32gb / 2gb Ram/ Tela 6.22 - Preto",978.56,50))
        product.add(Product("Celular Xiaomi Redmi 8A Versão Global 32gb / 2gb Ram/ Tela 6.22 - Preto",978.56,50))
        product.add(Product("Celular Xiaomi Redmi 8A Versão Global 32gb / 2gb Ram/ Tela 6.22 - Preto",978.56,50))
    }

}
