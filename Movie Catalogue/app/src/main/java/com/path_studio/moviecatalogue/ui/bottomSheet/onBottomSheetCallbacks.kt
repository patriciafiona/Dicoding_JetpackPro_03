package com.path_studio.moviecatalogue.ui.bottomSheet

import android.view.View

interface OnBottomSheetCallbacks {
    fun onStateChanged(bottomSheet: View, newState: Int)
}