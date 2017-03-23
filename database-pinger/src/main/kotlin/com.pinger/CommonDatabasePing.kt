package com.pinger

import com.pinger.ProgramParametersHolder.Companion.password
import com.pinger.ProgramParametersHolder.Companion.user
import java.lang.System.exit
import java.sql.Connection
import java.sql.DriverManager
import java.util.*

/**
 * @author Dmitry Zhuravlev
 *         Date:  23.03.2017
 */
abstract class CommonDatabasePing : DatabasePing {

    fun check(performCheck:(Connection)->Unit){
        try {
            DriverManager.getConnection(
                    getJDBCUrl(),
                    Properties().apply {
                        put("user", user)
                        put("password", password)
                    }).use { performCheck(it)}
        } catch(e: Throwable) {
            System.err.println("${e.message}")
            exit(1)
        }
    }
}