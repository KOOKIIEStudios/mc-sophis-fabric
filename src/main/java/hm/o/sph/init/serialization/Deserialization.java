package hm.o.sph.init.serialization;

public class Deserialization {

    public static class Item {
        public static class Material {
            private String id;
            private String category;
            private String rarity;
            private int credit;

            public int getCredit() {
                return credit;
            }

            public String getCategory() {
                return category;
            }

            public String getId() {
                return id;
            }

            public String getRarity() {
                return rarity;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public void setCredit(int credit) {
                this.credit = credit;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setRarity(String rarity) {
                this.rarity = rarity;
            }
        }

        public static class Equipment {
            public String id;
            public String category;
            public String rarity;
            public boolean disposable;
            public Attribute[] attrs;
            public int credit;

            public static class Attribute {
                public String id;
                public int min;
                public int max;
            }
        }
    }
}
