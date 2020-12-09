package com.example.app.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager
import kotlin.math.abs

/**
 * 类描述：
 * @author sungen
 * @date 2020/12/8 5:08 PM
 **/

class MyViewPager(context: Context, attrs: AttributeSet?) : ViewPager(context, attrs) {
    private var downX = 0f
    private var downY = 0f
    private var delX = 0f
    private var delY = 0f
    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        var x = ev.rawX
        var y = ev.rawY
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                downX = x
                downY = y
            }
            MotionEvent.ACTION_MOVE -> {
                delX = abs(x - downX)
                delY = abs(y - downY)
                if (delX <= delY) {
                    return false
                }
            }

        }
        return super.onInterceptTouchEvent(ev)
    }
}