package cv.tools.tools.Utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class AnalysisFilePath {

    protected List readExcelServlet(String readPath) {
        try {
            // TODO Auto-generated method stub
            AnalysisFilePath fts = new AnalysisFilePath();
            return fts.fileInput(readPath);
        } catch (IOException e) {
            e.printStackTrace();
            List list = new LinkedList();
            list.add("这个单元格是空值！");
            return list;
        }
    }
    /**
     * @param
     */
    public List fileInput(String readPath) throws IOException {

        HSSFWorkbook hw = new HSSFWorkbook(new FileInputStream(readPath));
        HSSFSheet sheet = hw.getSheet("DI(CP01)");
        int firstRowIndex = sheet.getFirstRowNum();   //第一行是列名，所以不读
        int lastRowIndex = sheet.getLastRowNum();
        List list = new LinkedList(); // 用来存放最后取得的值
        for (int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
            HSSFRow row = sheet.getRow(rIndex);
            if (row != null) {
                int firstCellIndex = row.getFirstCellNum();
                int lastCellIndex = row.getLastCellNum();
                for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列
                    HSSFCell hcell = row.getCell(cIndex);
                    String rowValue = this.getCellValue(hcell);
                    if (rowValue != null) {  //判断获取的是不是空值
                        // 注意Device号必须是文本形式
                        list.add(rowValue);
                    }else {
                        list.add("这里是空值");
                    }
                }
            }
        }
        return list;
    }

    /**
     * 处理读取的内容是什么格式：
     *      1：含有公式的值
     *      2：字符串的值
     *      3：纯数字的值
     *      。。。。。。
     * @param cell
     * @return
     */
    public String getCellValue(HSSFCell cell) {
        String value = null;
        if (cell != null) {
            switch (cell.getCellType()) {
                case HSSFCell.CELL_TYPE_FORMULA:
                    // cell.getCellFormula();
                    try {
                        value = String.valueOf(cell.getNumericCellValue());
                    } catch (IllegalStateException e) {
                        value = String.valueOf(cell.getRichStringCellValue());
                    }
                    break;
                case HSSFCell.CELL_TYPE_NUMERIC:
                    value = String.valueOf(cell.getNumericCellValue());
                    break;
                case HSSFCell.CELL_TYPE_STRING:
                    value = String.valueOf(cell.getRichStringCellValue());
                    break;
            }
        }
        return value;
    }
}
