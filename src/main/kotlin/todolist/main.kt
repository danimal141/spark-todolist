package todolist

/**
 * Created by hideaki on 2019/09/08.
 */

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import spark.Spark.get

fun main(args: Array<String>) {
    val objectMapper = ObjectMapper().registerKotlinModule()
    get("/tasks") { _, _ ->
        // TODO: replace
        val tasks = listOf(
            Task(1, "Test1", false),
            Task(2, "Test2", true)
        )
        objectMapper.writeValueAsString(tasks)
    }
}
