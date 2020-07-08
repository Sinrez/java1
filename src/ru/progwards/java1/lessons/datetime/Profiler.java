package ru.progwards.java1.lessons.datetime;

import java.util.*;

//Реализовать класс для ручной профилировки производительности программного кода

enum TimeMeasureUnits {MILLISECONDS, NANOSECONDS};

class StatisticInfo implements Comparable {
    public String sectionName; // имя секции
    public int fullTime = 0; // полное время выполнения секции в миллисекундах
    public int selfTime = 0; // чистое время выполнения секции в миллисекундах
    public int count = 0; // количество вызовов

    boolean isRun; // выполняется ли секция
    private TimeMeasureUnits timeMeasureUnits; // единицы измерения времени
    private long runStartTime; // время начала
    private List<Insider> runInside; // кто запущен внутри


    StatisticInfo(String sectionName, TimeMeasureUnits timeMeasureUnits) {
        this.sectionName = sectionName;
        this.timeMeasureUnits = timeMeasureUnits;
        runInside = new ArrayList<Insider>();
    }

    // текущее время
    long getTimeNow() {
        switch (timeMeasureUnits) {
            case NANOSECONDS:
                return System.nanoTime();
            default:
                return System.currentTimeMillis();
        }
    }

    // вход в секцию
    void enter() {
        count++;
        if (!isRun) {
            isRun = true;
            runStartTime = getTimeNow();
        }
    }

    // выход из секции
    void exit() {
        if (!isRun) return;
        long timeNow = getTimeNow();
        int newFullTime = fullTime + (int) (timeNow - runStartTime);
        int newSelfTime = actualSelfTime(timeNow);
        runInside.clear();
        isRun = false;
        fullTime = newFullTime;
        selfTime = newSelfTime;
    }

    // собственное время, без подсекций
    int actualSelfTime(long timeNow) {
        if (!isRun) return selfTime;
        int result = selfTime + (int) (timeNow - runStartTime);
        for (Insider i : runInside) {
            result -= i.getInsideTime(timeNow);
        }
        return result;
    }

    // добавить внутреннюю секцию
    void addInsider(StatisticInfo info) {
        if (isRun) {
            runInside.add(new Insider(info, getTimeNow()));
        }
    }

    // удалить внутреннюю секцию
    void removeInsider(StatisticInfo info) {
        if (isRun) {
            long timeNow = getTimeNow();
            ListIterator i = runInside.listIterator();
            while (i.hasNext()) {
                Insider insider = (Insider) i.next();
                if (insider.info == info) {
                    selfTime -= insider.getInsideTime(timeNow);
                    i.remove();
                }
            }
        }
    }

    @Override
    public String toString() {
        return "\n" + sectionName + " total:" + fullTime + " self:" + selfTime + " count:" + count;
    }

    // для сортировки в TreeMap
    @Override
    public int compareTo(Object o) {
        return this.sectionName.compareTo(((StatisticInfo) o).sectionName);
    }
}

class Insider {
    public int selfTime; // чистое время связянной секции на момент создания связи
    StatisticInfo info; // секция, с которой связь

    Insider(StatisticInfo info, long timeNow) {
        this.info = info;
        selfTime = info.actualSelfTime(timeNow);
    }

    int getInsideTime(long timeNow) {
        return info.actualSelfTime(timeNow) - selfTime;
    }
}

public class Profiler {

    static TimeMeasureUnits timeMeasureUnits = TimeMeasureUnits.MILLISECONDS;
    static TreeMap<String, StatisticInfo> sections = new TreeMap<String, StatisticInfo>();

    // войти в профилировочную секцию
    public static void enterSection(String name) {
        StatisticInfo section;
        if (sections.containsKey(name)) {
            section = sections.get(name);
        } else {
            section = new StatisticInfo(name, timeMeasureUnits);
            sections.put(name, section);
        }
        if (!section.isRun) {
            for (StatisticInfo i : sections.values()) i.addInsider(section);
        }
        section.enter();
    }

    // выйти из профилировочной секции
    public static void exitSection(String name) {
        StatisticInfo section = sections.get(name);
        section.exit();
        if (!section.isRun) {
            for (StatisticInfo i : sections.values()) i.removeInsider(section);
        }
    }

    // обнулить статистику
    public static void clear() {
        sections.clear();
    }

    // получить профилировочную статистику, отсортировать по наименованию секции
    public static List<StatisticInfo> getStatisticInfo() {
        return new ArrayList<StatisticInfo>(sections.values());
    }

    public static String getSectionsInfo() {
        return sections.values().toString();
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
        }
    }

    public static void main(String[] args) {
        enterSection("s1");
        sleep(100);
        enterSection("s2");
        sleep(200);
        exitSection("s2");
        enterSection("s2");
        sleep(200);
        exitSection("s2");
        enterSection("s2");
        sleep(200);
        exitSection("s2");
        sleep(100);
        exitSection("s1");
        System.out.println(getSectionsInfo());
    }
}
