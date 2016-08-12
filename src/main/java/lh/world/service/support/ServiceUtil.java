package lh.world.service.support;

import lh.world.domain.support.CanLogicDelDomain;

/**
 * Created by lh on 2016/8/12.
 */
public class ServiceUtil {
    public static boolean isCanLogicDel(Object entity) {
        return (entity instanceof CanLogicDelDomain);
    }

    public static boolean isCanLogicDel(Class<?> clazz) {
        return CanLogicDelDomain.class.isAssignableFrom(clazz);
    }
}
