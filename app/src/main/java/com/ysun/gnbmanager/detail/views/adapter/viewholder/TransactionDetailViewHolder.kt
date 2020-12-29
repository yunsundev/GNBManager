package com.ysun.gnbmanager.detail.views.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ysun.gnbmanager.R
import com.ysun.gnbmanager.base.views.customviews.BaseTextView
import com.ysun.gnbmanager.base.views.customviews.LabeledTextView
import com.ysun.gnbmanager.main.repository.models.Transaction
import kotlinx.android.synthetic.main.view_holder_transaction_detail.view.*

class TransactionDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title: LabeledTextView = itemView.viewHolder_transaction_detail_title

    fun bind(item: Transaction) {
        title.setText(itemView.context.getString(R.string.transaction_detail_viewHolder_amount, item.amount))
    }
}