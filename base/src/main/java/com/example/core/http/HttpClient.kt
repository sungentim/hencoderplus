package com.example.core.http

import android.util.Log
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.lang.reflect.Type

class HttpClient : OkHttpClient() {

    companion object {
        @JvmStatic
        val INSTANCE = HttpClient()
        private val gson = Gson()
        private fun <T> convert(json: String, type: Type): T {
            return gson.fromJson(json, type)

        }
    }

    /**
    String json = null;
    try {
    json = body.string();
    } catch (IOException e) {
    e.printStackTrace();
    }
    entityCallback.onSuccess((T) convert(json, type));
    } else if (code >= 400 && code < 500) {
    entityCallback.onFailure("客户端错误");
    } else if (code > 500 && code < 600) {
    entityCallback.onFailure("服务器错误");
    } else {
    entityCallback.onFailure("未知错误");
    }
    }
    });
    }
     */

    @SuppressWarnings("unchecked")
    fun <T> get(path: String, type: Type, entityCallback: EntityCallback<T>) {

        val request = Request.Builder().url("https://api.hencoder.com/$path").build()
        var call = INSTANCE.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                entityCallback.onFailure("网络异常")
            }

            override fun onResponse(call: Call, response: Response) {
//                Log.d("TAG", response.body()?.string())
//                when (response.code()) {
//                    in 200..300 -> {
//                        var result = response.body()?.string()
//                        entityCallback.onSuccess(convert(result!!, type))
//                    }
//                    in 400..500 -> entityCallback.onFailure("客户端错误")
//                    in 500..600 -> entityCallback.onFailure("服务器错误")
//                    else -> entityCallback.onFailure("未知错误")
//                }

            }
        })


    }

}