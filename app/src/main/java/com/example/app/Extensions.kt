package com.example.app

import android.content.res.Resources
import android.util.TypedValue

val Float.dp: Float
    get() {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this,
                Resources.getSystem().displayMetrics)
    }
val Int.dp:Float
    get(){
        return this.toFloat().dp
    }
