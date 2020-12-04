package com.coin.base.config;

/**
 * @ClassName ReportStatusUtil
 * @Description: 计算统计填报数据
 * @Author kh
 * @Date 2020/1/3 14:51
 * @Version V1.0
 **/
public class ReportStatusUtil {

    /**
     * @param begin 开始时间
     * @param end   结束时间
     * @return int
     * @throws
     * @MethodName getMonthReport
     * @Description 双月报
     * @author kh
     * @date 2020/1/3 14:52
     */
    public static int getMonthReport(String begin, String end) {

        int beginYear = DateUtil.getStringYear(begin);//Integer.valueOf(begin.substring(1, 4));
        int endYear = DateUtil.getStringYear(end);//Integer.valueOf(end.substring(1, 4));
        int beginMonth = DateUtil.getStringMonth(begin) + 1;//Integer.valueOf(begin.substring(6, 7));
        int endMonth = DateUtil.getStringMonth(end) + 1;//Integer.valueOf(end.substring(6, 7));
        String before2019 = "2018-12-31";
        String after2019 = "2020-01-01";
        //当在同一年时
        int shouldReportNum = 0;
        if (endYear == beginYear) {
            if (endYear == 2019) {
                shouldReportNum += get2019MonthNum(beginMonth, endMonth);
            } else {
                shouldReportNum += DateUtil.getMonthCount(begin, end) / 2;
            }
        } else {
            if (endYear < 2019 || beginYear > 2019) {
                shouldReportNum += DateUtil.getMonthCount(begin, end) / 2;
            } else if (endYear == 2019) {
                // 2019为结束时间
                shouldReportNum += get2019MonthNum(1, endMonth);
                shouldReportNum += DateUtil.getMonthCount(begin, before2019) / 2;
            } else if (beginYear == 2019) {
                // 2019为起始起始时间
                shouldReportNum += get2019MonthNum(beginMonth, 12);
                shouldReportNum += DateUtil.getMonthCount(after2019, end) / 2;
            } else {
                // 2019在两个时间之间
                shouldReportNum += DateUtil.getMonthCount(begin, before2019) / 2;
                shouldReportNum += DateUtil.getMonthCount(after2019, end) / 2;
                shouldReportNum += get2019MonthNum(1, 12);
            }
        }
        return shouldReportNum;
    }

    /**
     * @param areaCode 地区编码
     * @param areaName 地区名称
     * @param begin
     * @param end
     * @param flog
     * @return java.lang.String
     * @throws
     * @MethodName getMonthStatName
     * @Description 生成双月报统计数据导出excel文件名称
     * @author kh
     * @date 2020/1/8 10:18
     */
    public static String getMonthStatName(String areaCode, String areaName, String begin, String end, boolean flog) {
        String nameTemp;
        if (flog) {
            nameTemp = "%s%s下一级双月报填报统计";
        } else {
            nameTemp = "%s%s下级全部双月报填报统计";
        }

        int beginYear = DateUtil.getStringYear(begin);//Integer.valueOf(begin.substring(1, 4));
        int endYear = DateUtil.getStringYear(end);//Integer.valueOf(end.substring(1, 4));
        int beginMonth = DateUtil.getStringMonth(begin) + 1;//Integer.valueOf(begin.substring(6, 7));
        int endMonth = DateUtil.getStringMonth(end) + 1;//Integer.valueOf(end.substring(6, 7));
        String dateName;
        String yearTemp = "%d年%d-%d月";
        String yearsTemp = "%d年%d月-%d年%d月";
        if (beginYear == endYear) {
            dateName = String.format(yearTemp, beginYear, beginMonth, endMonth);//beginYear + "年" + beginMonth + "-" + "月";
        } else {
            dateName = String.format(yearsTemp, beginYear, beginMonth, endYear, endMonth);//beginYear + "年" + beginMonth + "月-" + endYear + "年" + endMonth + "月"
        }
        if (areaCode.substring(0, 2).equals("00")) {
            return String.format(nameTemp, dateName, "全国");
        } else {
            return String.format(nameTemp, dateName, areaName);
        }
    }

    private static int get2019MonthNum(int beginMonth, int endMonth) {
        if (beginMonth != 1 || endMonth != 12) {
            return 1;
        } else {
            return 2;
        }
    }

    /**
     * @param begin
     * @param end
     * @return int
     * @throws
     * @MethodName getYearReport
     * @Description 年报应填数量
     * @author kh
     * @date 2020/1/3 16:35
     */
    public static int getYearReport(String begin, String end) {
        int beginYear = DateUtil.getStringYear(begin);
        int endYear = DateUtil.getStringYear(end);
        /*if(beginYear > 2019 || endYear < 2019) {
            return (endYear - beginYear + 1);
        } else {
            return (endYear - beginYear + 1) * 6 - 4;
        }*/

        return (endYear - beginYear + 1);
    }

    /**
     * @param areaCode
     * @param areaName
     * @param begin
     * @param end
     * @return java.lang.String
     * @throws
     * @MethodName getYearStatName
     * @Description 生成年报导出文件名称
     * @author kh
     * @date 2020/1/8 10:44
     */
    public static String getYearStatName(String areaCode, String areaName, String begin, String end, boolean flog) {
        String nameTemp;
        if (flog) {
            nameTemp = "%s%s下一级年报填报统计";
        } else {
            nameTemp = "%s%s下级全部年报填报统计";
        }
        int beginYear = DateUtil.getStringYear(begin);
        int endYear = DateUtil.getStringYear(end);
        String dateName;
        String yearTemp = "%d年";
        String yearsTemp = "%d-%d年";
        if (beginYear == endYear) {
            dateName = String.format(yearTemp, beginYear);
        } else {
            dateName = String.format(yearsTemp, beginYear, endYear);
        }

        if (areaCode.substring(0, 2).equals("00")) {
            return String.format(nameTemp, dateName, "全国");
        } else {
            return String.format(nameTemp, dateName, areaName);
        }
    }

    public static void main(String[] args) {
        System.out.println(getMonthReport("2020-01-01", "2020-12-31"));
        System.out.println(getYearReport("2018-01-01", "2020-12-01"));
        System.out.println(getMonthStatName("00000000", null, "2019-01-01", "2019-12-31", false));
        System.out.println(getMonthStatName("00000000", null, "2019-01-01", "2019-8-31", false));
        System.out.println(getMonthStatName("42000000", "湖北省", "2019-01-01", "2020-8-31", false));

        System.out.println(getYearStatName("00000000", null, "2019-01-01", "2019-12-31", false));
        System.out.println(getYearStatName("00000000", null, "2019-01-01", "2020-12-31", false));
        System.out.println(getYearStatName("42000000", "湖北省", "2019-01-01", "2019-12-31", false));
    }

}
