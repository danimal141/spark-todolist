package todolist

import com.fasterxml.jackson.databind.ObjectMapper

/**
 * Created by hideaki on 2019/09/11.
 */
inline fun <reified T: Any> ObjectMapper.readValue(src: ByteArray): T? =
    try {
        readValue(src, T::class.java)
    } catch(e: Exception) {
        null
    }
