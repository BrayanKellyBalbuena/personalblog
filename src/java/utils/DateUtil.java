/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author script-dark
 */
public class DateUtil {
    
    public static LocalDateTime stringToLocalDateTime(String dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        return LocalDateTime.parse(dateTime, formatter);
    }
    
    public static String localDateTimeToString(LocalDateTime localDateTime){
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
         return localDateTime.format(formatter);
    }
}
