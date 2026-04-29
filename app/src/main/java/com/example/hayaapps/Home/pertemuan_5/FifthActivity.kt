package com.example.hayaapps.Home.pertemuan_5

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.NestedScrollView
import com.example.hayaapps.R
import java.util.Calendar
class FifthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fifth)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = "Activity Fifth"
            subtitle = "Ini adalah subtitle"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)

            // ✅ TAMBAHAN ICON BACK
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }

        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)

        if (hour in 6..17) {
            toolbar.setBackgroundColor(getColor(android.R.color.holo_orange_light))
            supportActionBar?.title = "Selamat Siang"
            supportActionBar?.subtitle = "Semangat belajar!"
        } else {
            toolbar.setBackgroundColor(getColor(android.R.color.black))
            supportActionBar?.title = "Selamat Malam"
            supportActionBar?.subtitle = "Jangan lupa istirahat"
        }

        // ✅ TAMBAHAN BUTTON WEBVIEW
        val btnWebView = findViewById<Button>(R.id.btnWebView)
        btnWebView.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }

        val scrollView = findViewById<NestedScrollView>(R.id.nestedScrollView)

        scrollView.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->

            if (scrollY > oldScrollY) {
                // scroll ke bawah → sembunyikan tombol
                btnWebView.animate().alpha(0f).setDuration(200).start()
            } else {
                // scroll ke atas → tampilkan tombol
                btnWebView.animate().alpha(1f).setDuration(200).start()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // ✅ MENU
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // ✅ HANDLE MENU + BACK
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }

            R.id.action_search -> {
                Toast.makeText(this, "Search Clicked", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.action_settings -> {
                Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.action_share -> {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, "Coba aplikasi saya: Haya Apps 🚀")

                startActivity(Intent.createChooser(intent, "Bagikan melalui"))
                true
            }


            else -> super.onOptionsItemSelected(item)
        }
    }
}

