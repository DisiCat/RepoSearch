package com.example.reposearch.data.parseModels

import com.squareup.moshi.Json

data class Items(

    @Json( name = "id"                ) var id               : Int?     = null,
    @Json(name ="node_id"           ) var nodeId           : String?  = null,
    @Json(name ="name"              ) var name             : String?  = null,
    @Json(name ="full_name"         ) var fullName         : String?  = null,
    @Json(name ="owner"             ) var owner            : Owner?   = Owner(),
    @Json(name ="private"           ) var private          : Boolean? = null,
    @Json(name ="html_url"          ) var htmlUrl          : String?  = null,
    @Json(name ="description"       ) var description      : String?  = null,
    @Json(name ="fork"              ) var fork             : Boolean? = null,
    @Json(name ="url"               ) var url              : String?  = null,
    @Json(name ="created_at"        ) var createdAt        : String?  = null,
    @Json(name ="updated_at"        ) var updatedAt        : String?  = null,
    @Json(name ="pushed_at"         ) var pushedAt         : String?  = null,
    @Json(name ="homepage"          ) var homepage         : String?  = null,
    @Json(name ="size"              ) var size             : Int?     = null,
    @Json(name ="stargazers_count"  ) var stargazersCount  : Int?     = null,
    @Json(name ="watchers_count"    ) var watchersCount    : Int?     = null,
    @Json(name ="language"          ) var language         : String?  = null,
    @Json(name ="forks_count"       ) var forksCount       : Int?     = null,
    @Json(name ="open_issues_count" ) var openIssuesCount  : Int?     = null,
    @Json(name ="master_branch"     ) var masterBranch     : String?  = null,
    @Json( name ="default_branch"    ) var defaultBranch    : String?  = null,
    @Json( name ="score"             ) var score            : Int?     = null,
    @Json( name ="archive_url"       ) var archiveUrl       : String?  = null,
    @Json( name ="assignees_url"     ) var assigneesUrl     : String?  = null,
    @Json( name ="blobs_url"         ) var blobsUrl         : String?  = null,
    @Json( name ="branches_url"      ) var branchesUrl      : String?  = null,
    @Json( name ="collaborators_url" ) var collaboratorsUrl : String?  = null,
    @Json( name ="comments_url"      ) var commentsUrl      : String?  = null,
    @Json( name ="commits_url"       ) var commitsUrl       : String?  = null,
    @Json( name ="compare_url"       ) var compareUrl       : String?  = null,
    @Json( name ="contents_url"      ) var contentsUrl      : String?  = null,
    @Json( name ="contributors_url"  ) var contributorsUrl  : String?  = null,
    @Json( name ="deployments_url"   ) var deploymentsUrl   : String?  = null,
    @Json( name ="downloads_url"     ) var downloadsUrl     : String?  = null,
    @Json( name ="events_url"        ) var eventsUrl        : String?  = null,
    @Json( name ="forks_url"         ) var forksUrl         : String?  = null,
    @Json( name ="git_commits_url"   ) var gitCommitsUrl    : String?  = null,
    @Json( name ="git_refs_url"      ) var gitRefsUrl       : String?  = null,
    @Json( name ="git_tags_url"      ) var gitTagsUrl       : String?  = null,
    @Json( name ="git_url"           ) var gitUrl           : String?  = null,
    @Json( name ="issue_comment_url" ) var issueCommentUrl  : String?  = null,
    @Json( name ="issue_events_url"  ) var issueEventsUrl   : String?  = null,
    @Json( name ="issues_url"        ) var issuesUrl        : String?  = null,
    @Json( name ="keys_url"          ) var keysUrl          : String?  = null,
    @Json( name ="labels_url"        ) var labelsUrl        : String?  = null,
    @Json( name ="languages_url"     ) var languagesUrl     : String?  = null,
    @Json( name ="merges_url"        ) var mergesUrl        : String?  = null,
    @Json( name ="milestones_url"    ) var milestonesUrl    : String?  = null,
    @Json( name ="notifications_url" ) var notificationsUrl : String?  = null,
    @Json( name ="pulls_url"         ) var pullsUrl         : String?  = null,
    @Json( name ="releases_url"      ) var releasesUrl      : String?  = null,
    @Json( name ="ssh_url"           ) var sshUrl           : String?  = null,
    @Json( name ="stargazers_url"    ) var stargazersUrl    : String?  = null,
    @Json( name ="statuses_url"      ) var statusesUrl      : String?  = null,
    @Json( name ="subscribers_url"   ) var subscribersUrl   : String?  = null,
    @Json( name = "subscription_url"  ) var subscriptionUrl  : String?  = null,
    @Json( name = "tags_url"          ) var tagsUrl          : String?  = null,
    @Json( name = "teams_url"         ) var teamsUrl         : String?  = null,
    @Json( name = "trees_url"         ) var treesUrl         : String?  = null,
    @Json( name = "clone_url"         ) var cloneUrl         : String?  = null,
    @Json( name = "mirror_url"        ) var mirrorUrl        : String?  = null,
    @Json( name = "hooks_url"         ) var hooksUrl         : String?  = null,
    @Json( name = "svn_url"           ) var svnUrl           : String?  = null,
    @Json( name = "forks"             ) var forks            : Int?     = null,
    @Json( name = "open_issues"       ) var openIssues       : Int?     = null,
    @Json( name = "watchers"          ) var watchers         : Int?     = null,
    @Json( name = "has_issues"        ) var hasIssues        : Boolean? = null,
    @Json( name = "has_projects"      ) var hasProjects      : Boolean? = null,
    @Json( name = "has_pages"         ) var hasPages         : Boolean? = null,
    @Json( name = "has_wiki"          ) var hasWiki          : Boolean? = null,
    @Json( name = "has_downloads"     ) var hasDownloads     : Boolean? = null,
    @Json( name = "archived"          ) var archived         : Boolean? = null,
    @Json( name = "disabled"          ) var disabled         : Boolean? = null,
    @Json( name = "visibility"        ) var visibility       : String?  = null,
    @Json( name = "license"           ) var license          : License? = License()

)
