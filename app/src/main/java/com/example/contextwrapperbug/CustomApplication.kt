package com.example.contextwrapperbug

import android.app.Application

class CustomApplication : Application() {
    // should return Any?, and not be allowed by the compiler to return Any
    override fun getSystemService(name: String): Any {
        // since it returns Any, when you decompile, there's a
        // Intrinsics.checkExpressionValueIsNotNull(var10000, "super.getSystemService(name)");
        // which will make the application crash in case the super returns null (which is a valid case)
        return super.getSystemService(name)
    }
}
