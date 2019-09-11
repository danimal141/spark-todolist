package todolist

/**
 * Created by hideaki on 2019/09/08.
 */

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import spark.Spark.*

fun main(args: Array<String>) {
    val objectMapper = ObjectMapper().registerKotlinModule()
    val jsonTransformer = JsonTransformer(objectMapper)
    val taskRepository = TaskRepository()
    val taskController = TaskController(objectMapper, taskRepository)

    path("/tasks") {
        get("", taskController.index(), jsonTransformer)
        get("/:id", taskController.show(), jsonTransformer)
        post("", taskController.create(), jsonTransformer)
        delete("/:id", taskController.destroy(), jsonTransformer)
    }
}
