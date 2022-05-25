package com.example.reposearch.utils

import android.view.View

inline fun View.setSafeOnClickListener(
    defaultInterval: Int = 1000,
    crossinline onSafeClick: (View) -> Unit
) {
    val safeClickListener = SafeClickListener(defaultInterval) {
        onSafeClick(it)
    }
    setOnClickListener(safeClickListener)
}
