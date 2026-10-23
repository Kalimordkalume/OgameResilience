# 0003. Ramas: `main` y ramas cortas, sin `develop`

**Estado:** Aceptada. **Fecha:** 2026-10-23.

## Contexto

Se trabaja desde varios equipos y puede que entren otras personas. Hace falta una forma de organizar el trabajo que no
añada ceremonia a un proyecto pequeño.

## Decisión

- `main` siempre funciona: compila y, cuando existan, pasa los tests.
- Los cambios se hacen en ramas cortas con nombre `tipo/descripcion` (`feat/planificador`, `docs/handoff`) y se
  fusionan en `main`. Las ramas se borran al fusionarse.
- No hay rama `develop`.
- Mientras se trabaje en solitario, se puede hacer commit directamente en `main`. Cuando entre otra persona, las ramas
  cortas y los *pull request* pasan a ser obligatorios y se protege `main` en GitHub.
- No hay ramas especiales para cambios hechos por IA: el hábito de ramas `agent/` se descartó (ver `HANDOFF.md`).

## Consecuencias

- Hay una rama permanente menos que mantener y una fusión menos por cada cambio.
- No hay un sitio intermedio donde estabilizar varios cambios antes de publicarlos.
- Se reabre si hay versiones publicadas que mantener en paralelo, o si un equipo grande necesita una fase de
  estabilización.
- La numeración continúa la de `docs/decisions`: los números 0001 y 0002 los ocupan las notas de los pasos 2 y 3 de la
  guía, que aún no se han escrito.
