package com.kc.kmmdemo

import PlanetsResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class Network{
    private val client = HttpClient(){
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys=true
                prettyPrint=true
            })
        }
    }
    suspend fun getPlanets(): PlanetsResponse {
        val response = client.get("https://swapi.dev/api/planets")
        return response.body()
    }
}