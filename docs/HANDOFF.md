# Handoff: ogame-planner

## Estado
- Último paso terminado: Paso 0 (2026-10-23)
- Tests: no aplica todavía, aún no hay código.
- Repositorio: github.com/Kalimordkalume/OgameResilience (público), `main` con la historia limpia desde el primer commit.

## Siguiente paso concreto
Paso 2 de la guía: decidir de dónde salen los datos del juego. Crear
`docs/decisions/0001-fuente-de-datos.md` y conseguir tres valores de tu cuenta.

## Decisiones tomadas
| Fecha | Decisión | Motivo |
| --- | --- | --- |
| 2026-10-20 | Repositorio propio y nuevo, público | Portfolio, historia limpia desde el primer commit |
| 2026-10-23 | Identidad de git por repositorio, en `.git/config`, con el correo noreply de GitHub | Menos piezas que mantener; el correo real no queda expuesto |
| 2026-10-23 | `main` y ramas cortas, sin `develop` (`docs/decisions/0003-ramas.md`) | Menos ceremonia; se reabre si hay versiones que mantener en paralelo |

## Identidad de git en un equipo nuevo
Antes del primer commit, comprueba con quién vas a firmar:

    git config --show-origin user.email

Debe salir tu identidad personal y no la global del equipo. Si no, defínela solo para este
repositorio con `git config --local user.name ...` y `git config --local user.email ...`
(en un repositorio público, mejor el correo noreply de GitHub). Si no se hace, git usa la
identidad global del equipo, sin avisar.

## Decisiones de hábitos
| Hábito | Estado | Motivo | Revisar |
| --- | --- | --- | --- |
| Commits con tipo | Adoptado | Un historial legible | |
| Handoff | Adoptado: este archivo | Retomar en dos minutos | |
| Ramas agent/ | Descartado | Prefieres menos carga | Cuando entre otra persona al repositorio |
| Cosecha a los 14 días | Descartado | Sin ramas agent/ no hay nada que cosechar | Si se acumulan ramas viejas |
| Autopush y autocommit | Descartado | Subes a mano | Si algún día pierdes trabajo por no haber subido |

## Riesgos aceptados
- Una IA puede escribir en `main` sin pasar por una rama aparte. Ya ocurrió una vez
  (el 2026-10-20, archivos en el repositorio antes de confirmar). Mitigación: revisar
  `git status` y `git log` al acabar cada sesión con IA.

## Bloqueos
Ninguno.
