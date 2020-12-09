package com.example.app.widget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.ScrollView
import kotlin.math.abs


/**
 * 类描述：
 * @author sungen
 * @date 2020/12/8 4:01 PM
 **/

class NestScrollView(context: Context?, attrs: AttributeSet?) : ScrollView(context, attrs) {
    private var lastX = 0f
    private var lastY = 0f
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        val x = ev.rawX
        val y = ev.rawY
        var dealtX = 0f
        var dealtY = 0f
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                dealtX = 0f
                dealtY = 0f
                parent.requestDisallowInterceptTouchEvent(true)
            }
            MotionEvent.ACTION_MOVE -> {
                dealtX += abs(lastX - x)
                dealtY += abs(lastY - y)
                Log.d(TAG, "onTouchEvent: dealtX->$dealtX,dealtY--->$dealtY")
                if (dealtX > dealtY) {
                    parent.requestDisallowInterceptTouchEvent(false)
                } else {
                    parent.requestDisallowInterceptTouchEvent(true)
                }
                lastX = x
                lastY = y
            }
        }
        return super.dispatchTouchEvent(ev)
    }
}