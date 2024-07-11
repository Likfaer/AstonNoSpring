package com.example.context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Класс контекста для управления зависимостями.
 */
public class IntensiveContext {
    private final String packageName;
    private final Map<Class<?>, Object> instanceCache = new ConcurrentHashMap<>();
    private final InjectionService injectionService;

    public IntensiveContext(String packageName) {
        this.packageName = packageName;
        SearchService searchService = new SearchServiceImpl();
        DependencyFactory dependencyFactory = new DependencyFactoryImpl(null);
        this.injectionService = new InjectionServiceImpl(searchService, dependencyFactory);
    }

    /**
     * Получить объект заданного типа.
     *
     * @param type тип объекта.
     * @param <T> тип класса.
     * @return экземпляр объекта заданного типа.
     */
    public <T> T getObject(Class<T> type) {
        return injectionService.inject(type);
    }
}
