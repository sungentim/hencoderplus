package com.example.app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.app.entity.Repo
import com.example.app.entity.User
import com.example.core.utils.CacheUtils
import com.example.core.utils.Utils
import com.example.lesson.LessonActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
<<<<<<< HEAD
=======
import javax.sql.DataSource
>>>>>>> 37b14d3d246a1d151bf7b818d4668a29d2220487
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val usernameKey = "username"
        const val passwordKey = "password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
<<<<<<< HEAD
        et_username.setText(CacheUtils.get(usernameKey))
        et_password.setText(CacheUtils.get(passwordKey))
        btn_login.setOnClickListener(this)
        code_view.setOnClickListener(this)
//        GlobalScope.launch(Dispatchers.Main) {
=======
//        et_username.setText(CacheUtils.get(usernameKey))
//        et_password.setText(CacheUtils.get(passwordKey))
//        btn_login.setOnClickListener(this)
//        code_view.setOnClickListener(this)
//        print(100f.px)
        val rengViewModel = RengViewModel()
//        rengViewModel.repos.observe(this,
//                Observer { btn_login.text = it[0].name })
//        classicIoCode1(block = ::UI1)
//        GlobalScope.launch {
>>>>>>> 37b14d3d246a1d151bf7b818d4668a29d2220487
//            io1()
//            UI1()
//            io2()
//            UI2()
//            io3()
//            UI3()
//        }
<<<<<<< HEAD
        classicIOCode(block = ::UI1)
    }

    private fun classicIOCode(toUIThread: Boolean = true, block: () -> Unit) {
        thread {
            println("classicIOCode---->${Thread.currentThread().name}")
            Thread.sleep(1000)
            if (toUIThread) {
                runOnUiThread {
                    block.invoke()
                }
            } else {
                block.invoke()
            }
        }
=======

>>>>>>> 37b14d3d246a1d151bf7b818d4668a29d2220487
    }

    private fun classicIoCode1(toUIThread: Boolean = true, block: () -> Unit) {
        thread {
            Thread.sleep(1000)
            if (toUIThread) {
                runOnUiThread {
                    block.invoke()
                }
            } else {
                block.invoke()
            }
        }
    }

    private suspend fun io1() {
        withContext(Dispatchers.IO) {
            println("io1---->${Thread.currentThread().name}")
        }
    }

    private suspend fun io2() {
        withContext(Dispatchers.IO) {
            println("io2---->${Thread.currentThread().name}")
        }
    }

    private suspend fun io3() {
        withContext(Dispatchers.IO) {
            println("io3---->${Thread.currentThread().name}")
        }
    }

    private fun UI1() {
        println("UI1---->${Thread.currentThread().name}")
    }

    private fun UI2() {
        println("UI2---->${Thread.currentThread().name}")
    }

    private fun UI3() {
        println("UI3---->${Thread.currentThread().name}")
    }


    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.code_view -> code_view.updateCode()
            R.id.btn_login -> login()
        }

    }

    private fun login() {
//        val retrofit = Retrofit.Builder().baseUrl("").build()
//        val service = retrofit.create(GitHubService::class.java)
//        val listRepos = service.listRepos("sungentim")
//        listRepos?.enqueue(object : Callback<List<Repo?>?> {
//            override fun onFailure(call: Call<List<Repo?>?>, t: Throwable) {
//            }
//
//            override fun onResponse(call: Call<List<Repo?>?>, response: Response<List<Repo?>?>) {
//                println("response--->${response.body()!![0]!!.name}")
//            }
//        })
//        return
//        val name = et_username.text.toString()
//        val password = et_password.text.toString()
//        val code = et_code.text.toString()
//        var user = User(name, password, code)
//        if (verify(user)) {
//            CacheUtils.save(usernameKey, name)
//            CacheUtils.save(passwordKey, password)
//            startActivity(Intent(this, LessonActivity::class.java))
//        }
    }

    private fun verify(user: User): Boolean {
        if (user.username != null && user.username!!.length < 4) {
            Utils.toast("用户名不合法")
            return false
        }
        if (user.password != null && user.password!!.length < 4) {
            Utils.toast("密码不合法")
            return false
        }
        return true
    }
}