package com.example.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.app.entity.User
import com.example.core.utils.CacheUtils
import com.example.core.utils.Utils
import com.example.lesson.LessonActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val usernameKey = "username"
        const val passwordKey = "password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et_username.setText(CacheUtils.get(usernameKey))
        et_password.setText(CacheUtils.get(passwordKey))
        btn_login.setOnClickListener(this)
        code_view.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.code_view -> code_view.updateCode()
            R.id.btn_login -> login()
        }
    }

    private fun login() {
        val name = et_username.text.toString()
        val password = et_password.text.toString()
        val code = et_code.text.toString()
        var user = User(name, password, code)
        if (verify(user)) {
            CacheUtils.save(usernameKey, name)
            CacheUtils.save(passwordKey, password)
            startActivity(Intent(this, LessonActivity::class.java))
        }
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