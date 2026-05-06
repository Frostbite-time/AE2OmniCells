---
navigation:
  parent: index.md
  title: Type Fuzzy Card
  icon: ae2omnicells:type_fuzzy_card
  position: 30
item_ids:
  - type_fuzzy_card
---

# Type Fuzzy Card

> Changes OMNI storage cell partitioning from matching specific resources to matching resource types.

<Row>
  <ItemImage id="type_fuzzy_card" scale="4" />
</Row>

## Purpose

The Type Fuzzy Card can be installed in this mod's OMNI, Complex OMNI, and Quantum storage cells, including their portable variants and creative storage cells.

Once installed, the cell partition only checks the AE type of each configured sample instead of matching the exact configured resource.

- Any configured item represents the item resource type.
- Any configured fluid represents the fluid resource type.
- Other AE resource types are handled the same way when they are configured as samples.

## Whitelist And Blacklist

- Default whitelist: only resources with the same type as the configured samples may enter.
- With an Inverter Card: the same type set becomes a blacklist, rejecting those resource types while allowing the rest.
- With an empty partition: the Type Fuzzy Card adds no extra restriction.

## Recipe

<RecipeFor id="type_fuzzy_card" />
