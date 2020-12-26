package com.ysun.gnbmanager.main.views.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ysun.gnbmanager.R
import com.ysun.gnbmanager.base.inflate
import com.ysun.gnbmanager.main.repository.models.Transaction
import com.ysun.gnbmanager.main.views.adapter.viewholder.TransactionViewHolder


class TransactionsAdapter(
    private val items: List<String>,
    private val listener: (String) -> Unit
) : RecyclerView.Adapter<TransactionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TransactionViewHolder(parent.inflate(R.layout.view_holder_transaction))

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    override fun getItemCount() = items.size

}