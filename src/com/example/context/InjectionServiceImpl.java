package com.example.context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InjectionServiceImpl implements InjectionService {
    private final SearchService searchService;
    private final DependencyFactory dependencyFactory;
    private final Map<Class<?>, Object> instances = new HashMap<>();

    public InjectionServiceImpl(SearchService searchService, DependencyFactory dependencyFactory) {
        this.searchService = searchService;
        this.dependencyFactory = dependencyFactory;
    }

    @Override
    public <T> T inject(Class<T> type) {
        if (instances.containsKey(type)) {
            return type.cast(instances.get(type));
        }

        List<Class<?>> components = searchService.findComponents(type.getPackage().getName());
        for (Class<?> component : components) {
            if (type.isAssignableFrom(component)) {
                T instance = dependencyFactory.createInstance(component.asSubclass(type));
                instances.put(type, instance);
                return instance;
            }
        }
        throw new RuntimeException("Не найден компонент: " + type.getName());
    }
}
