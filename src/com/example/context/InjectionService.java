package com.example.context;

public interface InjectionService {
    /**
     * Выполнить инъекцию зависимости для заданного типа.
     *
     * @param type тип для инъекции зависимости.
     * @param <T> тип класса.
     * @return экземпляр зависимости.
     */
    <T> T inject(Class<T> type);
}
