package com.ysun.gnbmanager.detail.views.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ysun.gnbmanager.R
import com.ysun.gnbmanager.base.inflate
import com.ysun.gnbmanager.detail.views.adapter.viewholder.TransactionDetailViewHolder
import com.ysun.gnbmanager.main.repository.models.Transaction

class TransactionsDetailsAdapter(var list: List<Transaction>) :
    RecyclerView.Adapter<TransactionDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionDetailViewHolder {
        return TransactionDetailViewHolder(parent.inflate(R.layout.view_holder_transaction_detail))
    }

    override fun onBindViewHolder(holder: TransactionDetailViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}