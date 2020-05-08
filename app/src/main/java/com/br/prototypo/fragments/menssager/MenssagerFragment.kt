package com.br.prototypo.fragments.menssager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import com.br.prototypo.R
import com.br.prototypo.fragments.menssager.adapter.MenssagerAdapter
import com.br.prototypo.fragments.menssager.model.Menssager
import kotlinx.android.synthetic.main.fragment_menssager.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class MenssagerFragment : Fragment() {

    private var adapter = MenssagerAdapter()
    private var data = arrayListOf<Menssager>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menssager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        data.add(Menssager(getUUID(),"Eduardo Vieira","Oi", "16:30" ,true))
        data.add(Menssager(getUUID(),"Luiz Schmitt","Oi","16:38",false))
        data.add(Menssager(getUUID(),"Eduardo Vieira","Manei uma mensagem", "16:42",true))

        adapter.update(data)
        listMenssagerRecyclerView.adapter = adapter

        sendButton.setOnClickListener {
            sendMessage()
        }
        editTextSend.setOnEditorActionListener { v, actionId, event ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    sendMessage()
                    false
                }
                else -> false
            }
        }
    }

    fun sendMessage(){
        if(editTextSend.text.isNotEmpty()) {
            val msg = editTextSend.text.toString()
            val now = Calendar.getInstance().time
            val currentTime: String =
                SimpleDateFormat("HH:mm", Locale.getDefault()).format(now)

            data.add(Menssager(getUUID(), "Eduardo Vieira", msg, currentTime, true))
            adapter.update(data)
            editTextSend.setText("")
        }
    }

    fun getUUID():String{
        return UUID.randomUUID().toString()
    }
}
