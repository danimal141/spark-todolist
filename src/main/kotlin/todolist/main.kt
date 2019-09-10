package todolist

/**
 * Created by hideaki on 2019/09/08.
 */

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import spark.Spark.get

fun main(args: Array<String>) {
    val objectMapper = ObjectMapper().registerKotlinModule()
    val jsonTransformer = JsonTransformer(objectMapper)
    val taskController = TaskController()
    get("/tasks", taskController.index(), jsonTransformer)
}
