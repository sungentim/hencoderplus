package com.example.core.utils

import android.annotation.SuppressLint
import android.content.Context
import com.example.core.BaseApplication
import com.example.core.R

object CacheUtils {
    /**
     * private static SharedPreferences SP = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);

    public static void save(String key, String value) {
    SP.edit().putString(key, value).apply();
    }

    public static String get(String key) {
    return SP.getString(key, null);
    }
     */
    @SuppressLint("StaticFieldLeak")
    private val context = BaseApplication.currentApplication()
    private val SP = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
    @JvmStatic
    fun save(key: String, value: String) = SP.edit().putString(key, value).apply()

    @JvmStatic
    fun get(key: String): String? = SP.getString(key, null)


}