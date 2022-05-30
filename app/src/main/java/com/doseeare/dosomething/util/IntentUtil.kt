package com.doseeare.dosomething.util

import android.content.Context
import android.content.Intent

object IntentUtil {
    fun invite(context: Context, activity: String) {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        val shareBody = "Can you do this? \n $activity"
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here")
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
        context.startActivity(Intent.createChooser(shareIntent, "Share via"))
    }
}