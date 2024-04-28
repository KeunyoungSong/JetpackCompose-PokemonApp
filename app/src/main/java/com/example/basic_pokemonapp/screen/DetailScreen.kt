package com.example.basic_pokemonapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.basic_pokemonapp.viewmodel.PokemonViewModel

@Composable
fun DetailScreen(
	pokemonId: Int,
	onUpButtonClick: () -> Unit,
	viewModel: PokemonViewModel = hiltViewModel()
) {
	viewModel.getPokemon(pokemonId)
	
	Card(
		elevation = CardDefaults.cardElevation(8.dp), modifier = Modifier.padding(8.dp)
	) {
		Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(8.dp)) {
			val result = viewModel.pokemonResult
			val pokemonName = result.species.name
			
			Text(pokemonName)
			
			AsyncImage(model = result.sprites.frontDefault, contentDescription = pokemonName, modifier = Modifier.size(100.dp))
			
			Button(onClick = onUpButtonClick) {
				Text("위로")
			}
		}
	}
}