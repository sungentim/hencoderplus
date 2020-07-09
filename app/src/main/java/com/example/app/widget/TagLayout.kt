package com.example.app.widget

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.core.view.children
import kotlin.math.max

/**
 * 类描述：
 * @author sungen
 * @date 2020/7/9 4:02 PM
 **/

class TagLayout(context: Context?, attrs: AttributeSet?) : ViewGroup(context, attrs) {
    private val childRects = mutableListOf<Rect>()
    private var widthUsed = 0
    private var heightUsed = 0
    private var maxHeight = 0
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        for ((index, child) in children.withIndex()) {
            measureChildWithMargins(child, widthMeasureSpec, widthUsed, heightMeasureSpec, heightUsed)
            if (index >= childRects.size) {
                childRects.add(Rect())
            }
            childRects[index].set(widthUsed, heightUsed, widthUsed + child.measuredWidth, heightUsed + child.measuredHeight)
            widthUsed += child.measuredWidth
            maxHeight = max(maxHeight, child.measuredHeight)
        }
        val selfWidth = widthUsed
        val selfHeight = maxHeight
        setMeasuredDimension(selfWidth, selfHeight)

    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        for ((index, child) in children.withIndex()) {
            val childRect = childRects[index]
            child.layout(childRect.left, childRect.top, childRect.right, childRect.bottom)
        }
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }
}