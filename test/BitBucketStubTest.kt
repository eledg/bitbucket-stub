package com.elliotledger

import io.ktor.http.*
import io.ktor.http.auth.*
import kotlin.test.*
import io.ktor.server.testing.*
import java.util.*

class BitBucketStubTest {
    private val username = "username"
    private val password = "password"

    @Test
    fun getCommits() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/rest/api/1.0/projects/ABC/repos/component-1/commits") {
                addHeader(
                    HttpHeaders.Authorization,
                    HttpAuthHeader.Single("basic", Base64.getEncoder().encodeToString("$username:$password".toByteArray())).render()
                )
            }.apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }
}
