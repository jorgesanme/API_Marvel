package com.jorgeSM.apimarvel.utils

import java.math.BigInteger
import java.security.MessageDigest

object Utils {

    fun createMD5(input: String): String{
        val messageDigest = MessageDigest.getInstance("MD5")
        return BigInteger(1,messageDigest.digest(input.toByteArray())).toString(16).padStart(32,'0')
    }
}