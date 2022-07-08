package es.ipow.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import es.ipow.sharedpreferences.SharedPreferences.Companion.prefs
import es.ipow.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        initUI()
        checkUserValues()
    }

    fun initUI(){
        b.btnAccess.setOnClickListener {
            accessSharedPreferences()
        }
    }

    fun checkUserValues() {
        if(prefs.getName().isNotEmpty()){
            goAccess()
        }
    }

    fun accessSharedPreferences(){
        if (b.etName.text.toString().isNotEmpty()){
            prefs.saveName(b.etName.text.toString())
            prefs.saveRemember(b.ckbRemember.isChecked)
            goAccess()
        } else {
            Toast.makeText(this, "Debe rellenar el nombre", Toast.LENGTH_SHORT).show()
        }
    }

    private fun goAccess() {
        startActivity(Intent(this, AccessActivity::class.java))
    }
}