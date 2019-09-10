package todolist

import com.fasterxml.jackson.databind.ObjectMapper
import spark.ResponseTransformer

/**
 * Created by hideaki on 2019/09/10.
 */
class JsonTransformer(private val objectMapper: ObjectMapper) : ResponseTransformer {
    override fun render(model: Any?): String? = objectMapper.writeValueAsString(model)
}
