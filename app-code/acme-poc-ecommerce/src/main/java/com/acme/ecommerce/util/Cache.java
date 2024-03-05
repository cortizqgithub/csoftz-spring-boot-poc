/*----------------------------------------------------------------------------*/
/* Source File:   CACHE.JAVA                                                  */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache<K, V> extends ConcurrentHashMap<K, V> {

    @Override
    public V put(K key, V value) {
        return super.put(key, value);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        super.putAll(m);
    }
}
