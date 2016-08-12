package lh.world.util;

import com.google.common.base.Strings;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by lh on 2016/8/10.
 */
public class EncrptUtil {
    public static String encodePassword(String password) {
        if (Strings.isNullOrEmpty(password)) {
            return null;
        } else {
            return new BCryptPasswordEncoder().encode(password);
        }
    }

    public static boolean matchesPassword(String rawPassword, String encodedPassword) {
        if (Strings.isNullOrEmpty(rawPassword) || Strings.isNullOrEmpty(encodedPassword)) {
            return false;
        } else {
            return new BCryptPasswordEncoder().matches(rawPassword, encodedPassword);
        }
    }
}
