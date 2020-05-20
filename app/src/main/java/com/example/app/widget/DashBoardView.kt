package com.example.app.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.app.entity.px
import kotlin.math.cos
import kotlin.math.sin

val RADIUS = 100f.px
const val DASH_BOARD_COUNT = 5
const val OPEN_ANGEL = 120f
val DASH_LENGTH = 2f.px
val DASH_HEIGHT = 5f.px
val INDICATOR_LENGTH = 90f.px


class DashBoardView(context: Context, attributes: AttributeSet?) :
        View(context, attributes) {
    private var paint = Paint()
    private var path = Path()
    private var dash = Path()

    init {
        paint.strokeWidth = 2f.px
        paint.style = Paint.Style.STROKE
        dash.addRect(0f, 0f, DASH_LENGTH, DASH_HEIGHT, Path.Direction.CCW)

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        path.addArc(width / 2f - RADIUS, height / 2f - RADIUS, width / 2f + RADIUS, height / 2f + RADIUS
                , OPEN_ANGEL + 30f, 240f)

        //画弧度
        canvas.drawPath(path, paint)
        //画刻度
        paint.pathEffect = PathDashPathEffect(dash, (PathMeasure(path, false).length - DASH_LENGTH) / DASH_BOARD_COUNT, 0f, PathDashPathEffect.Style.ROTATE)
        canvas.drawPath(path, paint)
        paint.pathEffect = null
        //画指针

        canvas.drawLine(width / 2f, height / 2f,
                width / 2f + INDICATOR_LENGTH * cos(Math.toRadians(OPEN_ANGEL + 30f + 2 * (240f / DASH_BOARD_COUNT).toDouble())).toFloat(),
                height / 2f + INDICATOR_LENGTH * sin(Math.toRadians(OPEN_ANGEL + 30f + 2 * (240f / DASH_BOARD_COUNT).toDouble())).toFloat(), paint)
    }


}