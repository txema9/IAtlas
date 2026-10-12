# Estado actual del proyecto

*Nota de traspaso entre sesiones. Claude Code la actualiza al cerrar cada sesión; tú puedes editarla cuando quieras. Mantenla corta: solo el presente, la historia ya está en Git y en el diario.*

**Última actualización:** 12/10/2026
**Fase actual:** 0 · Preparación (casi terminada)
**Rama activa:** `chore/setup` (subida a GitHub, sincronizada con `origin/chore/setup`)

## Hecho en la última sesión
- Repo `IAtlas` creado en GitHub (`txema9/IAtlas`), remoto `origin` añadido y `chore/setup` subida con `git push -u`.
- El mensaje del commit ya está en inglés (`chore: initial project setup with docs`); el `--amend` pendiente quedó resuelto.
- Problema de historias sin relación: el primer `main` se creó huérfano (commit vacío) y no compartía ancestro con `chore/setup`, así que GitHub no permitía el PR. Se arregló borrando ese `main` (local y remoto) y publicando el commit inicial como `main`: `git push origin 5a05d5a:refs/heads/main`. Verificado: `git merge-base origin/main chore/setup` devuelve `5a05d5a`.
- Estado de ramas en GitHub: `main` = `5a05d5a`, `chore/setup` = `c956af7` (un commit por delante: `docs: update project state`).
- Instalado `gh` (GitHub CLI 2.102.0) con winget en `C:\Program Files\GitHub CLI\`.

## A medias
- **La rama por defecto del repo en GitHub sigue siendo `chore/setup`** (al borrar `main`, GitHub la reasignó). Desde la web no se dejaba cambiar. `git remote show origin` aún dice `HEAD branch: chore/setup`.
- `gh` está instalado pero **no autenticado todavía**, y la terminal necesita reiniciarse para ver el `PATH` nuevo (si no, usar la ruta completa `& "C:\Program Files\GitHub CLI\gh.exe"`).
- El PR `chore/setup → main` **no está creado** todavía.

## Siguiente paso
1. En una terminal nueva: `gh --version`, `gh auth login` (GitHub.com → HTTPS → Yes → navegador).
2. Cambiar la default: `gh repo edit txema9/IAtlas --default-branch main` y comprobar con `git remote show origin` (debe poner `HEAD branch: main`). Lo ejecuta el usuario.
3. Crear el PR `chore/setup → main` (base: `main`), revisar *Files changed* juntos, y después merge. **No borrar `chore/setup` hasta que `main` sea la default.**
4. Etiqueta `v0.0.1` (cierra la Fase 0).
5. Marcar `[x]` en `docs/ROADMAP.md` las casillas de la Fase 0 ya hechas (proyecto, recorrido, emulador, `.gitignore`/repo en GitHub, docs, primer commit y push). Aún sin marcar.
6. Luego, Fase 1 (`feat/static-list`): `EntryCard` con `@Preview`.

## Dudas abiertas
- `dynamicColor = true` sigue activo en `Theme.kt`: la app usa los colores del sistema, no la paleta "Síntesis". Se desactiva en la Fase 8.
- Conceptos nuevos de Git para el `DIARIO.md` (si quieres): remoto/`origin`, `push -u` (upstream), ancestro común (`merge-base`), rama huérfana, base vs compare en un PR, rama por defecto.
