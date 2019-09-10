package todolist

import spark.Route

/**
 * Created by hideaki on 2019/09/10.
 */
class TaskController(private val taskRepository: TaskRepository) {
    fun index(): Route = Route { req, res ->
        taskRepository.findAll()
    }
}
