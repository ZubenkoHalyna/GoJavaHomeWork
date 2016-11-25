package module5;

/**
 * Created by g.zubenko on 23.11.2016.
 */

@FunctionalInterface
public interface Selector<T>{
        boolean check(T item);
}

