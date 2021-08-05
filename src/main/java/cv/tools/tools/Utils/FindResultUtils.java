package cv.tools.tools.Utils;

import cv.tools.tools.Domin.FileReadDomin;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;

public class FindResultUtils {

    // findResult是查出来所有的数据，并排序
    public List<FileReadDomin> findResult(List<FileReadDomin> findResult) {
        String Device_num = "";
        List list = new LinkedList();
        for (int j = 0; j < findResult.size()-1; j++) {
            FileReadDomin fileReadDomin = new FileReadDomin();
            for (int i = 0; i < findResult.size(); i++) {
                if (findResult.get(i).getDevice_num().equals(Device_num)) {
                    fileReadDomin.setDevice_num(findResult.get(i).getDevice_num());
                    if (StringUtils.isNotBlank(findResult.get(i).getStart_up())) {
                        fileReadDomin.setStart_up(findResult.get(i).getStart_up());
                    } else if (StringUtils.isNotBlank(findResult.get(i).getStart_up_bit())) {
                        fileReadDomin.setStart_up_bit(findResult.get(i).getStart_up_bit());
                    } else if (findResult.get(i).getStart_up_lsn() != null) {
                        fileReadDomin.setStart_up_lsn(findResult.get(i).getStart_up_lsn());
                    }
                    if (StringUtils.isNotBlank(findResult.get(i).getStarting_device())) {
                        fileReadDomin.setStarting_device(findResult.get(i).getStarting_device());
                    } else if (StringUtils.isNotBlank(findResult.get(i).getStarting_device_bit())) {
                        fileReadDomin.setStarting_device_bit(findResult.get(i).getStarting_device_bit());
                    } else if (findResult.get(i).getStarting_device_lsn() != null) {
                        fileReadDomin.setStarting_device_lsn(findResult.get(i).getStarting_device_lsn());
                    }
                    if (StringUtils.isNotBlank(findResult.get(i).getAbnormal())) {
                        fileReadDomin.setStarting_device(findResult.get(i).getAbnormal());
                    } else if (StringUtils.isNotBlank(findResult.get(i).getAbnormal_bit())) {
                        fileReadDomin.setAbnormal_bit(findResult.get(i).getAbnormal_bit());
                    } else if (findResult.get(i).getAbnormal_lsn() != null) {
                        fileReadDomin.setAbnormal_lsn(findResult.get(i).getAbnormal_lsn());
                    }

                }else {
                    Device_num = findResult.get(i).getDevice_num();
                    if (Device_num.equals("D0000")){
                        i = 0;
                    }
                }
            }
            list.add(fileReadDomin);
        }
        return list;
    }
}
