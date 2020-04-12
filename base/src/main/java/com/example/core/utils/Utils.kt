package com.example.core.utils

import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue
import android.widget.Toast
import com.example.core.BaseApplication

class Utils {
    /**
     * private static final DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();

    public static float dp2px(float dp) {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics);
    }

    public static void toast(String string) {
    toast(string, Toast.LENGTH_SHORT);
    }

    public static void toast(String string, int duration) {
    Toast.makeText(BaseApplication.currentApplication(), string, duration).show();
    }
     */
    private val displayMetrics = Resources.getSystem().displayMetrics

    companion object {
        @JvmStatic
        fun dp2px(dp: Float): Float = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, DisplayMetrics())

        @JvmStatic
        @JvmOverloads
        fun toast(string: String, duration: Int = Toast.LENGTH_LONG) = Toast.makeText(BaseApplication.currentApplication(), string, duration).show()

    }
}