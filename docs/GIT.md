# Guía de Git para este proyecto

## Flujo de trabajo

`main` siempre compila y funciona. Todo lo nuevo se hace en una rama aparte.

```bash
git switch main
git pull                             # traer lo último
git switch -c feat/static-list       # nueva rama
# ... trabajar, commits pequeños ...
git push -u origin feat/static-list  # subir la rama
```

Luego, en GitHub: **Pull Request** → revisar los cambios (puedes pedirle a Claude que los revise) → **Merge** → borrar la rama.

> Aunque trabajes sola/o, usar PRs deja un historial ordenado que las empresas sí miran.

## Nombres de rama

| Prefijo | Para qué |
|---|---|
| `feat/` | Funcionalidad nueva |
| `fix/` | Corrección de error |
| `docs/` | Solo documentación |
| `refactor/` | Reorganizar código sin cambiar lo que hace |
| `test/` | Tests |
| `chore/` | Configuración, dependencias, mantenimiento |

## Mensajes de commit (Conventional Commits)

Formato: `tipo(ámbito): descripción en imperativo` — en inglés y en minúscula.

```
feat(list): add EntryCard composable with preview
fix(room): prevent crash when category is deleted
docs(readme): add screenshots
refactor(ui): extract FilterChips into its own file
test(dao): add tests for EntryDao queries
chore: update Compose BOM
```

**Reglas prácticas**
- Un commit = un cambio con sentido. Si necesitas "y" para describirlo, probablemente son dos.
- Haz commit cuando algo funciona, aunque sea pequeño.
- Nunca subas claves, contraseñas ni `local.properties`.

## Versiones y releases

Usamos versionado semántico: `MAYOR.MENOR.PARCHE` (`v0.3.0`, `v1.0.0`).

```bash
git tag -a v0.1.0 -m "Static list UI"
git push origin v0.1.0
```

En GitHub → *Releases* → crear release desde la etiqueta y adjuntar el APK.

## Comandos de rescate

```bash
git status                     # ¿qué ha cambiado?
git log --oneline --graph      # historial visual
git diff                       # ver cambios sin guardar
git restore archivo.kt         # descartar cambios de un archivo
git commit --amend             # corregir el último commit (solo si NO lo has subido)
git stash / git stash pop      # guardar cambios temporalmente
```
