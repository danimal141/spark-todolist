package todolist

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by hideaki on 2019/09/10.
 */
data class TaskUpdateRequest(
    @JsonProperty("content") val content: String?,
    @JsonProperty("done") val done: Boolean?
)
