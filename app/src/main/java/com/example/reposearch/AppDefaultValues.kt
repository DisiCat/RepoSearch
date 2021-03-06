package com.example.reposearch

object AppDefaultValues {
    const val CLIENT_ID = "a899794694e653a2d991"
    const val CLIENT_SECRET = "cfad12ef0fdb62b3a6ac30cc4223fed790127365"
    const val REDIRECT_URI = "githubapps://callback"
    const val SCOPE = "read:user,user:email"
    const val AUTH_URL = "https://github.com/login/oauth/authorize"
    const val TOKEN_URL = "https://github.com/login/oauth/access_token"
    const val API_URL = "https://api.github.com/"
    const val REPO_URL = "https://api.github.com/search/repositories"
    const val PAGE_COUNT = 15
    const val APP_LOCAL_STORAGE: String = "app_local_storage"
    const val REPOSITORIES_LIST = "repositories_list"
}