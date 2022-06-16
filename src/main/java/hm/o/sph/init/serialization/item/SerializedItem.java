package hm.o.sph.init.serialization.item;

import net.minecraft.item.Item;

import java.io.Serializable;

public interface SerializedItem<T extends Item> extends Serializable {
    T register();

}
