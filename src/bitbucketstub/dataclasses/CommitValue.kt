package com.elliotledger.bitbucketstub.dataclasses

data class CommitValue(
    val id: String,
    val message: String,
    val author: CommitAuthor,
    val authorTimestamp: Long,
    val properties: CommitProperties
)
