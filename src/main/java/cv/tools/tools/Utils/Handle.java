package cv.tools.tools.Utils;

import cv.tools.tools.Domin.FileReadDomin;
import java.util.LinkedList;
import java.util.List;

public class Handle {

    public List<FileReadDomin> handleShuJu(String path) {
        List list = new AnalysisFilePath().readExcelServlet(path);
        List listNeiRong = new LinkedList();
        List<FileReadDomin> list1 = new LinkedList<FileReadDomin>();
        listNeiRong.add("异常发生");
        listNeiRong.add("异常Reset恢复");
        listNeiRong.add("异常码");
        listNeiRong.add("异常报告选通");
        listNeiRong.add("生存确认");
        listNeiRong.add("自动");
        listNeiRong.add("启动中");
        listNeiRong.add("异常");
        listNeiRong.add("入库模式");
        listNeiRong.add("出库模式");
        listNeiRong.add("载荷");
        listNeiRong.add("载荷1");
        listNeiRong.add("载荷2");
        listNeiRong.add("载荷3");
        listNeiRong.add("载荷4");
        listNeiRong.add("载荷5");
        listNeiRong.add("货高6");
        listNeiRong.add("货高7");
        listNeiRong.add("异常Reset按钮");
        listNeiRong.add("完了按钮");
        listNeiRong.add("托盘码");
        listNeiRong.add("〃");
        for (int i = 0; i < list.size(); i++) {   // 获取了读到文件的长度
            if (!(list.get(i).equals("这里是空值"))) {     // 判断那个单元格是空的，空的则不执行下列的程序
                for (int j = 0; j < listNeiRong.size(); j++) {
                    FileReadDomin fileReadDomin = new FileReadDomin();
                    if ((list.get(i).toString().contains(listNeiRong.get(j).toString()) && list.get(i - 2).toString().contains("D"))) {
                        if (!(list.get(i - 2).toString().equals(""))) {
                            if (listNeiRong.get(j).toString().contains("异常发生")) {
                                fileReadDomin.setDevice_num(list.get(i - 2).toString());
                                fileReadDomin.setError_start(list.get(i).toString());
                                fileReadDomin.setError_start_bit(list.get(i - 1).toString());
                                fileReadDomin.setError_start_lsn(Integer.parseInt(new java.text.DecimalFormat("0").format(Double.parseDouble(list.get(i + 1).toString()))));
                                list1.add(fileReadDomin);
                            }else if (listNeiRong.get(j).toString().contains("异常Reset恢复")) {
                                fileReadDomin.setReset_button_lsn(Integer.parseInt(new java.text.DecimalFormat("0").format(Double.parseDouble(list.get(i + 1).toString()))));
                                fileReadDomin.setReset_button_bit(list.get(i-1).toString());
                                fileReadDomin.setReset_button(list.get(i - 1).toString());
                                fileReadDomin.setDevice_num(list.get(i - 2).toString());
                                list1.add(fileReadDomin);
                            }else if (listNeiRong.get(j).toString().contains("自动")) {
                                fileReadDomin.setStart_up(list.get(i).toString());
                                fileReadDomin.setStart_up_lsn(Integer.parseInt(new java.text.DecimalFormat("0").format(Double.parseDouble(list.get(i + 1).toString()))));
                                fileReadDomin.setStart_up_bit(list.get(i-1).toString());
                                fileReadDomin.setDevice_num(list.get(i - 2).toString());
                                list1.add(fileReadDomin);
                            }else if (listNeiRong.get(j).toString().contains("启动中")) {
                                fileReadDomin.setStarting_device(list.get(i).toString());
                                fileReadDomin.setStarting_device_lsn(Integer.parseInt(new java.text.DecimalFormat("0").format(Double.parseDouble(list.get(i + 1).toString()))));
                                fileReadDomin.setStarting_device_bit(list.get(i-1).toString());
                                fileReadDomin.setDevice_num(list.get(i - 2).toString());
                                list1.add(fileReadDomin);
                            }else if (listNeiRong.get(j).toString().contains("异常")) {
                                fileReadDomin.setAbnormal(list.get(i).toString());
                                fileReadDomin.setAbnormal_lsn(Integer.parseInt(new java.text.DecimalFormat("0").format(Double.parseDouble(list.get(i + 1).toString()))));
                                fileReadDomin.setAbnormal_bit(list.get(i-1).toString());
                                fileReadDomin.setDevice_num(list.get(i - 2).toString());
                                list1.add(fileReadDomin);
                            }else if (listNeiRong.get(j).toString().contains("入库模式")) {
                                fileReadDomin.setWarehousing_mode(list.get(i).toString());
                                fileReadDomin.setWarehousing_mode_lsn(Integer.parseInt(new java.text.DecimalFormat("0").format(Double.parseDouble(list.get(i + 1).toString()))));
                                fileReadDomin.setWarehousing_mode_bit(list.get(i-1).toString());
                                fileReadDomin.setDevice_num(list.get(i - 2).toString());
                                list1.add(fileReadDomin);
                            }else if (listNeiRong.get(j).toString().contains("出库模式")) {
                                fileReadDomin.setDelivery_mode(list.get(i).toString());
                                fileReadDomin.setDelivery_mode_lsn(Integer.parseInt(new java.text.DecimalFormat("0").format(Double.parseDouble(list.get(i + 1).toString()))));
                                fileReadDomin.setDelivery_mode_bit(list.get(i-1).toString());
                                fileReadDomin.setDevice_num(list.get(i - 2).toString());
                                list1.add(fileReadDomin);
                            }else if (listNeiRong.get(j).toString().contains("货高")) {
                                fileReadDomin.setHigh_quality(list.get(i).toString());
                                fileReadDomin.setHigh_quality_lsn(Integer.parseInt(new java.text.DecimalFormat("0").format(Double.parseDouble(list.get(i + 1).toString()))));
                                fileReadDomin.setHigh_quality_bit(list.get(i-1).toString());
                                fileReadDomin.setDevice_num(list.get(i - 2).toString());
                                list1.add(fileReadDomin);
                            }else if (listNeiRong.get(j).toString().contains("异常Reset按钮")) {
                                fileReadDomin.setReset_button(list.get(i).toString());
                                fileReadDomin.setReset_button_lsn(Integer.parseInt(new java.text.DecimalFormat("0").format(Double.parseDouble(list.get(i + 1).toString()))));
                                fileReadDomin.setReset_button_bit(list.get(i-1).toString());
                                fileReadDomin.setDevice_num(list.get(i - 2).toString());
                                list1.add(fileReadDomin);
                            }else if (listNeiRong.get(j).toString().contains("完了按钮")) {
                                fileReadDomin.setFinish_button(list.get(i).toString());
                                fileReadDomin.setFinish_button_lsn(Integer.parseInt(new java.text.DecimalFormat("0").format(Double.parseDouble(list.get(i + 1).toString()))));
                                fileReadDomin.setFinish_button_bit(list.get(i-1).toString());
                                fileReadDomin.setDevice_num(list.get(i - 2).toString());
                                list1.add(fileReadDomin);
                            }else if (listNeiRong.get(j).toString().contains("分拣按钮")) {
                                fileReadDomin.setSorting_button(list.get(i).toString());
                                fileReadDomin.setSorting_button_lsn(Integer.parseInt(new java.text.DecimalFormat("0").format(Double.parseDouble(list.get(i + 1).toString()))));
                                fileReadDomin.setSorting_button_bit(list.get(i-1).toString());
                                fileReadDomin.setDevice_num(list.get(i - 2).toString());
                                list1.add(fileReadDomin);
                            }else if (listNeiRong.get(j).toString().contains("载荷")) {
                                fileReadDomin.setLoad0(list.get(i).toString());
                                fileReadDomin.setLoad0_lsn(Integer.parseInt(new java.text.DecimalFormat("0").format(Double.parseDouble(list.get(i + 1).toString()))));
                                fileReadDomin.setLoad0_bit(list.get(i-1).toString());
                                fileReadDomin.setDevice_num(list.get(i - 2).toString());
                                list1.add(fileReadDomin);
                            }else if (listNeiRong.get(j).toString().contains("载荷1")) {
                                fileReadDomin.setLoad1(list.get(i).toString());
                                fileReadDomin.setLoad1_lsn(Integer.parseInt(new java.text.DecimalFormat("0").format(Double.parseDouble(list.get(i + 1).toString()))));
                                fileReadDomin.setLoad1_bit(list.get(i-1).toString());
                                fileReadDomin.setDevice_num(list.get(i - 2).toString());
                                list1.add(fileReadDomin);
                            }else if (listNeiRong.get(j).toString().contains("载荷2")) {
                                fileReadDomin.setLoad2(list.get(i).toString());
                                fileReadDomin.setLoad2_lsn(Integer.parseInt(new java.text.DecimalFormat("0").format(Double.parseDouble(list.get(i + 1).toString()))));
                                fileReadDomin.setLoad2_bit(list.get(i-1).toString());
                                fileReadDomin.setDevice_num(list.get(i - 2).toString());
                                list1.add(fileReadDomin);
                            }else if (listNeiRong.get(j).toString().contains("载荷3")) {
                                fileReadDomin.setLoad3(list.get(i).toString());
                                fileReadDomin.setLoad3_lsn(Integer.parseInt(new java.text.DecimalFormat("0").format(Double.parseDouble(list.get(i + 1).toString()))));
                                fileReadDomin.setLoad3_bit(list.get(i-1).toString());
                                fileReadDomin.setDevice_num(list.get(i - 2).toString());
                                list1.add(fileReadDomin);
                            }else if (listNeiRong.get(j).toString().contains("载荷4")) {
                                fileReadDomin.setLoad4(list.get(i).toString());
                                fileReadDomin.setLoad4_lsn(Integer.parseInt(new java.text.DecimalFormat("0").format(Double.parseDouble(list.get(i + 1).toString()))));
                                fileReadDomin.setLoad4_bit(list.get(i-1).toString());
                                fileReadDomin.setDevice_num(list.get(i - 2).toString());
                                list1.add(fileReadDomin);
                            }else if (listNeiRong.get(j).toString().contains("载荷5")) {
                                fileReadDomin.setLoad5(list.get(i).toString());
                                fileReadDomin.setLoad5_lsn(Integer.parseInt(new java.text.DecimalFormat("0").format(Double.parseDouble(list.get(i + 1).toString()))));
                                fileReadDomin.setLoad5_bit(list.get(i-1).toString());
                                fileReadDomin.setDevice_num(list.get(i - 2).toString());
                                list1.add(fileReadDomin);
                            }else if (listNeiRong.get(j).toString().contains("载荷6")) {
                                fileReadDomin.setLoad6(list.get(i).toString());
                                fileReadDomin.setLoad6_lsn(Integer.parseInt(new java.text.DecimalFormat("0").format(Double.parseDouble(list.get(i + 1).toString()))));
                                fileReadDomin.setLoad6_bit(list.get(i-1).toString());
                                fileReadDomin.setDevice_num(list.get(i - 2).toString());
                                list1.add(fileReadDomin);
                            }
                        }
                    }
                }
            }
        }
        return list1;
    }
}
