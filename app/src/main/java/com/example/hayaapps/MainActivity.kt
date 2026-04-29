package com.example.hayaapps

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hayaapps.databinding.ActivityMainBinding
import com.example.hayaapps.pertemuan_4.FourthActivity
import com.example.hayaapps.pertemuan_7.SeventhActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnToSecond.setOnClickListener {
            //Mengambil value dari inputNama dan menampilkan di Logcat

            val intent = Intent(this, FourthActivity::class.java)

            startActivity(intent)
        }

        binding.btnToThird.setOnClickListener {
            //Mengambil value dari inputNama dan menampilkan di Logcat

            val intent = Intent(this, FourthActivity::class.java)

            startActivity(intent)
        }

        //Kode ini harus selalu dipanggil saat butuh akses "user_pref"
        val sharedPref = getSharedPreferences("session_user", MODE_PRIVATE)

        binding.btnToFourth.setOnClickListener {
            //Mengambil value dari inputNama dan menampilkan di Logcat

            val intent = Intent(this, FourthActivity::class.java)

            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)

            startActivity(intent)
        }

        binding.btnToFifth.setOnClickListener {
            //Mengambil value dari inputNama dan menampilkan di Logcat

            val intent = Intent(this, FourthActivity::class.java)

            startActivity(intent)
        }

        binding.btnToSeven.setOnClickListener {
            //Mengambil value dari inputNama dan menampilkan di Logcat

            val intent = Intent(this, SeventhActivity::class.java)

            startActivity(intent)
        }

        binding.btnLogout.setOnClickListener {

            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin melanjutkan?")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()

                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    val intent = Intent(this, AuthActivity::class.java)
                    startActivity(intent)
                    Log.e("Info Dialog","Anda memilih Ya!")
                    finish()
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog","Anda memilih Tidak!")
                }
                .show()
        }
    }
}