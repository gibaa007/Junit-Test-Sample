package com.g7.junit

import java.util.regex.Pattern

class NameValidator {


    fun isValidName(name: String): Boolean {
        return (Pattern.compile( "[A-Z][a-z]*" )).matcher(name).matches()
    }

}
