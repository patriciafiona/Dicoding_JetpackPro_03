package com.path_studio.moviecatalogue.helper

sealed class BackPress {
    object Idle : BackPress()
    object InitialTouch : BackPress()
}