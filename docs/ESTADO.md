# Estado actual del proyecto

*Nota de traspaso entre sesiones. Claude Code la actualiza al cerrar cada sesión; tú puedes editarla cuando quieras. Mantenla corta: solo el presente, la historia ya está en Git y en el diario.*

**Última actualización:** 12/10/2026
**Fase actual:** 1 · UI estática (recién empezada)
**Rama activa:** `feat/static-list` (local, aún sin subir; creada desde `main`)

## Hecho en la última sesión
- **Fase 0 cerrada.** PR #1 y PR #2 fusionados en `main` (merge normal) y etiqueta `v0.0.1` publicada sobre el merge del PR #1. Casillas de la Fase 0 marcadas en el roadmap.
- `gh` autenticado como `txema9`; rama por defecto del repo cambiada a `main`.
- Claude Desktop conectado a la carpeta del proyecto con el servidor MCP de archivos (`+` → Conectores, por chat). Copia de la config original en `%APPDATA%\Claude\claude_desktop_config.json.bak`.

## A medias
- Nada de código todavía. La rama `chore/setup` (ya fusionada) sigue existiendo en local y en GitHub; se puede borrar cuando quieras.
- `docs/DIARIO.md` aún no tiene los conceptos de Git (ver abajo).

## Siguiente paso
1. Primera tarea de la Fase 1: `EntryCard` con `@Preview` (composable de una tarjeta). Elegir nivel de ayuda: `pista`, `ejemplo` o `solución`.
2. Subir la rama con `git push -u origin feat/static-list` al hacer el primer commit.
3. Rellenar `docs/DIARIO.md` con los conceptos de Git (esqueleto con ejemplos reales; tú redactas) y luego pedir el PDF de repaso a Claude Desktop.

## Dudas abiertas
- `dynamicColor = true` sigue activo en `Theme.kt`: la app usa los colores del sistema, no la paleta "Síntesis". Se desactiva en la Fase 8.
- Conceptos de Git para el `DIARIO.md`: remoto/`origin`, `push -u` (upstream), ancestro común (`merge-base`), rama huérfana, base vs compare en un PR, rama por defecto, merge commit con dos padres, etiqueta anotada (`tag -a`).
