package com.jetbrains.handson.mpp.mobile

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.Url
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

internal expect val ApplicationDispatcher: CoroutineDispatcher

internal expect val UiDispatcher: CoroutineDispatcher


class ApplicationApi {
    private val client = HttpClient()

    var address = Url("https://tools.ietf.org/rfc/rfc1866.txt")

    fun about(callback: (String) -> Unit) {
        GlobalScope.apply {

            launch(ApplicationDispatcher) {
                val result: String = client.get {
                    url(this@ApplicationApi.address.toString())
                }

                launch(UiDispatcher) {
                    callback(result)

            }
        }
    }
    }
}