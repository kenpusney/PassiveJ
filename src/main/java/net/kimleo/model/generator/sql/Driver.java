package net.kimleo.model.generator.sql;

import net.kimleo.model.components.Component;
import net.kimleo.model.generator.Generator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface Driver extends Generator {
    @Override
    default String gen(Component component) {
        Method method = resolveMethodFor(component.getClass());
        if (method != null) {
            try {
                return (String) method.invoke(this, component);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    default Method resolveMethodFor(Class<? extends Component> clz) {
        Method[] methods = this.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.getParameterCount() == 1 && method.getParameterTypes()[0].equals(clz)) {
                return method;
            }
        }
        return null;
    }
}
