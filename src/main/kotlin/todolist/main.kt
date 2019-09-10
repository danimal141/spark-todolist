package todolist

/**
 * Created by hideaki on 2019/09/08.
 */

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import spark.Spark.get
import spark.Spark.post

fun main(args: Array<String>) {
    val objectMapper = ObjectMapper().registerKotlinModule()
    val jsonTransformer = JsonTransformer(objectMapper)
    val taskRepository = TaskRepository()
    val taskController = TaskController(objectMapper, taskRepository)

    get("/tasks", taskController.index(), jsonTransformer)
    post("/tasks", taskController.create(), jsonTransformer)
}
