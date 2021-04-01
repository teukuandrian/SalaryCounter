package org.d3if2090.salarycounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import org.d3if2090.salarycounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { hitungGaji() }
    }
    private fun hitungGaji() {
        val berat = binding.gajiEditText.text.toString()
        if (TextUtils.isEmpty(berat)) {
            Toast.makeText(this, R.string.gaji_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val j = binding.jamEditText.text.toString()
        if (TextUtils.isEmpty(jam)) {
            Toast.makeText(this, R.string.jam_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val jam = jam.toFloat()
        val selectedId = binding.radioGroup.checkedRadioButtonId
        if (selectedId == -1) {
            Toast.makeText(this, R.string.jabatan_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val isManager = selectedId == R.id.managerRadioButton
        val gaji = hitungGaji().toFloat() * jam


    }
        private fun getKategori(jumlahGaji: Float, isManager: Boolean): String {
            val stringRes = if (isManager) {
                when {
                    jumlahGaji < 20.5 -> R.string.kurang
                    jumlahGaji >= 27.0 -> R.string.lebih
                    else -> R.string.pas
                }
            } else {
                when {
                    jumlahGaji < 18.5 -> R.string.kurang
                    jumlahGaji >= 25.0 -> R.string.lebih
                    else -> R.string.pas
                }
            }
            return getString(stringRes)
    }
    }

