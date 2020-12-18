package com.elliotledger

import com.elliotledger.bitbucketstub.services.BitBucketServices
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.auth.*
import io.ktor.gson.*
import io.ktor.features.*
import io.ktor.client.*
import io.ktor.client.engine.apache.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(Authentication) {
        basic("myBasicAuth") {
            realm = "BitBucket stub"
            validate { if (it.name == "username" && it.password == "password") UserIdPrincipal(it.name) else null }
        }
    }

    install(ContentNegotiation) {
        gson {
        }
    }

    routing {
        authenticate("myBasicAuth") {
            route("/rest/api/1.0/projects/ABC/repos/component-1") {
                get("commits") {
                    var start = 0
                    var limit = 25
                    call.parameters["start"]?.let {
                        start = it.toInt()
                    }
                    call.parameters["limit"]?.let {
                        limit = it.toInt()
                    }
                    val since: String? = call.parameters["since"]
                    val until: String? = call.parameters["until"]
                    call.respond(BitBucketServices().getRepoCommits(start, limit, since, until))
                }
            }
            route("/projects/ABC/repos/component-1") {
                get("raw/path/to/file") {
                    call.respond(BitBucketServices().getFile())
                }
            }
        }
    }
}

