package com.example.app.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.app.R
import com.example.app.entity.px

private val IMAGE_WIDTH = 200f.px
private val IMAGE_PADDING = 20f.px
private val xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

class AvatarView(context: Context, attributes: AttributeSet?) :
        View(context, attributes) {
    private var paint = Paint()

    override fun onDraw(canvas: Canvas) {
        var saveLayer = canvas.saveLayer(IMAGE_PADDING, IMAGE_PADDING, IMAGE_PADDING + IMAGE_WIDTH, IMAGE_PADDING + IMAGE_WIDTH, paint)
        canvas.drawOval(IMAGE_PADDING, IMAGE_PADDING, IMAGE_PADDING + IMAGE_WIDTH, IMAGE_PADDING + IMAGE_WIDTH, paint)
        paint.xfermode = xfermode
        canvas.drawBitmap(getAvatar(IMAGE_WIDTH.toInt()), IMAGE_PADDING, IMAGE_PADDING, paint)
        paint.xfermode = null
        canvas.restoreToCount(saveLayer)
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

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        println("onMeasure")
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        println("onLayout")
    }


}