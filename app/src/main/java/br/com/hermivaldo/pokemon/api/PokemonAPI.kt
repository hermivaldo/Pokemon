package br.com.hermivaldo.pokemon.api

import br.com.hermivaldo.pokemon.model.Pokemon
import br.com.hermivaldo.pokemon.model.Sprite
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonAPI {

    @GET("/api/v2/pokemon/{numero}")
    fun buscarPokemon(@Path("numero") numeroPokemon: Int) : Call<Pokemon>

}