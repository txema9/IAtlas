package com.txema9.iatlas.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Tarjeta que resume una entrada del mapa de IAs: su título, la IA donde
 * se usó y una estrella si está marcada como favorita.
 *
 * Es una versión esqueleto: aún no lleva la franja de color, la sombra ni
 * las etiquetas de `docs/DISENO.md`.
 *
 * @param title título de la entrada.
 * @param aiName nombre de la IA asociada (p. ej. "ChatGPT").
 * @param isFavorite si es `true`, se muestra la estrella.
 * @param modifier permite a quien use la tarjeta ajustarla desde fuera
 * (tamaño, márgenes...) sin tocar este código.
 */
@Composable
fun EntryCard(
    title: String,
    aiName: String,
    isFavorite: Boolean,
    modifier: Modifier = Modifier
) {
    // El modifier recibido va primero y el padding se encadena después:
    // así se conserva lo que decida el llamador y además añadimos el nuestro.
    Row(modifier = modifier.padding(16.dp)) {
        // Column apila título y nombre de la IA en vertical.
        Column {
            Text(text = title)
            Text(text = aiName)
        }
        // Un composable es una función normal: si la condición es falsa,
        // simplemente no se llama y no se dibuja nada (no hace falta `else`).
        if (isFavorite) {
            Text("★")
        }
    }
}

// Solo sirve para ver la tarjeta en el panel de Android Studio sin lanzar
// el emulador. Es privada porque no forma parte de la app.
@Preview(showBackground = true)
@Composable
private fun EntryCardPreview() {
    EntryCard(title = "Prompt para resumir PDFs", aiName = "Claude", isFavorite = true)
}