package com.example.app.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import com.example.app.dp
import java.util.*

/**
 * 类描述：
 * @author sungen
 * @date 2020/12/4 2:59 PM
 **/

class ColoredTextView(context: Context?, attrs: AttributeSet?) : androidx.appcompat.widget.AppCompatTextView(context, attrs) {
    private val COLORS = intArrayOf(
            Color.parseColor("#E91E63"),
            Color.parseColor("#673AB7"),
            Color.parseColor("#3F51B5"),
            Color.parseColor("#2196F3")
    )
    private val xPadding = 16f.dp.toInt()
    private val yPadding = 8f.dp.toInt()
    private val cornerRadius = 4f.dp
    private val textSizeList = intArrayOf(16, 16, 16)
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val random = Random()

    init {
        setTextColor(Color.WHITE)
        textSize = textSizeList[random.nextInt(textSizeList.size)].toFloat()
        gravity = Gravity.CENTER
        paint.color = COLORS[random.nextInt(COLORS.size)]
        setPadding(xPadding, yPadding, xPadding, yPadding)
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawRoundRect(0f, 0f, width.toFloat(), height.toFloat(), cornerRadius, cornerRadius, paint)
        super.onDraw(canvas)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//        setMeasuredDimension(100f.dp.toInt(),100f.dp.toInt())
        Log.d(TAG, "onMeasure: ColoredTextView")
    }

}