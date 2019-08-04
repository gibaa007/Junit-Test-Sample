package com.g7.junit

import android.text.TextWatcher
import android.text.Editable
import java.util.regex.Pattern


class EmailValidator : TextWatcher {
    /**
     * Email validation pattern.
     */
    val EMAIL_PATTERN = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )
    private var mIsValid = false
    fun isValid(): Boolean {
        return mIsValid
    }

    /**
     * Validates if the given input is a valid email address.
     *
     * @param email        The email to validate.
     * @return `true` if the input is a valid email. `false` otherwise.
     */
    fun isValidEmail(email: CharSequence?): Boolean {
        return email != null && EMAIL_PATTERN.matcher(email).matches()
    }

    override fun afterTextChanged(editableText: Editable) {
        mIsValid = isValidEmail(editableText)
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {/*No-op*/
    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {/*No-op*/
    }
}
