package ru.progwards.java1.lessons.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;


public class Insurance {

    enum FormatStyle {SHORT, LONG, FULL} // стиль формата даты-времени // перенесено сюда для тестера

    ZonedDateTime start; // дата-время начала действия страховки
    Duration valid; // продолжительность действия

    // установить дату-время начала действия страховки
    public void setStart(ZonedDateTime start) {
        this.start = start;
    }

    Insurance() {
    }

    Insurance(ZonedDateTime start) {
        this.start = start;
    }

    Insurance(String strStart, FormatStyle style) {
        start = styledStringToZDT(strStart, style);
    }

    // найти дату-время по строке с заданным форматом
    private ZonedDateTime styledStringToZDT(String strStart, FormatStyle style) {
        DateTimeFormatter formatter;
        switch (style) {
            case SHORT:
                formatter = DateTimeFormatter.ISO_LOCAL_DATE;
                break;
            case LONG:
                formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                break;
            default:
                formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
                return ZonedDateTime.parse(strStart, formatter);
        }
        LocalDate date = LocalDate.parse(strStart, formatter);
        return date.atStartOfDay(ZoneId.systemDefault());
    }

    // установить продолжительность действия страховки
    public void setDuration(Duration duration) {
        valid = duration;
    }

    // установить продолжительность действия страховки, задав дату-время окончания
    public void setDuration(ZonedDateTime stop) {
        valid = Duration.between(start, stop);
    }

    public void setDuration(String durationStr, FormatStyle style) {
        //valid = Duration.between(start, styledStringToZDT(strStart, style));
        switch (style) {
            case SHORT: //целое число миллисекунд (тип long)
                valid = Duration.ofMillis(Integer.parseInt(durationStr));
                break;
            case LONG: //ISO_LOCAL_DATE_TIME - как период, например “0000-06-03T10:00:00” означает, что продолжительность действия страховки 0 лет, 6 месяцев, 3 дня 10 часов.
                //LocalDate date = LocalDate.parse(durationStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                //valid = Duration.ofMillis(date.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
                LocalDateTime date0 = LocalDateTime.parse("0000-01-01T00:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                LocalDateTime date1 = LocalDateTime.parse(durationStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME).plusMonths(1).plusDays(1);
                valid = Duration.between(date0, date1);
                break;
            default: //FULL - стандартный формат Duration, который получается через toString()
                valid = Duration.parse(durationStr);
        }
    }

    // установить продолжительность действия страховки, задав целыми числами количество месяцев, дней и часов
    public void setDuration(int mons, int days, int hrs) {
        ZonedDateTime ldt = start == null ? ZonedDateTime.now() : start;
        ldt = ldt.plusMonths(mons).plusDays(days).plusHours(hrs);
        valid = Duration.between(start, ldt);
    }

    // проверить валидна ли страховка на указанную дату-время
    public boolean checkValid(ZonedDateTime dateTime) {
        if (valid == null) return dateTime.isAfter(start);
        ZonedDateTime end = start.plusHours(valid.toHours());
        return dateTime.isAfter(start) && dateTime.isBefore(end);
    }

    // вернуть строку формата "Insurance "+start+" "+duration
    @Override
    public String toString() {
        return "Insurance issued on " + start + " is " + (checkValid(ZonedDateTime.now()) ? "" : "not ") + "valid";
    }

    public static void main(String[] args) {
        LocalDateTime date0 = LocalDateTime.parse("0000-01-01T00:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        LocalDateTime date1 = LocalDateTime.parse("0000-06-03T10:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME).plusMonths(1).plusDays(1);
        Duration valid = Duration.between(date0, date1);
        System.out.println(date0);
        System.out.println(date1);
        System.out.println(valid);
    }
}
