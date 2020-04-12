package com.example.lesson

import com.example.core.http.EntityCallback
import com.example.core.http.HttpClient
import com.example.core.utils.Utils
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken

class LessonPresenter(var activity: LessonActivity) {
    companion object {
        const val LESSON_PATH = "lessons"
    }

    private var lessons: List<Lesson> = arrayListOf<Lesson>()
    private val type = object : TypeToken<List<Lesson?>?>() {}.type

    fun fetchData() {
        HttpClient.INSTANCE.get(LESSON_PATH, type, object : EntityCallback<List<Lesson>> {
            override fun onSuccess(entity: List<Lesson>) {
                this@LessonPresenter.lessons = entity
                activity.runOnUiThread { activity.showResult(entity) }
            }

            override fun onFailure(message: String) {
                Utils.toast(message)
            }
        })
    }

    fun showPlayback() {
        var result = lessons.filter { it.state == Lesson.State.PLAYBACK }
        activity.showResult(result)
    }
    /**


    void showPlayback() {
    List<Lesson> playbackLessons = new ArrayList<>();
    for (Lesson lesson : lessons) {
    if (lesson.getState() == Lesson.State.PLAYBACK) {
    playbackLessons.add(lesson);
    }
    }
    activity.showResult(playbackLessons);
    }
     */
}