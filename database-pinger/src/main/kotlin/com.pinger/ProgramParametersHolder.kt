package com.pinger

import com.beust.jcommander.JCommander
import com.beust.jcommander.Parameter

/**
 * @author Dmitry Zhuravlev
 *         Date:  22.03.2017
 */
class ProgramParametersHolder(args: Array<String>) {
    companion object {
        @Parameter(names = arrayOf("-h", "--host"), description = "Database host", required = true)
        lateinit internal var host: String

        @Parameter(names = arrayOf("-p", "--port"), description = "Database port")
        internal var port: Int? = null

        @Parameter(names = arrayOf("-d", "--database"), description = "Database name", required = true)
        lateinit internal var database: String

        @Parameter(names = arrayOf("-u", "--user"), description = "User name", required = true)
        lateinit internal var user: String

        @Parameter(names = arrayOf("--password"), description = "User password", required = true)
        lateinit internal var password: String

        @Parameter(names = arrayOf("-t", "--type"), description = "Database type", required = true)
        lateinit internal var type: DatabaseType
    }

    init {
        JCommander(this, *args)
        host = if (port != null) "$host:$port" else host
    }
}

