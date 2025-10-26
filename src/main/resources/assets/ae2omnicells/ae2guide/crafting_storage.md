---
navigation:
  parent: index.md
  title: Crafting Storages
  icon: ae2omnicells:quantum_crafting_storage_256m_block
  position: 20
item_ids:
  - omni_crafting_unit_block
  - omni_crafting_monitor_block
  - omni_crafting_storage_1k_block
  - omni_crafting_storage_4k_block
  - omni_crafting_storage_16k_block
  - omni_crafting_storage_64k_block
  - omni_crafting_storage_256k_block
  - omni_crafting_storage_1m_block
  - omni_crafting_storage_4m_block
  - omni_crafting_storage_16m_block
  - omni_crafting_storage_64m_block
  - omni_crafting_storage_256m_block
  - complex_crafting_unit_block
  - complex_crafting_monitor_block
  - complex_crafting_storage_1k_block
  - complex_crafting_storage_4k_block
  - complex_crafting_storage_16k_block
  - complex_crafting_storage_64k_block
  - complex_crafting_storage_256k_block
  - complex_crafting_storage_1m_block
  - complex_crafting_storage_4m_block
  - complex_crafting_storage_16m_block
  - complex_crafting_storage_64m_block
  - complex_crafting_storage_256m_block
  - quantum_crafting_unit_block
  - quantum_crafting_monitor_block
  - quantum_crafting_storage_1k_block
  - quantum_crafting_storage_4k_block
  - quantum_crafting_storage_16k_block
  - quantum_crafting_storage_64k_block
  - quantum_crafting_storage_256k_block
  - quantum_crafting_storage_1m_block
  - quantum_crafting_storage_4m_block
  - quantum_crafting_storage_16m_block
  - quantum_crafting_storage_64m_block
  - quantum_crafting_storage_256m_block
---

# Crafting Storages

> All three OMNI series (Omni / Complex Omni / Quantum) provide their corresponding **Crafting Storage blocks**.

They function the same as AE2’s original crafting storages — providing the crafting network with **available storage capacity** and **processors**.  
Each crafting storage automatically gains a certain number of **processors** based on its capacity, and all processors parameters can be customized via the configuration file.

---

## Omni Crafting Storage Units
<Row>
  <BlockImage id="omni_crafting_storage_1k_block" scale="3" />
  <BlockImage id="omni_crafting_storage_16k_block" scale="3" />
  <BlockImage id="omni_crafting_storage_256m_block" scale="3" />
</Row>

| Capacity | Co-Processors (Default) |
|:--------:|------------------------:|
|    1k    |                       4 |
|    4k    |                       4 |
|   16k    |                       4 |
|   64k    |                       4 |
|   256k   |                       4 |
|    1m    |                       8 |
|    4m    |                       8 |
|   16m    |                       8 |
|   64m    |                       8 |
|   256m   |                       8 |

---

## Complex Omni Crafting Storage Units
<Row>
  <BlockImage id="complex_crafting_storage_1k_block" scale="3" />
  <BlockImage id="complex_crafting_storage_16m_block" scale="3" />
  <BlockImage id="complex_crafting_storage_256m_block" scale="3" />
</Row>

This series of crafting storages **increases its processors count as capacity scales up**.

| Capacity | Co-Processors (Default) |
|:--------:|------------------------:|
|    1k    |                       0 |
|    4k    |                       1 |
|   16k    |                       2 |
|   64k    |                       4 |
|   256k   |                       8 |
|    1m    |                      16 |
|    4m    |                      32 |
|   16m    |                      64 |
|   64m    |                     128 |
|   256m   |                     256 |

---

## Quantum Crafting Storage Units
<Row>
  <BlockImage id="quantum_crafting_storage_1k_block" scale="3" />
  <BlockImage id="quantum_crafting_storage_16m_block" scale="3" />
  <BlockImage id="quantum_crafting_storage_256m_block" scale="3" />
</Row>

| Capacity | Co-Processors (Default) |
|:--------:|------------------------:|
|    1k    |                     512 |
|    4k    |                     512 |
|   16k    |                    1024 |
|   64k    |                    1024 |
|   256k   |                    2048 |
|    1m    |                    2048 |
|    4m    |                    4096 |
|   16m    |                    4096 |
|   64m    |                    8192 |
|   256m   |                    8192 |

---

## Configuration and Adjustment
The tables above show the **default configuration values**.  
All crafting unit processors counts can be adjusted through the configuration file (`omni_coprocessor_xxx`, `complex_coprocessor_xxx`, `quantum_coprocessor_xxx`).

> Changes require a game restart to take effect.