package com.example.contextwrapperbug

import android.app.Application

class CustomApplication : Application() {
    // should return Any?
    override fun getSystemService(name: String): Any {
        // if you decompile, there's a
        // Intrinsics.checkExpressionValueIsNotNull(var10000, "super.getSystemService(name)");
        // which will make the application crash in case the super returns null (which is a valid case)
        return super.getSystemService(name)
    }
}
