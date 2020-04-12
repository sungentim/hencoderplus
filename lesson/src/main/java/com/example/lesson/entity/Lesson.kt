package com.example.lesson.entity

class Lesson(var date: String?, var content: String?, var state: State?) {
    //    private val date: String? = null
//    private val content: String? = null
//    private val state: State? = null
    /**
     * PLAYBACK {
    public String stateName() {
    return "有回放";
    }
    },

    LIVE {
    public String stateName() {
    return "正在直播";
    }
    },

    WAIT {
    public String stateName() {
    return "等待中";
    }
    };

    public abstract String stateName();
     */
    enum class State {
        PLAYBACK {
            override fun stateName(): String {
                return "有回放"
            }

        },
        LIVE {
            override fun stateName(): String {
                return "正在直播"
            }

        },
        WAIT {
            override fun stateName(): String {
                return "等待中"
            }

        };

        abstract fun stateName(): String
    }
}