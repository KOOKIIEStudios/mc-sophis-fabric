package hm.o.sph.util.function;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Property<T> implements Supplier<T>, Consumer<T> {
    private T val;

    private Property(T val) {
        this.val = val;
    }

    @Contract(value = "_ -> new", pure = true)
    public static <Type> @NotNull Property<Type> of(Type val) {
        return new Property<>(val);
    }

    @Override
    public void accept(T t) {
        val = t;
    }

    @Override
    public T get() {
        return val;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @NotNull
    @Override
    public Property<T> andThen(@NotNull Consumer<? super T> after) {
        Consumer.super.andThen(after);
        return this;
    }
}
