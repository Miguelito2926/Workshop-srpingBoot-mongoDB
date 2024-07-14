package com.workshopmongodb.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URLDecode {

    public static String decodeParam(String text) {
        // Decodifica um parâmetro de URL usando UTF-8
        try {
            return URLDecoder.decode(text, "UTF8");
        } catch (UnsupportedEncodingException e) {
            // Retorna uma string vazia em caso de exceção
            return "";
        }
    }

    public static Date convertDate(String textDate, Date defaultValue) {
        // Cria um SimpleDateFormat para converter string em data
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // Define o fuso horário como GMT
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            // Tenta converter a string em data
            return sdf.parse(textDate);
        } catch (ParseException e) {
            // Retorna um valor padrão em caso de exceção
            return defaultValue;
        }
    }
}
