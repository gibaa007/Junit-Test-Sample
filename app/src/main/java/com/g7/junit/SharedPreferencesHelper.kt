package com.g7.junit

import android.content.SharedPreferences
import java.util.*


class SharedPreferencesHelper(sharedPreferences: SharedPreferences) {
    // Keys for saving values in SharedPreferences.
    val KEY_NAME = "key_name"
    val KEY_DOB = "key_dob_millis"
    val KEY_EMAIL = "key_email"
    // The injected SharedPreferences implementation to use for persistence.
    private var mSharedPreferences: SharedPreferences = sharedPreferences


    /**
     * Saves the given [SharedPreferenceEntry] that contains the user's settings to
     * [SharedPreferences].
     *
     * @param sharedPreferenceEntry contains data to save to [SharedPreferences].
     * @return `true` if writing to [SharedPreferences] succeeded. `false`
     * otherwise.
     */
    fun savePersonalInfo(sharedPreferenceEntry: SharedPreferenceEntry): Boolean {
        // Start a SharedPreferences transaction.
        val editor = mSharedPreferences.edit()
        editor.putString(KEY_NAME, sharedPreferenceEntry.getName())
        editor.putLong(KEY_DOB, sharedPreferenceEntry.getDateOfBirth().timeInMillis)
        editor.putString(KEY_EMAIL, sharedPreferenceEntry.getEmail())
        // Commit changes to SharedPreferences.
        return editor.commit()
    }

    /**
     * Retrieves the [SharedPreferenceEntry] containing the user's personal information from
     * [SharedPreferences].
     *
     * @return the Retrieved [SharedPreferenceEntry].
     */
    fun getPersonalInfo(): SharedPreferenceEntry {
        // Get data from the SharedPreferences.
        val name = mSharedPreferences.getString(KEY_NAME, "")
        val dobMillis = mSharedPreferences.getLong(KEY_DOB, Calendar.getInstance().timeInMillis)
        val dateOfBirth = Calendar.getInstance()
        dateOfBirth.timeInMillis = dobMillis
        val email = mSharedPreferences.getString(KEY_EMAIL, "")
        // Create and fill a SharedPreferenceEntry model object.
        return SharedPreferenceEntry(name!!, dateOfBirth, email!!)
    }
}
