package com.jetbrains.handson.mpp.mobile

import kotlin.coroutines.*
import kotlinx.coroutines.*


internal actual val ApplicationDispatcher: CoroutineDispatcher = NsQueueDispatcher(dispatch_get_main_queue())

internal class NsQueueDispatcher(
    private val dispatchQueue: dispatch_queue_t
) : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatchQueue) {
            block.run()
        }
    }
}

internal actual val UiDispatcher: CoroutineDispatcher
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.