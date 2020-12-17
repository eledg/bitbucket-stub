package com.elliotledger.bitbucketstub.dataclasses

import com.google.gson.annotations.SerializedName

data class CommitProperties(
    @SerializedName("jira-key")
    val jiraKey: List<String>
)
