package dao;

import java.sql.Date;

public class Converter {
    public static Date utilToSqlConverter(java.util.Date date) {
        Date sqlDate = new Date(date.getTime());
        return sqlDate;
    }
}
