---
navigation:
  parent: index.md
  title: 合成存储器
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

# 合成存储器

> OMNI 存储元件的三大系列（全能 / 复杂全能 / 量子）都提供了对应的**合成存储器方块**。

它们与 AE2 原版合成存储器功能一致：为合成网络提供**可用存储空间**与**并行处理能力**。  
每个合成存储器都会根据其容量自动获得一部分**并行处理单元**，所有并行参数都可在配置文件中自定义。

---

## 全能合成存储单元
<Row>
  <BlockImage id="omni_crafting_storage_1k_block" scale="3" />
  <BlockImage id="omni_crafting_storage_16k_block" scale="3" />
  <BlockImage id="omni_crafting_storage_256m_block" scale="3" />
</Row>

|  容量  | 并行处理单元（默认） |
|:----:|-----------:|
|  1k  |          4 |
|  4k  |          4 |
| 16k  |          4 |
| 64k  |          4 |
| 256k |          4 |
|  1m  |          8 |
|  4m  |          8 |
| 16m  |          8 |
| 64m  |          8 |
| 256m |          8 |

---

## 复杂全能合成存储单元
<Row>
  <BlockImage id="complex_crafting_storage_1k_block" scale="3" />
  <BlockImage id="complex_crafting_storage_16m_block" scale="3" />
  <BlockImage id="complex_crafting_storage_256m_block" scale="3" />
</Row>

此系列的合成存储器在**容量提升时并行数同步提高**。

|  容量  | 并行处理单元（默认） |
|:----:|-----------:|
|  1k  |          0 |
|  4k  |          1 |
| 16k  |          2 |
| 64k  |          4 |
| 256k |          8 |
|  1m  |         16 |
|  4m  |         32 |
| 16m  |         64 |
| 64m  |        128 |
| 256m |        256 |

---

## 量子合成存储单元
<Row>
  <BlockImage id="quantum_crafting_storage_1k_block" scale="3" />
  <BlockImage id="quantum_crafting_storage_16m_block" scale="3" />
  <BlockImage id="quantum_crafting_storage_256m_block" scale="3" />
</Row>

|  容量  | 并行处理单元（默认） |
|:----:|-----------:|
|  1k  |        512 |
|  4k  |        512 |
| 16k  |       1024 |
| 64k  |       1024 |
| 256k |       2048 |
|  1m  |       2048 |
|  4m  |       4096 |
| 16m  |       4096 |
| 64m  |       8192 |
| 256m |       8192 |

---

## 配置与调节
以上表格为默认配置值。  
所有合成单元并行数均可通过配置文件（`omni_coprocessor_xxx`、`complex_coprocessor_xxx`、`quantum_coprocessor_xxx`）进行调整：

> 修改后必须重启游戏生效。