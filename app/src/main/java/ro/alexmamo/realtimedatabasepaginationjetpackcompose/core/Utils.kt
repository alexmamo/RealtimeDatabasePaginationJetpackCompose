package ro.alexmamo.realtimedatabasepaginationjetpackcompose.core

import android.util.Log
import androidx.paging.LoadState
import ro.alexmamo.realtimedatabasepaginationjetpackcompose.core.Constants.TAG

class Utils {
    companion object {
        fun printErrorState(errorState: LoadState.Error) = errorState.error.message?.let {
            Log.d(TAG, it)
        }

        fun printError(e: Exception?) = e?.message?.let {
            Log.d(TAG, it)
        }
    }
}