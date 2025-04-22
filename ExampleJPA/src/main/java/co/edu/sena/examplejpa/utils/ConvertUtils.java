/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;


/**
 *
 * @author Nicolle
 */
public class ConvertUtils {
    
    public static String dateToString(Date date)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String result = dateFormat.format(date);
        return result;
    }
    
    public static Date stringToDate(String text) throws ParseException
    {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(text);
        return date;
    }
    
    /**
     * convierte una hora en string
     * @param date
     * @return
     */
    
    public static String timeToString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String result = dateFormat.format(date);
        return result;
    }
    
    
    /**
     * convierte un string en una hora
     * @param text
     * @return
     * @throws ParseExecption
     */
    
    public static Date stringToTime(String text) throws ParseException
    {
        Date date = new SimpleDateFormat("HH:mm").parse(text);
        return date;
    }
    
    /**
     * convertir de LocalDate a Date
     * @param LocalDate
     * @return
     */
    
    public static Date localDateToDate(LocalDate localDate)
    {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    
    
    /**
     * convertir de localTime a Date
     * @param localTime
     * @return
     */
    
    public static Date locaTimeToDate(LocalTime localTime)
    {
        return Date.from(LocalDate.now().atTime(localTime).atZone(ZoneId.systemDefault()).toInstant());
    }
    
    
    /**
     * convertir de Date a localTime 
     * @param date
     * @return
     */
    
    public static LocalDate dateToLocalDate(Date date)
    {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
