package com.example.recycleviewpahlawan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleviewpahlawan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    fun generateDummy(): List<Pahlawan> {
        return listOf(
            Pahlawan(pahlawanName = "Jendral Soedirman", pahlawanDesc = "Jawa Tengah, 1916 - 1950", pahlawanImage = R.drawable.a),
            Pahlawan(pahlawanName = "Cut Nyak Dhien", pahlawanDesc = "Aceh, 1848 - 1908", pahlawanImage = R.drawable.b),
            Pahlawan(pahlawanName = "Sultan Hasanuddin", pahlawanDesc = "Sulawesi Selatan, 1631 - 1669", pahlawanImage = R.drawable.c),
            Pahlawan(pahlawanName = "Tuanku Imam Bonjol", pahlawanDesc = "Sumatra Barat, 1772 - 1864", pahlawanImage = R.drawable.d),
            Pahlawan(pahlawanName = "Pattimura", pahlawanDesc = "Maluku, 1763 - 1817", pahlawanImage = R.drawable.e),
            Pahlawan(pahlawanName = "Ki Hajar Dewantara", pahlawanDesc = "Yogyakarta, 1889 - 1959", pahlawanImage = R.drawable.f),
            Pahlawan(pahlawanName = "Frans Kaisiepo", pahlawanDesc = "Papua, 1921 - 1979", pahlawanImage = R.drawable.g),
            Pahlawan(pahlawanName = "Otto Iskandardinata", pahlawanDesc = "Sumatra Utara, 1912 - 1945", pahlawanImage = R.drawable.h),
            Pahlawan(pahlawanName = "Agus Salim", pahlawanDesc = "Jawa Barat, 1884 - 1954", pahlawanImage = R.drawable.i),
            Pahlawan(pahlawanName = "Pangeran Diponegoro", pahlawanDesc = "Yogyakarta, 1785 - 1855", pahlawanImage = R.drawable.j),)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapterPahlawan = PahlawanAdapter(generateDummy()) { pahlawan ->
            Toast.makeText(this@MainActivity, "You clicked on ${pahlawan.pahlawanName}", Toast.LENGTH_SHORT).show()
        }

        with(binding){
            rvPahlawan.apply {
                adapter = adapterPahlawan
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }
}