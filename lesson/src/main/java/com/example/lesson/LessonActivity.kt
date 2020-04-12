package com.example.lesson

import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.core.BaseView
import com.example.lesson.entity.Lesson
import kotlinx.android.synthetic.main.activity_lesson.*

class LessonActivity : AppCompatActivity(), BaseView<LessonPresenter>, Toolbar.OnMenuItemClickListener {
    /**
     * private LessonPresenter lessonPresenter = new LessonPresenter(this);

    @Override
    public LessonPresenter getPresenter() {
    return lessonPresenter;
    }

    private LessonAdapter lessonAdapter = new LessonAdapter();

    private SwipeRefreshLayout refreshLayout;


    Toolbar toolbar = findViewById(R.id.toolbar);
    toolbar.inflateMenu(R.menu.menu_lesson);
    toolbar.setOnMenuItemClickListener(this);

    RecyclerView recyclerView = findViewById(R.id.list);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(lessonAdapter);
    recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

    refreshLayout = findViewById(R.id.swipe_refresh_layout);
    refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
    @Override
    public void onRefresh() {
    getPresenter().fetchData();
    }
    });
    refreshLayout.setRefreshing(true);

    getPresenter().fetchData();
    }

    public void showResult(List<Lesson> lessons) {
    lessonAdapter.updateAndNotify(lessons);
    refreshLayout.setRefreshing(false);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
    getPresenter().showPlayback();
    return false;
    }
     */
    private val lessonPresenter = LessonPresenter(this)
    private val lessonAdapter = LessonAdapter()
    private lateinit var refreshLayout: SwipeRefreshLayout


    override fun onMenuItemClick(p0: MenuItem?): Boolean {
        presenter.showPlayback()
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)
        toolbar.inflateMenu(R.menu.menu_lesson)
        toolbar.setOnMenuItemClickListener(this)
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = lessonAdapter
        list.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
        swipe_refresh_layout.setOnRefreshListener { presenter.fetchData() }
        swipe_refresh_layout.isRefreshing = true
        presenter.fetchData()
    }

    fun showResult(lessons: List<Lesson>) {
        lessonAdapter.updateAndNotify(lessons)
        swipe_refresh_layout.isRefreshing = false

    }

    override val presenter: LessonPresenter
        get() {
            return lessonPresenter
        }
}