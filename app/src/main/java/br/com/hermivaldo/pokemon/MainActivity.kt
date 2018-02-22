package br.com.hermivaldo.pokemon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.hermivaldo.pokemon.api.PokemonAPI
import br.com.hermivaldo.pokemon.model.Pokemon
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btPesquisar.setOnClickListener {
            pesquisarPokemon()
        }

    }

    private fun pesquisarPokemon() {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api = retrofit.create(PokemonAPI::class.java)

        val num = buscador.text.toString().toInt()

        api.buscarPokemon(num).enqueue(object : Callback<Pokemon> {
            override fun onResponse(call: Call<Pokemon>?, response: Response<Pokemon>?) {
                tvNomePokemon.text = response!!.body()?.name

                Picasso.with(applicationContext).
                        load(response!!.body()?.sprites?.frontDefault).into(icPokemon)
            }

            override fun onFailure(call: Call<Pokemon>?, t: Throwable?) {

            }
        })

        //var repos = Call<List<Pokemon>> =
    }
}
