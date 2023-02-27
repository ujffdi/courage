package com.tongsr.data.remote.adapter


import com.tongsr.data.remote.adapter.async.AsyncBodyFlowCallAdapter
import com.tongsr.data.remote.adapter.async.AsyncResponseFlowCallAdapter
import com.tongsr.data.remote.adapter.sync.BodyFlowCallAdapter
import com.tongsr.data.remote.adapter.sync.ResponseFlowCallAdapter
import retrofit2.CallAdapter
import retrofit2.Response
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import kotlinx.coroutines.flow.Flow
/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/2/23
 * @email ujffdtfivkg@gmail.com
 * @description FlowCallAdapterFactory
 */
class FlowCallAdapterFactory private constructor(
    private val async: Boolean
) : CallAdapter.Factory() {

    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit,
    ): CallAdapter<*, *>? {
        if (getRawType(returnType) != Flow::class.java) return null

        check(returnType is ParameterizedType) {
            "The flow type must be parameterized as Flow<Foo>!"
        }

        val flowableType = getParameterUpperBound(0, returnType)
        val rawFlowableType = getRawType(flowableType)

        return if (rawFlowableType == Response::class.java) {
            check(flowableType is ParameterizedType) {
                "The response type must be parameterized as Response<Foo>!"
            }
            val responseBodyType = getParameterUpperBound(0, flowableType)
            createResponseFlowCallAdapter(async, responseBodyType)
        } else {
            createBodyFlowCallAdapter(async, flowableType)
        }
    }

    companion object {

        @JvmStatic
        fun create(async: Boolean = false) = FlowCallAdapterFactory(async)

    }

}

private fun createResponseFlowCallAdapter(async: Boolean, responseBodyType: Type) =
    if (async) AsyncResponseFlowCallAdapter(responseBodyType)
    else ResponseFlowCallAdapter(responseBodyType)

private fun createBodyFlowCallAdapter(async: Boolean, responseBodyType: Type) =
    if (async) AsyncBodyFlowCallAdapter(responseBodyType)
    else BodyFlowCallAdapter(responseBodyType)