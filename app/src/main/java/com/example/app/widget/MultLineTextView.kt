package com.example.app.widget

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.example.app.R
import com.example.app.dp

/**
 * 类描述：
 * @author sungen
 * @date 2020/6/1 3:52 PM
 **/
private val IMAGE_WIDTH = 150f.dp()
private val IMAGE_PADDING = 50f.dp()

class MultLineTextView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean neque erat, fermentum ut consectetur non, congue sit amet justo. Quisque scelerisque, leo laoreet euismod semper, risus turpis ullamcorper mauris, ac accumsan velit ante eget enim. Nam turpis ipsum, posuere ut nisl eu, rhoncus scelerisque odio. Proin egestas sit amet libero rutrum consequat. Nunc rutrum mauris massa, eget convallis felis venenatis et. Proin efficitur, justo eget mollis pharetra, lorem mauris facilisis turpis, ut vulputate est nibh ut sem. In et lectus urna. Quisque ultrices id diam sed pellentesque. Phasellus at hendrerit risus. Vestibulum scelerisque, nisl a hendrerit lacinia, ante enim vulputate nulla, ut dictum odio dui sed dolor. Donec sodales mi eget lectus tincidunt, sed rhoncus risus suscipit. Pellentesque ac orci ac lectus sollicitudin aliquet. Aenean sollicitudin lectus eget vehicula sollicitudin. Sed sed purus lacinia, sagittis erat a, elementum risus"
    private val textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 20f.dp()
    }
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 20f.dp()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
//        val staticLayout = StaticLayout(text, 0, text.length, textPaint, width, Layout.Alignment.ALIGN_LEFT,
//                1f, 1f, false)
//        staticLayout.draw(canvas)
        canvas.drawBitmap(getAvatar(IMAGE_WIDTH.toInt()), width - IMAGE_WIDTH, IMAGE_PADDING, paint)
        var count: Int
        var start = 0
        var verticalSpacing = -paint.fontMetrics.top.toFloat()
//        count = paint.breakText(text, true, width.toFloat(), FloatArray(0))
//        canvas.drawText(text, 0, count, 0f, -paint.fontMetricsInt.top.toFloat(), paint)
        while (start < text.length) {
            var maxWidth: Float
            if (verticalSpacing + paint.fontMetrics.bottom < IMAGE_PADDING
                    || verticalSpacing + paint.fontMetrics.top > IMAGE_WIDTH + IMAGE_PADDING) {
                maxWidth = width.toFloat()
            } else {
                maxWidth = width - IMAGE_WIDTH
            }
            count = paint.breakText(text, start, text.length, true, maxWidth, floatArrayOf(0f))
            canvas.drawText(text, start, start + count, 0f, verticalSpacing, paint)
            verticalSpacing += paint.fontSpacing
            start += count
        }

    }

    private fun getAvatar(imageWidth: Int): Bitmap {
        var options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.drawable.avatar_rengwuxian, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = imageWidth
        return BitmapFactory.decodeResource(resources, R.drawable.avatar_rengwuxian, options)
    }
}