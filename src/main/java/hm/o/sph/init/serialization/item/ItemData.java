package hm.o.sph.init.serialization.item;

import hm.o.sph.init.item.ItemCategory;
import hm.o.sph.util.SophisRarity;

import java.util.Set;

public class ItemData {
    private String id;
    private ItemCategory category;
    private SophisRarity rarity;

    private ItemData() {
    }

    public static class BasicSerialization {
        private String id;
        private ItemCategory category;
        private SophisRarity rarity;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public ItemCategory getCategory() {
            return category;
        }

        public void setCategory(ItemCategory category) {
            this.category = category;
        }

        public SophisRarity getRarity() {
            return rarity;
        }

        public void setRarity(SophisRarity rarity) {
            this.rarity = rarity;
        }
    }

    public static class MaterialSerialization {
        private BasicSerialization base;
        private int credit;

        public BasicSerialization getBase() {
            return base;
        }

        public void setBase(BasicSerialization base) {
            this.base = base;
        }

        public int getCredit() {
            return credit;
        }

        public void setCredit(int credit) {
            this.credit = credit;
        }
    }

    public static class EquipmentSerialization {
        private BasicSerialization base;
        private int credit;
        private Set<String> attributes;
        private Set<String> imprints;

        public BasicSerialization getBase() {
            return base;
        }

        public void setBase(BasicSerialization base) {
            this.base = base;
        }

        public int getCredit() {
            return credit;
        }

        public void setCredit(int credit) {
            this.credit = credit;
        }

        public Set<String> getAttributes() {
            return attributes;
        }

        public void setAttributes(Set<String> attributes) {
            this.attributes = attributes;
        }

        public Set<String> getImprints() {
            return imprints;
        }

        public void setImprints(Set<String> imprints) {
            this.imprints = imprints;
        }
    }
}