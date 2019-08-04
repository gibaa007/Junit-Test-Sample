package com.g7.junit

import java.util.*

class SharedPreferenceEntry(name: String, dateOfBirth: Calendar, email: String) {
    // Name of the user.
    private var mName: String = name
    // Date of Birth of the user.
    private var mDateOfBirth: Calendar = dateOfBirth
    // Email address of the user.
    private var mEmail: String = email

    fun getName(): String {
        return mName
    }

    fun getDateOfBirth(): Calendar {
        return mDateOfBirth
    }

    fun getEmail(): String {
        return mEmail
    }
}
