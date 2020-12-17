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
                        "ABC-1111"
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
}