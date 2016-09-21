package me.demo.ooad.util;


import org.apache.commons.lang3.StringUtils;

import java.util.logging.Logger;

import static java.lang.String.format;

/**
 * Utilities class.
 *
 * Created by Think on 2016/8/31.
 */
public final class Utils {
    private static final Logger LOGGER = Logger.getLogger(Utils.class.getName());


    private Utils() {
    }

    public static void checkNotNull(final Object argument, final String argumentName) {
        if (argument == null || StringUtils.isEmpty((String) argument)) {
            throw new IllegalArgumentException(format("The %s must not be null or empty", argumentName));
        }
    }

}
