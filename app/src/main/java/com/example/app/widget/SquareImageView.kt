package com.example.app.widget

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import kotlin.math.min

/**
 * 类描述：
 * @author sungen
 * @date 2020/7/9 10:47 AM
 **/

class SquareImageView(context: Context?, attrs: AttributeSet?) : AppCompatImageView(context, attrs) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val min = min(measuredHeight, measuredWidth)
        setMeasuredDimension(min,min)
    }
}