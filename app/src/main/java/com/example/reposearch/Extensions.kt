package com.example.reposearch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


    fun ViewGroup.showSpinnerExtension() {
        val spinnerView = LayoutInflater.from(this.context).inflate(R.layout.fragment_spinner, null)
        spinnerView.tag = "spinnerView"
        spinnerView.layoutParams = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        CoroutineScope(Dispatchers.Main).launch {
            this@showSpinnerExtension.addView(spinnerView)
        }
    }

inline fun View.setSafeOnClickListener(
    defaultInterval: Int = 1000,
    crossinline onSafeClick: (View) -> Unit
) {
    val safeClickListener = SafeClickListener(defaultInterval) {
        onSafeClick(it)
    }
    setOnClickListener(safeClickListener)
}
