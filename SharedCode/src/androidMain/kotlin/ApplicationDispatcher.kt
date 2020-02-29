package com.jetbrains.handson.mpp.mobile

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal actual val ApplicationDispatcher: CoroutineDispatcher = Dispatchers.Default
internal actual val UiDispatcher: CoroutineDispatcher = Dispatchers.Main