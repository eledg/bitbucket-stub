package com.elliotledger.bitbucketstub.dataclasses

data class CommitResponse(
    val values: List<CommitValue>,
    val size: Int,
    val isLastPage: Boolean,
    val start: Int,
    val limit: Int,
    val nextPageStart: Int?
)
