package todolist

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by hideaki on 2019/09/10.
 */
data class TaskCreateRequest(
    @JsonProperty("content", required = true) val content: String
)
