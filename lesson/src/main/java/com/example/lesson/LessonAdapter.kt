package com.example.lesson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.core.BaseViewHolder
import com.example.lesson.entity.Lesson

class LessonAdapter : RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {
    var list = listOf<Lesson>()


    class LessonViewHolder(itemView: View) : BaseViewHolder(itemView) {
        companion object {
            @JvmStatic
            fun onCreate(parent: ViewGroup): LessonViewHolder {
                return LessonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_lesson, parent, false))
            }
        }

        fun onBind(lesson: Lesson) {
            var date = lesson.date ?: "日期待定"
            setText(R.id.tv_date, date)
            setText(R.id.tv_content, lesson.content)
            var colorRes = R.color.playback
            when (lesson.state) {
                Lesson.State.PLAYBACK -> {
                    colorRes = R.color.playback
                }
                Lesson.State.LIVE -> {
                    colorRes = R.color.live
                }
                Lesson.State.WAIT -> {
                    colorRes = R.color.wait
                }
            }
            val backgroundColor = itemView.context.getColor(colorRes)
            getView<TextView>(R.id.tv_content).setBackgroundColor(backgroundColor)
        }
    }

    /**

     */

    fun updateAndNotify(list: List<Lesson>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return LessonViewHolder.onCreate(parent)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.onBind(list[position])
    }

}