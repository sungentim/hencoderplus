package com.example.core

import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    private val viewHasMap = HashMap<Int, View?>()
    fun <T : View> getView(@IdRes id: Int): T {
        var view: View? = null
        if (viewHasMap.containsKey(id)) {
            var view = viewHasMap.getValue(id)
        }
        if (view == null) {
            view = itemView.findViewById(id)
            viewHasMap[id] = view
        }
        return view as T
    }

    fun setText(@IdRes id: Int, text: String?) {
        (getView<TextView>(id)).text = text
    }
    /**
     *  public BaseViewHolder(@NonNull View itemView) {
    super(itemView);
    }

    @SuppressLint("UseSparseArrays")
    private final Map<Integer, View> viewHashMap = new HashMap<>();

    @SuppressWarnings("unchecked")
    protected <T extends View> T getView(@IdRes int id) {
    View view = viewHashMap.get(id);
    if (view == null) {
    view = itemView.findViewById(id);
    viewHashMap.put(id, view);
    }
    return (T) view;
    }

    protected void setText(@IdRes int id, @Nullable String text) {
    ((TextView) getView(id)).setText(text);
    }
     */
}