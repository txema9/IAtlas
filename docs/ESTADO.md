# Estado actual del proyecto

*Nota de traspaso entre sesiones. Claude Code la actualiza al cerrar cada sesión; tú puedes editarla cuando quieras. Mantenla corta: solo el presente, la historia ya está en Git y en el diario.*

**Última actualización:** 11/10/2026
**Fase actual:** 0 · Preparación (casi terminada)
**Rama activa:** `chore/setup` (1 commit local, **sin subir todavía**)

## Hecho en la última sesión
- **Recorrido guiado completado** (no repetir): `MainActivity.kt`, `ui/theme` (Color, Type, Theme), `AndroidManifest.xml` y Gradle (`settings`, `build` raíz, `app/build.gradle.kts`, `libs.versions.toml`). Se explicó cada uno con su equivalente en Java y se respondieron las preguntas de comprobación.
- Conceptos ya vistos: `@Composable`, `Modifier` y valores por defecto, `Scaffold` e `innerPadding`, `IAtlasTheme`/`MaterialTheme`, `dynamicColor`, recursos `@string/`, `intent-filter` MAIN/LAUNCHER, `namespace` vs `applicationId`, `minSdk`, BOM, catálogo `.toml`.
- Primer cambio en `Greeting` hecho por ti (texto cambiado y visto en la Preview).
- Emulador creado y app ejecutada por primera vez: funciona.
- `.gitignore` revisado: correcto, no se cuela `build/`, `.idea/` ni `local.properties`.
- `git init -b main`, rama `chore/setup` y primer commit (`1057db9`). Correo de Git (`jotaemepe23@gmail.com`) coincide con el de GitHub.

## A medias
- El mensaje del commit quedó en español (`chore: configuración inicial del proyecto con docs`). `GIT.md` pide inglés. Corregir **antes del push** con `git commit --amend -m "chore: initial project setup with docs"` (o decidir dejarlo y actualizar `GIT.md`).

## Siguiente paso
- **Crear el repo `IAtlas` en GitHub** (sin README, .gitignore ni licencia), añadir el remoto y subir:
  `git remote add origin <url>` y `git push -u origin chore/setup`.
- Después: PR de `chore/setup` a `main`, merge, y etiqueta `v0.0.1` (cierra la Fase 0).
- Marcar `[x]` en `docs/ROADMAP.md` las casillas de la Fase 0 ya hechas (proyecto, recorrido, emulador, `.gitignore`, docs, primer commit).
- Luego, Fase 1 (`feat/static-list`): `EntryCard` con `@Preview`.

## Dudas abiertas
- `dynamicColor = true` sigue activo en `Theme.kt`: la app usa los colores del sistema, no la paleta "Síntesis". Se desactiva en la Fase 8.
