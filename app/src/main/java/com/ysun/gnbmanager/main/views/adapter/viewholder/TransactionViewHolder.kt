package com.ysun.gnbmanager.main.views.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ysun.gnbmanager.base.views.customviews.BaseTextView
import kotlinx.android.synthetic.main.view_holder_transaction.view.*

class TransactionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title: BaseTextView = itemView.viewHolder_transaction_title

    fun bind(transactionId: String, listener: (String) -> Unit) = with(itemView) {
        title.text = transactionId
        setOnClickListener { listener(transactionId) }
    }
}