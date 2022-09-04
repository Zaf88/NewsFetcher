package com.example.newsfetcher.Base

import android.content.Context
import android.content.res.Configuration
import android.widget.TextView
import androidx.annotation.StyleRes
import androidx.core.widget.TextViewCompat

inline fun <reified T> attempt(func: ()->T): Either<Throwable, T> = try {
    Either.Right(func.invoke())
} catch (e:Throwable){
    Either.Left(e)
}

fun TextView.setTextAppearanceCombat(@StyleRes styleRes:Int ) {
    TextViewCompat.setTextAppearance(this, styleRes)
}

fun Context.isDarkModeEnabled(): Boolean {
    return resources.configuration.uiMode and
            Configuration. UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES}