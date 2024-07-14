package com.workshopmongodb.resources.util;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URLDecode {

    private static String text;

    public static String decodeParam(String text) {

        try {
            return URLDecoder.decode(text,"UTF8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}

