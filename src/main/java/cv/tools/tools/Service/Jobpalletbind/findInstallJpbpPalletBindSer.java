package cv.tools.tools.Service.Jobpalletbind;

import cv.tools.tools.Dao.Jobpalletbind.findInstallJpbpPalletBindDao;
import cv.tools.tools.Dao.Jobpalletbind.installJobPalletBind;
import org.dom4j.util.AttributeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class findInstallJpbpPalletBindSer {


    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    private String palletNum;


    findInstallJpbpPalletBindDao findInstallJpbpPalletBindDao = new findInstallJpbpPalletBindDao();
    installJobPalletBind installJobPalletBind = new installJobPalletBind();

    // 查询物料类别
    public List findCodeCategry(){
        return findInstallJpbpPalletBindDao.findCodeCategry();
    }

    // 查询保管区域
    public List findCodeStorage(){
        return findInstallJpbpPalletBindDao.findCodeStorage();
    }

    // 提交的数据
    public List submit(Map data){
        String code_categry = data.get("code_categry").toString();
        String code_pallet = data.get("code_pallet").toString();
        String code_storage = data.get("code_storage").toString();
        String qty = data.get("qty").toString();
        String startTime = data.get("startTime").toString();
        String endTime = data.get("endTime").toString();
        this.palletNum = data.get("code_pallet").toString();
        this.startDate =  startTime.split(",")[0].toString().split(" ")[0].toString().replace("[","").toString().replace("-","");
        this.startTime =  startTime.split(",")[0].toString().split(" ")[1].toString().replace(":","").toString();
        this.endDate =  startTime.split(",")[1].toString().split(" ")[1].toString().replace("]","").toString().replace("-","");
        this.endTime =  startTime.split(",")[1].toString().split(" ")[2].toString().replace(":","").toString().replace("]","");
        for (int i = 0; i < this.findQrCode().size(); i++) {
            Map mapList = (Map) this.findQrCode().get(i);
            Set<Map.Entry<Integer,String>> entries=mapList.entrySet();
            for (Map.Entry entry:entries){
                System.out.println(entry.getValue());
            }
        }
        return null;
    }

    // 根据QR发行的开始时间和结束时间去找QR码
    public List findQrCode(){

        List qrList = findInstallJpbpPalletBindDao.findQrCode(startDate,startTime,endDate,endTime);
        List insJobPalletBindList = new ArrayList();
        for (int i = 0; i < qrList.size(); i++) {
            Map insJobPalletBind = new HashMap();
            insJobPalletBind.put("NUM_SEQ",palletNum + String.format("%09d", i)); // 自动编号
            insJobPalletBind.put("CODE_PALLET",palletNum + String.format("%09d", i)); // 托盘号
            insJobPalletBind.put("KIND",findInstallJpbpPalletBindDao.findQrCode(qrList.get(i).toString().split("\\|")[2].toString()).get(1).toString()); // 绑定区分(1:空托盘,2:原辅料,3:成品,,4:留样,9:其它)
            insJobPalletBind.put("PALLET_TYPE",findInstallJpbpPalletBindDao.findQrCode(qrList.get(i).toString().split("\\|")[2].toString()).get(0).toString()); // 托盘种类(1:常温和阴凉,2:Miniload,3:缓存库)
            insJobPalletBind.put("STS_PALLET",0); // 状态(0:未入库,1:已入库)
            insJobPalletBind.put("NUM_QR",qrList.get(i).toString().split("\\|")[0].toString()); // QR番号(空托盘入库无, 成品入库无)
            insJobPalletBind.put("CODE_ITEM",qrList.get(i).toString().split("\\|")[2].toString()); // 品号
            insJobPalletBind.put("LOT",qrList.get(i).toString().split("\\|")[3].toString()); // 批号
            insJobPalletBind.put("QTY",qrList.get(i).toString().split("\\|")[5].toString()); // 数量
            insJobPalletBind.put("MEMO1",'-'); // 配料室站台号
            insJobPalletBind.put("MEMO2",findInstallJpbpPalletBindDao.findSchStrpln(qrList.get(i).toString().split("\\|")[0].toString()).get(2)); // 指示日期
            insJobPalletBind.put("MEMO3",findInstallJpbpPalletBindDao.findSchStrpln(qrList.get(i).toString().split("\\|")[0].toString()).get(0)); // 指示单号
            insJobPalletBind.put("MEMO4",findInstallJpbpPalletBindDao.findSchStrpln(qrList.get(i).toString().split("\\|")[0].toString()).get(1)); // 指示子单号
            insJobPalletBind.put("MEMO5",'-'); // 备注(注释)
            insJobPalletBind.put("DATE_CRE", LocalDate.now().toString().replace("-","")); // 作成日
            insJobPalletBind.put("TIME_CRE", LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")).replace(":","")); // 作成時間
            insJobPalletBind.put("DATE_UPD",LocalDate.now().toString().replace("-","")); // 更新日
            insJobPalletBind.put("TIME_UPD",LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")).replace(":","")); // 更新時間
            insJobPalletBindList.add(insJobPalletBind);
        }
        installJobPalletBind.install(insJobPalletBindList);
        return insJobPalletBindList;
    }
}
