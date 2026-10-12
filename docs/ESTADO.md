# Estado actual del proyecto

*Nota de traspaso entre sesiones. Claude Code la actualiza al cerrar cada sesión; tú puedes editarla cuando quieras. Mantenla corta: solo el presente, la historia ya está en Git y en el diario.*

**Última actualización:** 12/10/2026
**Fase actual:** 0 · Preparación (casi terminada)
**Rama activa:** `chore/setup` (PR #1 abierto hacia `main`)

## Hecho en la última sesión
- `gh` autenticado como `txema9` (HTTPS, permisos `repo`, `read:org`, `gist`).
- Rama por defecto del repo cambiada a `main` con `gh repo edit txema9/IAtlas --default-branch main`. Verificado: `git remote show origin` dice `HEAD branch: main`.
- PR #1 `chore/setup → main` creado (solo cambia `docs/ESTADO.md`).
- Claude Desktop conectado a la carpeta del proyecto con el servidor MCP de archivos (`server-filesystem`, solo lectura/escritura en `IAtlas`). Se activa por chat desde el `+` → Conectores. Copia de la config original en `%APPDATA%\Claude\claude_desktop_config.json.bak`.
- Idea en marcha: pedir a Claude Desktop un PDF de repaso de Git con ejemplos reales del proyecto. Necesita antes el material en `docs/DIARIO.md` (Claude Desktop no ejecuta `git log`).

## A medias
- El PR #1 está abierto y **sin fusionar**.
- `docs/DIARIO.md` aún no tiene los conceptos de Git de abajo.

## Siguiente paso
1. Revisar *Files changed* del PR #1 y fusionarlo (merge normal). **No borrar `chore/setup` hasta después del merge.**
2. Etiqueta `v0.0.1` (cierra la Fase 0).
3. Marcar `[x]` en `docs/ROADMAP.md` las casillas de la Fase 0 ya hechas (proyecto, recorrido, emulador, `.gitignore`/repo en GitHub, docs, primer commit y push). Aún sin marcar.
4. Rellenar `docs/DIARIO.md` con los conceptos de Git (esqueleto con ejemplos reales; tú redactas) y luego pedir el PDF a Claude Desktop.
5. Luego, Fase 1 (`feat/static-list`): `EntryCard` con `@Preview`.

## Dudas abiertas
- `dynamicColor = true` sigue activo en `Theme.kt`: la app usa los colores del sistema, no la paleta "Síntesis". Se desactiva en la Fase 8.
- Conceptos de Git para el `DIARIO.md`: remoto/`origin`, `push -u` (upstream), ancestro común (`merge-base`), rama huérfana, base vs compare en un PR, rama por defecto.
