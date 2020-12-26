package com.ysun.gnbmanager.main.views.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ysun.gnbmanager.main.repository.models.Transaction
import kotlinx.android.synthetic.main.view_holder_transaction.view.*

class TransactionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title: TextView = itemView.viewHolder_transaction_title

    fun bind(item: String, listener: (String) -> Unit) = with(itemView) {
        title.text = item
        setOnClickListener { listener(item) }
    }
}