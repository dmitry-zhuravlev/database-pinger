package com.pinger

import com.pinger.DatabaseType.*
import com.pinger.ProgramParametersHolder.Companion.database
import com.pinger.ProgramParametersHolder.Companion.host

/**
 * @author Dmitry Zhuravlev
 *         Date:  23.03.2017
 */
class PostgresDatabasePing : CommonDatabasePing() {
    override fun getJDBCUrl() = """jdbc:postgresql://$host/$database"""
}

class DerbyDatabasePing : CommonDatabasePing() {
    override fun getJDBCUrl() = """jdbc:derby://$host/$database"""
}

class MySQLDatabasePing : CommonDatabasePing() {
    override fun getJDBCUrl() = """jdbc:mysql://$host/$database"""
}
class OracleDatabasePing : CommonDatabasePing() {
    override fun getJDBCUrl() = """jdbc:oracle://$host/$database"""
}

fun getPinger(type: DatabaseType) = when (type) {
    POSTGRES -> PostgresDatabasePing()
    DERBY -> DerbyDatabasePing()
    MYSQL -> MySQLDatabasePing()
    ORACLE -> OracleDatabasePing()
}