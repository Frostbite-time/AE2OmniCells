# AE2 Omni Cells

![banner](https://i.imgur.com/4Qds3if.png)

**Language / 语言**: [简体中文](../README.md) | [English](./ENGLISH_README.md)

**AE2 Omni Cells** is centered on “a single cell that can mix all AE resource keys (items, fluids, etc.)”. It provides capacity tiers from **1k → 256m**, and defines three product lines (including portable variants) differentiated by the **maximum number of distinct types that can be stored simultaneously**. There is **no extra byte charge per type**; only a clear, predictable limit on the number of types.

---

## Features

* **Unified capacity tiers**: 1k / 4k / 16k / 64k / 256k / 1m / 4m / 16m / 64m / 256m
* **Mixed storage in a single cell**: one cell can hold multiple AE resource types (subject to the AE2 integrations of installed mods)
* **Controllable type cap**: only limits the number of distinct types stored simultaneously; no additional byte cost
* **Portable variants**: every capacity and every series has a corresponding portable omni unit
* **Data safety**: a “small NBT” strategy—items store only essential preview fields; actual storage data is written to an independent container to reduce NBT bloat risk
* **Complete crafting chain**: Ender Steel → Presses → Circuits → Processors → Components/Housings → Final cells (viewable in JEI/REI/EMI)

---

## Three Product Lines

| Series                | Max “types stored simultaneously”              | Recommended scenarios                                  |
| --------------------- | ---------------------------------------------- | ------------------------------------------------------ |
| **Universal**         | Fixed **63** types                             | Survival/regular play; small to mid-sized networks     |
| **Complex Universal** | Scales with capacity (e.g., 1k≈12 → 256m≈6400) | Progressive balancing; type cap grows with progression |
| **Quantum**           | **Unlimited**                                  | Late-game/endgame; consolidating extreme variety       |

> For the full **capacity ↔ type-cap** table of the Complex Universal series, see the documentation. Modpacks can stage recipes and costs accordingly.

---

## Crafting and Dependencies

* **Basic material**: craft **Ender Steel** first (can be further charged)
* **Presses**: Omni / Complex / Multidimensional Expansion (for the circuits that follow)
* **Circuits & Processors**: each series has its own circuits and processors as the core of component/cell recipes
* **Components / Housings / Final cells**: follow AE2’s recipe structure; refer to JEI/REI/EMI for authoritative listings

> If relevant extensions (e.g., EAE) are installed, some decorative blocks can also participate in circuit cutter recipes (as shown in JEI/REI/EMI).

---

## Data Storage

* All storage cells keep only a UUID plus a few client-side preview fields.
* The actual data for each cell is stored under the save folder at `data/ae_universal_cell_data`.
* Entries that cannot be read are **not** purged; each time you enter the world, the mod will attempt to read them again to accommodate changes in the mod environment.

---

## Feedback and Contributions

* **Issue reports**: please provide steps to reproduce, expected vs. actual behavior, and relevant logs/crash reports.
* **Feature/balance suggestions**: welcome in Issues; please include context and target scenarios.

---

## License

* **Code**: [LGPL-3.0](https://www.gnu.org/licenses/lgpl-3.0.html)
* **Textures & art assets**: [CC BY-NC-SA 3.0](https://creativecommons.org/licenses/by-nc-sa/3.0/)