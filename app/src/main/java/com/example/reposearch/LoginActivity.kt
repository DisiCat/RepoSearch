package com.example.reposearch

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.reposearch.databinding.ActivityLoginBinding
import com.example.reposearch.enums.EResultType
import com.example.reposearch.viewModels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel by lazy { ViewModelProvider(this).get(LoginViewModel::class.java) }
    lateinit var githubDialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this
        initListeners()
        initObserves()
    }

    private fun initListeners() {
        binding.buttonLoginGithub.setOnClickListener {
            setupGithubWebViewDialog(viewModel.githubAuthURLFull)
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupGithubWebViewDialog(url: String) {
        githubDialog = Dialog(this)
        val webView = WebView(this)
        webView.isVerticalFadingEdgeEnabled = false
        webView.isHorizontalFadingEdgeEnabled = false
        webView.webViewClient = GithubWebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url)
        githubDialog.setContentView(webView)
        githubDialog.show()
    }

    @Suppress("OverridingDeprecatedMember")
    inner class GithubWebViewClient : WebViewClient() {
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            if (request!!.url.toString().startsWith(AppDefaultValues.REDIRECT_URI)) {
                handleUrl(request.url.toString())

                // Close the dialog after getting the authorization code
                if (request.url.toString().contains("code=")) {
                    githubDialog.dismiss()
                }
                return true
            }
            return false
        }

        // For API 19 and below
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            if (url.startsWith(AppDefaultValues.REDIRECT_URI)) {
                handleUrl(url)

                // Close the dialog after getting the authorization code
                if (url.contains("?code=")) {
                    githubDialog.dismiss()
                }
                return true
            }
            return false
        }

        // Check webview url for access token code or error
        private fun handleUrl(url: String) {
            val uri = Uri.parse(url)
            if (url.contains("code")) {
                val githubCode = uri.getQueryParameter("code") ?: ""
                viewModel.getAccessToken(code = githubCode)
                //requestForAccessToken(githubCode)
            }
        }
    }

    private fun initObserves() {
        viewModel.resultType.observe(this) {
            if (it == EResultType.SUCCESS) {
                // go to activity
                val intent = Intent(this, SearchActivity::class.java)
                startActivity(intent)

            } else if (it == EResultType.ERROR) {
                // error
            }
        }
    }
}

