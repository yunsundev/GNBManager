package com.ysun.gnbmanager.base.views.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.ysun.gnbmanager.R


class LabeledTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {


    /*
//private val labelTV: BaseTextView
//private val bodyTV: BaseTextView

init {
    val view = LayoutInflater.from(context)
        .inflate(R.layout.labeled_text_view, this, true)
    orientation = VERTICAL

    labelTV = view.findViewById(R.id.labeled_text_view_label)
    bodyTV = view.findViewById(R.id.labeled_text_view_body)

    attrs?.let {
        val typedArray = context.obtainStyledAttributes(
            it,
            R.styleable.LabeledTextView, 0, 0
        )
        val label = resources.getText(
            typedArray
                .getResourceId(
                    R.styleable
                        .LabeledTextView_label,
                    R.string.empty_string
                )
        )
        val text = resources.getText(
            typedArray
                .getResourceId(
                    R.styleable
                        .LabeledTextView_text,
                    R.string.empty_string
                )
        )

        labelTV.setTextColor(
            ContextCompat.getColor(
                context,
                typedArray.getResourceId(
                    R.styleable.LabeledTextView_labelTextColor,
                    R.color.bitcoin_blue
                )
            )
        )

        bodyTV.setTextColor(
            ContextCompat.getColor(
                context,
                typedArray.getResourceId(
                    R.styleable.LabeledTextView_textColor,
                    R.color.bitcoin_blue
                )
            )
        )

        labelTV.text = label
        bodyTV.text = text

        typedArray.recycle()
    }

}

fun setLabel(charSequence: CharSequence) {
    labelTV.text = charSequence
}

fun setText(charSequence: CharSequence) {
    bodyTV.text = charSequence
}

     */

}