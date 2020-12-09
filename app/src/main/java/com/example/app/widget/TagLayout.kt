package com.example.app.widget

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.ViewGroup
import androidx.core.view.children
import kotlin.math.max

val TAG = "TagLayout"

/**
 * 类描述：
 * @author sungen
 * @date 2020/7/9 4:02 PM
 **/

class TagLayout(context: Context?, attrs: AttributeSet?) : ViewGroup(context, attrs) {
    private val childBounds = mutableListOf<Rect>()
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        Log.d(TAG, "onMeasure: TagLayout")
        var widthUsed = 0
        var heightUsed = 0
        var lineMaxHeight = 0
        var lineMaxWidth = 0//最长的行的宽度
        var measureSpecWidthSize = MeasureSpec.getSize(widthMeasureSpec)
        var measureSpecWidthMode = MeasureSpec.getMode(widthMeasureSpec)
        for ((index, child) in children.withIndex()) {
            measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, heightUsed)
            if (measureSpecWidthMode != MeasureSpec.UNSPECIFIED && widthUsed + child.measuredWidth > measureSpecWidthSize) {
                //折行
                heightUsed += lineMaxHeight
                lineMaxWidth = max(lineMaxWidth, widthUsed)
                lineMaxHeight = 0
                widthUsed = 0
            }
            measureChildWithMargins(child, widthMeasureSpec, widthUsed, heightMeasureSpec, heightUsed)
            if (index >= childBounds.size) {
                childBounds.add(Rect())
            }
            val childBounds = childBounds[index]
            childBounds.set(widthUsed, heightUsed, widthUsed + child.measuredWidth, heightUsed + child.measuredHeight)
            widthUsed += child.measuredWidth
            lineMaxHeight = max(lineMaxHeight, child.measuredHeight)
        }
        val selfWidth = max(widthUsed, lineMaxWidth)
        val selfHeight = lineMaxHeight + heightUsed
        setMeasuredDimension(selfWidth, selfHeight)

    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        Log.d(TAG, "onLayout: ")
        for ((index, child) in children.withIndex()) {
            val childRect = childBounds[index]
            child.layout(childRect.left, childRect.top, childRect.right, childRect.bottom)
        }
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        Log.d(TAG, "generateLayoutParams: ")
        return MarginLayoutParams(context, attrs)
    }
}