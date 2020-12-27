package com.ysun.gnbmanager.base.views.customviews

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import com.google.android.material.textview.MaterialTextView
import com.ysun.gnbmanager.R

class BaseTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MaterialTextView(context, attrs, defStyleAttr) {

    init {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(
                it,
                R.styleable.BaseTextView, 0, 0
            )

            val bold = typedArray
                .getBoolean(
                    R.styleable
                        .BaseTextView_bold,
                    false
                )

            val typeface = Typeface.createFromAsset(
                context.assets,
                if (bold) BOLD_TYPEFACE_ROUTE else REGULAR_TYPEFACE_ROUTE
            )
            this.typeface = typeface

            typedArray.recycle()
        }
    }

    companion object {
        const val REGULAR_TYPEFACE_ROUTE = "fonts/OpenSans-Regular.ttf"
        const val BOLD_TYPEFACE_ROUTE = "fonts/OpenSans-Semibold.ttf"
    }
}