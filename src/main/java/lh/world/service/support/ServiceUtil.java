package lh.world.service.support;

import com.google.common.base.Strings;
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

    public static String addPercent(String content) {
        if (!Strings.isNullOrEmpty(content)) {
            return "%" + content + "%";
        } else {
            return "";
        }
    }
}
