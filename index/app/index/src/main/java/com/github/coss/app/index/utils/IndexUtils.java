package com.github.coss.app.index.utils;

public class IndexUtils {
    /**
     * 根据userId获取表名
     * @param userId
     * @param tablePrefix
     * @return
     */
    public static String getTableNameByUserId(String tablePrefix, long userId) {
        if (userId == 0)
            return tablePrefix;
        if (userId < 100)
            userId = 100 + userId;
        String uid = String.valueOf(userId);
        uid = uid.substring(uid.length() - 2, uid.length());
        return String.format(tablePrefix + "_%s", uid);
    }

    /**
     * 根据表编号获得表名
     * @param tablePrefix
     * @param tableNum
     * @return
     */
    public static String getTableNameByTableNum(String tablePrefix, Integer tableNum) {
        if (tableNum == null || tableNum < 0) {
            return tablePrefix;
        }
        if (tableNum < 10) {
            return String.format(tablePrefix + "_%s", "0" + tableNum);
        } else {
            return String.format(tablePrefix + "_%s", tableNum);
        }
    }

}
