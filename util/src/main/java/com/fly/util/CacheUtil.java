package com.fly.util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * Created by lixfn on 14-11-19.
 */
public class CacheUtil {

    private static Cache getCache(CacheType cacheType) {
        CacheManager manager = CacheManager.getInstance();
        Cache cache = null;
        if (manager == null) {
            manager = CacheManager.create();
        }
        //System.out.println(manager.getDiskStorePath());
        cache = manager.getCache(cacheType.name());

        if (cache == null) {
            cache = new Cache(cacheType.name(), 0, false, false, 10800, 10800);
            manager.addCache(cache);
        }
        return cache;
    }


    public enum CacheType {
        Goods,
        Customer,
        CfApiCaller,
        EnumValues,
        EnumTypes,
        Ordertypes,
        Company,
        BaSystem,
        BaSupplier,
        JobExcuteBean,
        BaManager,
        BaEnumType,
        BaEnumValues,
        BaPlatform,
        BaMenu,
        BaLinkman,
        BaShop
    }

    public static void set(CacheType cacheType, String key, Object data) {
        Cache cache = getCache(cacheType);
        cache.put(new Element(key, data));
    }


    public static <T extends Object> T get(CacheType cacheType, String key) {
        Cache cache = getCache(cacheType);
        Element element = cache.get(key);
        if (element == null) {
            return null;
        } else {
            return (T) element.getObjectValue();
        }
    }


    public static void remove(CacheType cacheType) {
        Cache cache = getCache(cacheType);
        cache.removeAll();
    }

    public static void remove(CacheType cacheType, String key) {
        Cache cache = getCache(cacheType);
        cache.remove(key);
    }

    public static void remove() {
        CacheManager manager = CacheManager.getInstance();
        if (manager != null) {
            manager.removalAll();
        }
    }
}
