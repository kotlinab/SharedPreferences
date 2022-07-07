package es.ipow.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import es.ipow.sharedpreferences.SharedPreferences.Companion.prefs
import es.ipow.sharedpreferences.databinding.ActivityAccessBinding

class AccessActivity : AppCompatActivity() {
    private lateinit var b : ActivityAccessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityAccessBinding.inflate(layoutInflater)
        setContentView(b.root)
        initUI()
    }

    fun initUI(){
        b.btnClose.setOnClickListener {
            prefs.wipeData()
            onBackPressed()
        }
        val userName = prefs.getName()
        b.tvHello.text = "¡Hola $userName!"
        if (prefs.getColorCheck()) {
            b.containerLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.orange))
        }
    }
}