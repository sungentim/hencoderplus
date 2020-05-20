package com.example.app.entity

import android.content.res.Resources
import android.util.TypedValue

/**
 * 类描述：
 * @author sungen
 * @date 2020/5/20 10:04 AM
 **/

val Float.px: Float
    get() {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics)
    }