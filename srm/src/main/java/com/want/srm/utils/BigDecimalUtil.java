package com.want.srm.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class BigDecimalUtil {
	private static final BigDecimal ZERO = BigDecimal.ZERO;

    public static boolean isNull(BigDecimal bigDecimal) {
        return bigDecimal == null;
    }

    public static boolean isNullOrEqZero(BigDecimal bigDecimal) {
        return bigDecimal == null || bigDecimal.compareTo(ZERO) == 0;
    }

    public static boolean isNullOrLessZero(BigDecimal bigDecimal) {
        return bigDecimal == null || bigDecimal.compareTo(ZERO) < 0;
    }

    public static boolean isNullOrLessOrEqZero(BigDecimal bigDecimal) {
        return bigDecimal == null || bigDecimal.compareTo(ZERO) <= 0;
    }

    public static boolean isGreaterThanZero(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return false;
        }
        return bigDecimal.compareTo(ZERO) > 0;
    }

    public static boolean isGreaterThanOrEqualToZero(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return false;
        }
        return bigDecimal.compareTo(ZERO) >= 0;
    }

    /**
     * 将字符串转换成BigDecimal对象
     */
    public static BigDecimal stringToBigDecimal(String stringBigdecimal) {
        if (StringUtils.isBlank(stringBigdecimal)) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(stringBigdecimal).setScale(2, 4);
        } catch (Exception e) {
            System.out.println("stringToBigDecimal is error");
        }
        return BigDecimal.ZERO;
    }

    /**
     * 将null转换为0
     */
    public static BigDecimal bigDecimalNullToZero(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return BigDecimal.ZERO;
        } else {
            return bigDecimal;
        }
    }

    /**
     * 加法
     */
    public static BigDecimal bigDecimalAddList(List<BigDecimal> decimalList) {
        return decimalList
                .stream()
                .map(BigDecimalUtil::bigDecimalNullToZero)
                .reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, java.math.RoundingMode.HALF_UP);
    }

    public static void main(String[] args) {
        ArrayList<BigDecimal> list = new ArrayList<>();
        list.add(new BigDecimal("10"));
        list.add(new BigDecimal("20"));
        list.add(new BigDecimal("30"));
        list.add(null);
        System.out.println(BigDecimalUtil.bigDecimalAddList(list));
    }
}
