# Diario de aprendizaje

Una entrada por sesión o por concepto nuevo. Sirve para repasar y para preparar entrevistas ("¿qué fue lo más difícil?").

## Plantilla

### AAAA-MM-DD · Título
**Fase:** 
**Qué hice:** 
**Concepto nuevo:** 
**Comparación con Java:** 
**Dudas / problemas y cómo los resolví:** 

---

## Glosario rápido Kotlin ⇄ Java

| Kotlin | Equivalente en Java | Nota |
|---|---|---|
| `val` | `final` | Inmutable (referencia) |
| `var` | variable normal | |
| `String?` | cualquier referencia | Kotlin obliga a gestionar el null |
| `data class` | POJO con equals/hashCode/toString | Una línea en vez de 40 |
| `fun f() = x` | método con `return x` | Función de una expresión |
| `listOf()` / `mutableListOf()` | `List.of()` / `ArrayList` | Por defecto, inmutables |
| `when` | `switch` | Más potente, devuelve valor |
| lambdas `{ x -> ... }` | lambdas `x -> ...` | |

---

<!-- Tus entradas empiezan aquí -->

### 2026-10-12 · Primer flujo completo de Git y GitHub
**Fase:** 0 · Preparación (cierre) y arranque de la Fase 1
**Qué hice:** publiqué el repo en GitHub, arreglé un historial sin ancestro común, abrí y fusioné dos Pull Requests, puse la etiqueta `v0.0.1`, cambié la rama por defecto a `main` y borré las ramas ya fusionadas.

**Conceptos nuevos (con el ejemplo real de IAtlas):**

| Concepto | Qué es | Ejemplo en IAtlas |
|---|---|---|
| Remoto / `origin` | Nombre corto de la URL del repo en GitHub | `origin` = `https://github.com/txema9/IAtlas.git` |
| `push -u` (upstream) | Sube la rama y enlaza la local con la remota, para que luego `git push` y `git pull` sepan adónde ir | `git push -u origin feat/static-list` |
| Ancestro común | Último commit que comparten dos ramas. `git merge-base A B` lo muestra | `5a05d5a` era el ancestro de `main` y `chore/setup` |
| Rama huérfana | Rama cuyo primer commit no tiene padre: su historia no está conectada con otra | Mi primer `main` era un commit vacío aparte, y GitHub no dejaba abrir el PR |
| Base vs compare | En un PR, la **base** es la rama que recibe los cambios y **compare** la que los trae | PR #1: base `main`, compare `chore/setup` |
| Rama por defecto | Rama que GitHub muestra y usa como base de los PR | Cambiada a `main` con `gh repo edit ... --default-branch main` |
| Pull Request | Petición para incorporar una rama a otra, con revisión previa | PR #1 (`chore/setup`) y PR #2 (`docs/phase0-done`) |
| Merge commit | Commit con **dos padres** que une dos historias. En `git log --graph` se ve como `\|\` y `\|/` | `6697df3` y `045998c` |
| Etiqueta anotada | Marcador **fijo** en un commit, con autor, fecha y mensaje. Una rama avanza, una etiqueta no | `git tag -a v0.0.1 6697df3 -m "Phase 0: project setup"` |
| Staging (`git add`) | Zona intermedia: eliges qué entra en el próximo commit | Android Studio hizo `git add` de `EntryCard.kt` al crearlo (`A` en `git status`) |
| Borrar ramas | `-d` borra solo si está fusionada (seguro); `-D` fuerza. El remoto se borra aparte | `git branch -d ...` y `git push origin --delete ...` |

**Los tres sitios donde vive un cambio:** directorio de trabajo → *staging* → repositorio (commit). Y luego local → remoto (`push`).

**Comparación con Java:** un PR se parece a enseñar un cambio a un compañero antes de meterlo en el código común. Una etiqueta se parece a una constante `final`: un nombre que siempre apunta al mismo sitio.

**Dudas / problemas y cómo los resolví:**
- *GitHub no dejaba abrir el PR.* Causa: `main` huérfano, sin ancestro común con `chore/setup`. Solución: borrar ese `main` y publicar el commit inicial como `main` (`git push origin 5a05d5a:refs/heads/main`). Comprobación: `git merge-base origin/main chore/setup` devolvió `5a05d5a`.
- *La rama por defecto se quedó en `chore/setup`* al borrar `main`. Solución: `gh repo edit ... --default-branch main`. Regla: **no borrar una rama mientras sea la por defecto**.
- *Mi rama nueva seguía enlazada a `origin/main`* (la creé con `git switch -c rama origin/main`). Con eso un `git push` simple se niega; la primera vez hay que usar `git push -u origin nombre-de-la-rama`.
- *`origin/HEAD` seguía apuntando a la rama vieja* (copia local en caché). Se refresca con `git remote set-head origin -a`.

**Chuleta de comandos usados:**
```
git status -sb                        # estado corto + rama y upstream
git log --oneline --graph --all       # historia como grafo
git merge-base A B                    # ancestro común de dos ramas
git switch -c nueva origin/main       # crear rama desde main remoto
git push -u origin nueva              # primera subida, con upstream
git tag -a v0.0.1 <commit> -m "..."   # etiqueta anotada
git push origin v0.0.1                # publicar la etiqueta
git branch -d rama                    # borrar rama fusionada (local)
git push origin --delete rama         # borrar rama en GitHub
git fetch --prune                     # limpiar ramas remotas que ya no existen
gh pr create / gh pr merge            # PR desde la terminal
```
