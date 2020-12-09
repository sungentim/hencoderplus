package com.example.app

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.app.entity.User
import com.example.core.utils.CacheUtils
import com.example.core.utils.Utils
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val usernameKey = "username"
        const val passwordKey = "password"
    }

    private val fragments = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et_username.setText(CacheUtils.get(usernameKey))
        et_password.setText(CacheUtils.get(passwordKey))
        btn_login.setOnClickListener(this)
        code_view.setOnClickListener(this)
        view_test.setOnClickListener {
            Toast.makeText(this, "点击了", Toast.LENGTH_LONG).show()
        }
        fragments.add(FragmentFirst())
        fragments.add(FragmentSecond())
        vp.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return fragments[position]
            }

            override fun getCount(): Int {
                return fragments.size
            }
        }
//        GlobalScope.launch(Dispatchers.Main) {
//        et_username.setText(CacheUtils.get(usernameKey))
//        et_password.setText(CacheUtils.get(passwordKey))
//        btn_login.setOnClickListener(this)
//        code_view.setOnClickListener(this)
//        print(100f.px)
//        val rengViewModel = RengViewModel()
//        rengViewModel.repos.observe(this,
//                Observer { btn_login.text = it[0].name })
//        classicIoCode1(block = ::UI1)
//        GlobalScope.launch {
//            io1()
//            UI1()
//            io2()
//            UI2()
//            io3()
//            UI3()
//        }
        classicIOCode(block = ::UI1)

        testRxJava()

    }

    private fun testRxJava() {
        val just = Single.just(1)
        val map = just.map {
            it.toString()
        }
        map.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(object : SingleObserver<String> {
            override fun onSuccess(t: String) {
                tv_rx.text = t
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onError(e: Throwable) {
            }
        })
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