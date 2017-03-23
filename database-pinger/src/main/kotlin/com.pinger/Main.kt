package com.pinger

import com.pinger.ProgramParametersHolder.Companion.type

/**
 * @author Dmitry Zhuravlev
 *         Date:  23.03.2017
 */
fun main(args: Array<String>) {
    ProgramParametersHolder(args)
    getPinger(type).check {
        println("Connected to ${it.schema}")
    }
}