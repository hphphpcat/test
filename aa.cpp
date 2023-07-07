13:06// int get_days(int year, int month, int day) {
 我是孙庆安   // 验证日期是否合法
    if (year < 2000 || month < 1 || month > 12 || day < 1 || day > 31) {
        return -1;
    }
    // 每月的天数
    int daysInMonth[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    // 检查闰年
    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
        daysInMonth[1] = 29; // 闰年二月有29天
    }
    int days = 0;
    // 计算年份之间的天数
    for (int y = 2000; y < year; y++) {
        if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
            days += 366; // 闰年有366天
        } else {
            days += 365; // 平年有365天
        }
    }

    // 计算当前年份中月份之前的天数
    for (int m = 1; m < month; m++) {
        days += daysInMonth[m - 1];
    }

    // 加上当前月份的天数
    days += day;

    return days;
}
