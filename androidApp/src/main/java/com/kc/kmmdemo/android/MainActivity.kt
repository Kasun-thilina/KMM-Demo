package com.kc.kmmdemo.android

import Planet
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kc.kmmdemo.Greeting
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.kc.kmmdemo.Network
import com.kc.kmmdemo.android.adapter.PlanetsAdapter
import com.kc.kmmdemo.android.databinding.ActivityMainBinding
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    private val mainScope = MainScope()
    private lateinit var binding: ActivityMainBinding
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: PlanetsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val network = Network()
        layoutManager= LinearLayoutManager(this)
        adapter = PlanetsAdapter(this)
        binding.rvPlanets.apply {
            layoutManager=this@MainActivity.layoutManager
            adapter=this@MainActivity.adapter
        }

        mainScope.launch {
            kotlin.runCatching {
                network.getPlanets()
            }.onSuccess {
                if(it.results?.size!=0){
                    adapter.updatePlanets(it.results!! as MutableList<Planet>)
                }
            }.onFailure {
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }
}
