package todolist

import spark.Route

/**
 * Created by hideaki on 2019/09/10.
 */
class TaskController {
    fun index(): Route = Route { req, res ->
        // TODO: replace
        listOf(
            Task(1, "Test1", false),
            Task(2, "Test2", true)
        )
    }
}
