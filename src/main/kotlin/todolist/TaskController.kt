package todolist

import com.fasterxml.jackson.databind.ObjectMapper
import spark.Request
import spark.Route
import spark.Spark.halt

/**
 * Created by hideaki on 2019/09/10.
 */
class TaskController(private val objectMapper: ObjectMapper, private val taskRepository: TaskRepository) {
    private val Request.task: Task?
        get() {
            val id = params("id").toLongOrNull()
            return id?.let(taskRepository::findById)
        }

    fun index(): Route = Route { req, res ->
        taskRepository.findAll()
    }

    fun show(): Route = Route { req, res ->
        req.task ?: throw halt(404)
    }

    fun destroy(): Route = Route { req, res ->
        val task = req.task ?: throw halt(404)
        taskRepository.delete(task)
        res.status(204)
    }

    fun create(): Route = Route { req, res ->
        val request: TaskCreateRequest =
            objectMapper.readValue(req.bodyAsBytes()) ?: throw halt(400)
        val task = taskRepository.create(request.content)

        res.status(201)
        task
    }

    fun update(): Route = Route { req, res ->
        val request: TaskUpdateRequest =
            objectMapper.readValue(req.bodyAsBytes()) ?: throw halt(400)
        val task = req.task ?: throw halt(404)
        val newTask = task.copy(
            content = request.content ?: task.content,
            done = request.done ?: task.done
        )
        taskRepository.update(newTask)
        newTask
    }
}
