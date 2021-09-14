package formation.androidkotlin.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var serviceIntent: Intent
    private val launchService: Button by lazy {
        findViewById(R.id.startService)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("ServiceTest", "MainActivity, thread id : ${Thread.currentThread().id}")
        initServiceIntent()
        initStartServiceClickListener()
    }

    private fun initServiceIntent() {
        serviceIntent = Intent(this, MyService::class.java)
    }

    private fun initStartServiceClickListener() {
        launchService.setOnClickListener {
            startService(serviceIntent)
        }
    }
}