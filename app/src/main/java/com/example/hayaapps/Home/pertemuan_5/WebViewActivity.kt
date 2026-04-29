package com.example.hayaapps.Home.pertemuan_5

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.hayaapps.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ TOOLBAR
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Web Merdeka"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        // ✅ WEBVIEW
        binding.webView.webViewClient = WebViewClient()
        binding.webView.settings.javaScriptEnabled = true

        // ✅ IMPROVISASI (TAMBAHAN)
        binding.webView.settings.setSupportZoom(true)
        binding.webView.settings.builtInZoomControls = true
        binding.webView.settings.displayZoomControls = false
        binding.webView.settings.loadWithOverviewMode = true
        binding.webView.settings.useWideViewPort = true

        binding.webView.loadUrl("https://merdeka.com")

        // ✅ SCROLL BEHAVIOR (SESUAI MODUL)
        binding.webView.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
            if (scrollY > oldScrollY) {
                binding.appBar.setExpanded(false, true) // hide
            } else if (scrollY < oldScrollY) {
                binding.appBar.setExpanded(true, true) // show
            }
        }

        // ✅ BACK BUTTON (VERSI MODERN)
        onBackPressedDispatcher.addCallback(this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (binding.webView.canGoBack()) {
                        binding.webView.goBack()
                    } else {
                        finish()
                    }
                }
            }
        )
    }

    // ✅ BACK TOOLBAR (←)
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}