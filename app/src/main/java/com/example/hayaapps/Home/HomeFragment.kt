package com.example.hayaapps.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hayaapps.AuthActivity
import com.example.hayaapps.Home.pertemuan_4.FourthActivity
import com.example.hayaapps.Home.pertemuan_7.SeventhActivity
import com.example.hayaapps.R
import com.example.hayaapps.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnToSecond.setOnClickListener {
            //Mengambil value dari inputNama dan menampilkan di Logcat

            val intent = Intent(requireContext(), FourthActivity::class.java)

            startActivity(intent)
        }

        binding.btnToThird.setOnClickListener {
            //Mengambil value dari inputNama dan menampilkan di Logcat

            val intent = Intent(requireContext(), FourthActivity::class.java)

            startActivity(intent)
        }

        //Kode ini harus selalu dipanggil saat butuh akses "user_pref"
        val sharedPref = requireContext().getSharedPreferences("session_user", MODE_PRIVATE)

        binding.btnToFourth.setOnClickListener {
            //Mengambil value dari inputNama dan menampilkan di Logcat

            val intent = Intent(requireContext(), FourthActivity::class.java)

            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)

            startActivity(intent)
        }

        binding.btnToFifth.setOnClickListener {
            //Mengambil value dari inputNama dan menampilkan di Logcat

            val intent = Intent(requireContext(), FourthActivity::class.java)

            startActivity(intent)
        }

        binding.btnToSeven.setOnClickListener {
            //Mengambil value dari inputNama dan menampilkan di Logcat

            val intent = Intent(requireContext(), SeventhActivity::class.java)

            startActivity(intent)
        }

        binding.btnLogout.setOnClickListener {

            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin melanjutkan?")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()

                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    val intent = Intent(requireContext(), AuthActivity::class.java)
                    startActivity(intent)
                    Log.e("Info Dialog","Anda memilih Ya!")
                    requireActivity().finish()
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog","Anda memilih Tidak!")
                }
                .show()
        }
    }
}