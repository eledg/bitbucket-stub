package com.elliotledger.bitbucketstub.services

import com.elliotledger.bitbucketstub.dataclasses.CommitAuthor
import com.elliotledger.bitbucketstub.dataclasses.CommitProperties
import com.elliotledger.bitbucketstub.dataclasses.CommitResponse
import com.elliotledger.bitbucketstub.dataclasses.CommitValue

class BitBucketServices {
    fun getRepoCommits(start: Int, limit: Int, since: String?, until: String?): CommitResponse {
        var commits = listOf(
            CommitValue(
                id = "1234567890",
                message = "This is the commit message",
                author = CommitAuthor(
                    name = "Tony Foxbridge"
                ),
                authorTimestamp = 1607703446000,
                properties = CommitProperties(
                    jiraKey = listOf(
                        "ABC-1111",
                        "ABC-1112",
                        "ABC-1113",
                        "ABC-1114",
                    )
                )
            )
        )
        if (since != null && until != null && since == until) {
            commits = listOf()
        }
        return CommitResponse(
            values = commits,
            size = commits.size,
            isLastPage = true,
            start = start,
            limit = limit,
            nextPageStart = null
        )
    }

    fun getFile(): String {
        return """
            #20.12.10.0845
            DOCKER_APP_IMAGE=000000000000.dkr.ecr.eu-west-1.amazonaws.com/domain/project/component:MASTER-2020.12.10.082214
        """.trimIndent()
    }
}