package com.example.context;

public interface DependencyFactory {
    /**
     * Создать экземпляр класса с инъекцией зависимостей.
     *
     * @param type класс, для которого нужно создать экземпляр.
     * @param <T> тип класса.
     * @return экземпляр класса с инъекцией зависимостей.
     */
    <T> T createInstance(Class<T> type);
}
