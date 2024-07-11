package com.example.context;

import java.util.List;

public interface SearchService {
    /**
     * Найти все классы в пакете, аннотированные @IntensiveComponent.
     *
     * @param packageName имя пакета для поиска.
     * @return список классов, аннотированных @IntensiveComponent.
     */
    List<Class<?>> findComponents(String packageName);
}
