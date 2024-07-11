package com.example.context;

import java.lang.reflect.Field;

public class DependencyFactoryImpl implements DependencyFactory {
    private final InjectionService injectionService;

    public DependencyFactoryImpl(InjectionService injectionService) {
        this.injectionService = injectionService;
    }

    @Override
    public <T> T createInstance(Class<T> type) {
        try {
            T instance = type.getDeclaredConstructor().newInstance();
            for (Field field : type.getDeclaredFields()) {
                if (field.isAnnotationPresent(IntensiveComponent.class)) {
                    field.setAccessible(true);
                    Object dependency = injectionService.inject(field.getType());
                    field.set(instance, dependency);
                }
            }
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Невозможно создать экземпляр класса: " + type.getName(), e);
        }
    }
}
