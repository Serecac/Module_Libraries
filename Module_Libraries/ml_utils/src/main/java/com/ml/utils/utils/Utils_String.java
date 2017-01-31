package com.ml.utils.utils;

import java.util.Arrays;

/**
 * <p> Class Utils_String </p>
 * Utils about string
 *
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class Utils_String {

    /**
     * Create string from cloning 'n' times same char
     *
     * @param size the size
     * @param ch   the ch
     * @return the string
     */
    public static String stringFromCloningChar(int size, char ch){
        final char[] array = new char[size];
        Arrays.fill(array, ch);
        return new String(array);
    }
}
