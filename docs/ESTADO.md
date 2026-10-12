# Estado actual del proyecto

*Nota de traspaso entre sesiones. Claude Code la actualiza al cerrar cada sesión; tú puedes editarla cuando quieras. Mantenla corta: solo el presente, la historia ya está en Git y en el diario.*

**Última actualización:** 12/10/2026
**Fase actual:** 1 · UI estática (recién empezada)
**Rama activa:** `feat/static-list` (subida a GitHub, sincronizada con `origin/feat/static-list`)

## Hecho en la última sesión
- **Fase 0 cerrada.** PR #1 y PR #2 fusionados en `main` (merge normal) y etiqueta `v0.0.1` publicada sobre el merge del PR #1. Casillas de la Fase 0 marcadas en el roadmap.
- `gh` autenticado como `txema9`; rama por defecto del repo cambiada a `main`.
- Claude Desktop conectado a la carpeta del proyecto con el servidor MCP de archivos (`+` → Conectores, por chat). Copia de la config original en `%APPDATA%\Claude\claude_desktop_config.json.bak`.

- Ramas `chore/setup` y `docs/phase0-done` borradas (local y remoto) tras comprobar que estaban fusionadas. Quedan solo `main` y `feat/static-list`.
- Creado el archivo vacío `ui/components/EntryCard.kt` (solo la línea `package`), ya añadido al área de preparación (`git add`) por Android Studio. Todavía sin commit.
- Hecha la prueba del conector de Claude Desktop con `iatlas`: lista `docs/` y lee `GIT.md` correctamente.

## A medias
- **`EntryCard`**: nivel de ayuda acordado = `ejemplo` (decidido por Claude a petición del usuario; bajar a `pista` cuando coja soltura). Se le dio un ejemplo (`ContactRow`) y la tarea: escribir `EntryCard` con `title`, `aiName`, `isFavorite` y `modifier`, más un `@Preview` privado. Lo escribe el usuario y se revisa.
- Versión **esqueleto** a propósito: sin franja, sombra sólida ni etiquetas de `docs/DISENO.md`, porque dependen de `SolidShadowBox`, `AiLabel` y `CategoryPill`, que aún no existen.
- `docs/DIARIO.md` ya tiene la entrada de Git de hoy (conceptos, problemas resueltos y chuleta). Faltan los conceptos de Kotlin/Compose (ver abajo).

## Siguiente paso
1. Escribir `EntryCard` (el usuario) y pedir revisión. Después, hacer commit en `feat/static-list`, p. ej. `feat: add EntryCard composable with preview`.
2. Siguiente tarea de la Fase 1: lista con `LazyColumn` y datos falsos (`data class` para la entrada).
3. Revisar la entrada de Git del `docs/DIARIO.md` (la redactó Claude; conviene que el usuario la reescriba con sus palabras) y luego pedir el PDF de repaso a Claude Desktop con el prompt acordado.

## Dudas abiertas
- `dynamicColor = true` sigue activo en `Theme.kt`: la app usa los colores del sistema, no la paleta "Síntesis". Se desactiva en la Fase 8.
- Conceptos de Kotlin/Compose vistos hoy para el `DIARIO.md`: composable (función que describe la UI), `Modifier`, `Row`/`Column`, parámetro `modifier` por convención, `@Preview`, valores por defecto en parámetros; y que la carpeta `java` también aloja Kotlin.
- Los conceptos de Git ya están en el `DIARIO.md`; falta añadir ahí los de Kotlin/Compose de arriba.
