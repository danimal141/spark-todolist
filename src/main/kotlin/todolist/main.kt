package todolist

/**
 * Created by hideaki on 2019/09/08.
 */

import spark.Spark.get

fun main(args: Array<String>) {
    get("/hello") { _, _ ->
        "Hello, world"
    }
}
