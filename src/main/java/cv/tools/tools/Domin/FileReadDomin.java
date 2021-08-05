package cv.tools.tools.Domin;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Proxy;

import java.io.Serializable;
import javax.persistence.*;

@Proxy(lazy = false)
@Entity
@Table(name="cv_dio")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class FileReadDomin implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String Start_up_bit;
        private String Start_up;
        private Integer Start_up_lsn;
        private String Starting_device_bit;
        private String Starting_device;
        private Integer Starting_device_lsn;
        private String Abnormal_bit;
        private String Abnormal;
        private Integer Abnormal_lsn;
        private String Warehousing_mode_bit;
        private String Warehousing_mode;
        private Integer Warehousing_mode_lsn;
        private String Delivery_mode_bit;
        private String Delivery_mode;
        private Integer Delivery_mode_lsn;
        private String High_quality_bit;
        private String High_quality;
        private Integer High_quality_lsn;
        private String Reset_button_bit;
        private String Reset_button;
        private Integer Reset_button_lsn;
        private String Sorting_button_bit;
        private String Sorting_button;
        private Integer Sorting_button_lsn;
        private String Finish_button_bit;
        private String Finish_button;
        private Integer Finish_button_lsn;
        private String Pallet_code;
        private String Error_start_bit;
        private String Error_start;
        private Integer Error_start_lsn;
        private String Error_block_start_device_bit;
        private String Error_block_start_device;
        private Integer Error_block_start_device_lsn;
        private String Error_block_end_device_bit;
        private String Error_block_end_device;
        private Integer Error_block_end_device_lsn;
        private String Error_mmc_start_device_bit;
        private String Error_mmc_start_device;
        private Integer Error_mmc_start_device_lsn;
        private String Error_mmc_end_device_bit;
        private String Error_mmc_end_device;
        private Integer Error_mmc_end_device_lsn;
        private String Error_report_bit;
        private String Error_report;
        private Integer Error_report_lsn;
        private String Existence_bit;
        private String Existence;
        private Integer Existence_lsn;
        private String Signal_name;
        private String load0_bit;
        private String load0;
        private Integer load0_lsn;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getStart_up_bit() {
                return Start_up_bit;
        }

        public void setStart_up_bit(String start_up_bit) {
                Start_up_bit = start_up_bit;
        }

        public String getStart_up() {
                return Start_up;
        }

        public void setStart_up(String start_up) {
                Start_up = start_up;
        }

        public Integer getStart_up_lsn() {
                return Start_up_lsn;
        }

        public void setStart_up_lsn(Integer start_up_lsn) {
                Start_up_lsn = start_up_lsn;
        }

        public String getStarting_device_bit() {
                return Starting_device_bit;
        }

        public void setStarting_device_bit(String starting_device_bit) {
                Starting_device_bit = starting_device_bit;
        }

        public String getStarting_device() {
                return Starting_device;
        }

        public void setStarting_device(String starting_device) {
                Starting_device = starting_device;
        }

        public Integer getStarting_device_lsn() {
                return Starting_device_lsn;
        }

        public void setStarting_device_lsn(Integer starting_device_lsn) {
                Starting_device_lsn = starting_device_lsn;
        }

        public String getAbnormal_bit() {
                return Abnormal_bit;
        }

        public void setAbnormal_bit(String abnormal_bit) {
                Abnormal_bit = abnormal_bit;
        }

        public String getAbnormal() {
                return Abnormal;
        }

        public void setAbnormal(String abnormal) {
                Abnormal = abnormal;
        }

        public Integer getAbnormal_lsn() {
                return Abnormal_lsn;
        }

        public void setAbnormal_lsn(Integer abnormal_lsn) {
                Abnormal_lsn = abnormal_lsn;
        }

        public String getWarehousing_mode_bit() {
                return Warehousing_mode_bit;
        }

        public void setWarehousing_mode_bit(String warehousing_mode_bit) {
                Warehousing_mode_bit = warehousing_mode_bit;
        }

        public String getWarehousing_mode() {
                return Warehousing_mode;
        }

        public void setWarehousing_mode(String warehousing_mode) {
                Warehousing_mode = warehousing_mode;
        }

        public Integer getWarehousing_mode_lsn() {
                return Warehousing_mode_lsn;
        }

        public void setWarehousing_mode_lsn(Integer warehousing_mode_lsn) {
                Warehousing_mode_lsn = warehousing_mode_lsn;
        }

        public String getDelivery_mode_bit() {
                return Delivery_mode_bit;
        }

        public void setDelivery_mode_bit(String delivery_mode_bit) {
                Delivery_mode_bit = delivery_mode_bit;
        }

        public String getDelivery_mode() {
                return Delivery_mode;
        }

        public void setDelivery_mode(String delivery_mode) {
                Delivery_mode = delivery_mode;
        }

        public Integer getDelivery_mode_lsn() {
                return Delivery_mode_lsn;
        }

        public void setDelivery_mode_lsn(Integer delivery_mode_lsn) {
                Delivery_mode_lsn = delivery_mode_lsn;
        }

        public String getHigh_quality_bit() {
                return High_quality_bit;
        }

        public void setHigh_quality_bit(String high_quality_bit) {
                High_quality_bit = high_quality_bit;
        }

        public String getHigh_quality() {
                return High_quality;
        }

        public void setHigh_quality(String high_quality) {
                High_quality = high_quality;
        }

        public Integer getHigh_quality_lsn() {
                return High_quality_lsn;
        }

        public void setHigh_quality_lsn(Integer high_quality_lsn) {
                High_quality_lsn = high_quality_lsn;
        }

        public String getReset_button_bit() {
                return Reset_button_bit;
        }

        public void setReset_button_bit(String reset_button_bit) {
                Reset_button_bit = reset_button_bit;
        }

        public String getReset_button() {
                return Reset_button;
        }

        public void setReset_button(String reset_button) {
                Reset_button = reset_button;
        }

        public Integer getReset_button_lsn() {
                return Reset_button_lsn;
        }

        public void setReset_button_lsn(Integer reset_button_lsn) {
                Reset_button_lsn = reset_button_lsn;
        }

        public String getSorting_button_bit() {
                return Sorting_button_bit;
        }

        public void setSorting_button_bit(String sorting_button_bit) {
                Sorting_button_bit = sorting_button_bit;
        }

        public String getSorting_button() {
                return Sorting_button;
        }

        public void setSorting_button(String sorting_button) {
                Sorting_button = sorting_button;
        }

        public Integer getSorting_button_lsn() {
                return Sorting_button_lsn;
        }

        public void setSorting_button_lsn(Integer sorting_button_lsn) {
                Sorting_button_lsn = sorting_button_lsn;
        }

        public String getFinish_button_bit() {
                return Finish_button_bit;
        }

        public void setFinish_button_bit(String finish_button_bit) {
                Finish_button_bit = finish_button_bit;
        }

        public String getFinish_button() {
                return Finish_button;
        }

        public void setFinish_button(String finish_button) {
                Finish_button = finish_button;
        }

        public Integer getFinish_button_lsn() {
                return Finish_button_lsn;
        }

        public void setFinish_button_lsn(Integer finish_button_lsn) {
                Finish_button_lsn = finish_button_lsn;
        }

        public String getPallet_code() {
                return Pallet_code;
        }

        public void setPallet_code(String pallet_code) {
                Pallet_code = pallet_code;
        }

        public String getError_start_bit() {
                return Error_start_bit;
        }

        public void setError_start_bit(String error_start_bit) {
                Error_start_bit = error_start_bit;
        }

        public String getError_start() {
                return Error_start;
        }

        public void setError_start(String error_start) {
                Error_start = error_start;
        }

        public Integer getError_start_lsn() {
                return Error_start_lsn;
        }

        public void setError_start_lsn(Integer error_start_lsn) {
                Error_start_lsn = error_start_lsn;
        }

        public String getError_block_start_device_bit() {
                return Error_block_start_device_bit;
        }

        public void setError_block_start_device_bit(String error_block_start_device_bit) {
                Error_block_start_device_bit = error_block_start_device_bit;
        }

        public String getError_block_start_device() {
                return Error_block_start_device;
        }

        public void setError_block_start_device(String error_block_start_device) {
                Error_block_start_device = error_block_start_device;
        }

        public Integer getError_block_start_device_lsn() {
                return Error_block_start_device_lsn;
        }

        public void setError_block_start_device_lsn(Integer error_block_start_device_lsn) {
                Error_block_start_device_lsn = error_block_start_device_lsn;
        }

        public String getError_block_end_device_bit() {
                return Error_block_end_device_bit;
        }

        public void setError_block_end_device_bit(String error_block_end_device_bit) {
                Error_block_end_device_bit = error_block_end_device_bit;
        }

        public String getError_block_end_device() {
                return Error_block_end_device;
        }

        public void setError_block_end_device(String error_block_end_device) {
                Error_block_end_device = error_block_end_device;
        }

        public Integer getError_block_end_device_lsn() {
                return Error_block_end_device_lsn;
        }

        public void setError_block_end_device_lsn(Integer error_block_end_device_lsn) {
                Error_block_end_device_lsn = error_block_end_device_lsn;
        }

        public String getError_mmc_start_device_bit() {
                return Error_mmc_start_device_bit;
        }

        public void setError_mmc_start_device_bit(String error_mmc_start_device_bit) {
                Error_mmc_start_device_bit = error_mmc_start_device_bit;
        }

        public String getError_mmc_start_device() {
                return Error_mmc_start_device;
        }

        public void setError_mmc_start_device(String error_mmc_start_device) {
                Error_mmc_start_device = error_mmc_start_device;
        }

        public Integer getError_mmc_start_device_lsn() {
                return Error_mmc_start_device_lsn;
        }

        public void setError_mmc_start_device_lsn(Integer error_mmc_start_device_lsn) {
                Error_mmc_start_device_lsn = error_mmc_start_device_lsn;
        }

        public String getError_mmc_end_device_bit() {
                return Error_mmc_end_device_bit;
        }

        public void setError_mmc_end_device_bit(String error_mmc_end_device_bit) {
                Error_mmc_end_device_bit = error_mmc_end_device_bit;
        }

        public String getError_mmc_end_device() {
                return Error_mmc_end_device;
        }

        public void setError_mmc_end_device(String error_mmc_end_device) {
                Error_mmc_end_device = error_mmc_end_device;
        }

        public Integer getError_mmc_end_device_lsn() {
                return Error_mmc_end_device_lsn;
        }

        public void setError_mmc_end_device_lsn(Integer error_mmc_end_device_lsn) {
                Error_mmc_end_device_lsn = error_mmc_end_device_lsn;
        }

        public String getError_report_bit() {
                return Error_report_bit;
        }

        public void setError_report_bit(String error_report_bit) {
                Error_report_bit = error_report_bit;
        }

        public String getError_report() {
                return Error_report;
        }

        public void setError_report(String error_report) {
                Error_report = error_report;
        }

        public Integer getError_report_lsn() {
                return Error_report_lsn;
        }

        public void setError_report_lsn(Integer error_report_lsn) {
                Error_report_lsn = error_report_lsn;
        }

        public String getExistence_bit() {
                return Existence_bit;
        }

        public void setExistence_bit(String existence_bit) {
                Existence_bit = existence_bit;
        }

        public String getExistence() {
                return Existence;
        }

        public void setExistence(String existence) {
                Existence = existence;
        }

        public Integer getExistence_lsn() {
                return Existence_lsn;
        }

        public void setExistence_lsn(Integer existence_lsn) {
                Existence_lsn = existence_lsn;
        }

        public String getSignal_name() {
                return Signal_name;
        }

        public void setSignal_name(String signal_name) {
                Signal_name = signal_name;
        }

        public String getLoad0_bit() {
                return load0_bit;
        }

        public void setLoad0_bit(String load0_bit) {
                this.load0_bit = load0_bit;
        }

        public String getLoad0() {
                return load0;
        }

        public void setLoad0(String load0) {
                this.load0 = load0;
        }

        public Integer getLoad0_lsn() {
                return load0_lsn;
        }

        public void setLoad0_lsn(Integer load0_lsn) {
                this.load0_lsn = load0_lsn;
        }

        public String getLoad1_bit() {
                return load1_bit;
        }

        public void setLoad1_bit(String load1_bit) {
                this.load1_bit = load1_bit;
        }

        public String getLoad1() {
                return load1;
        }

        public void setLoad1(String load1) {
                this.load1 = load1;
        }

        public Integer getLoad1_lsn() {
                return load1_lsn;
        }

        public void setLoad1_lsn(Integer load1_lsn) {
                this.load1_lsn = load1_lsn;
        }

        public String getLoad2_bit() {
                return load2_bit;
        }

        public void setLoad2_bit(String load2_bit) {
                this.load2_bit = load2_bit;
        }

        public String getLoad2() {
                return load2;
        }

        public void setLoad2(String load2) {
                this.load2 = load2;
        }

        public Integer getLoad2_lsn() {
                return load2_lsn;
        }

        public void setLoad2_lsn(Integer load2_lsn) {
                this.load2_lsn = load2_lsn;
        }

        public String getLoad3_bit() {
                return load3_bit;
        }

        public void setLoad3_bit(String load3_bit) {
                this.load3_bit = load3_bit;
        }

        public String getLoad3() {
                return load3;
        }

        public void setLoad3(String load3) {
                this.load3 = load3;
        }

        public Integer getLoad3_lsn() {
                return load3_lsn;
        }

        public void setLoad3_lsn(Integer load3_lsn) {
                this.load3_lsn = load3_lsn;
        }

        public String getLoad4_bit() {
                return load4_bit;
        }

        public void setLoad4_bit(String load4_bit) {
                this.load4_bit = load4_bit;
        }

        public String getLoad4() {
                return load4;
        }

        public void setLoad4(String load4) {
                this.load4 = load4;
        }

        public Integer getLoad4_lsn() {
                return load4_lsn;
        }

        public void setLoad4_lsn(Integer load4_lsn) {
                this.load4_lsn = load4_lsn;
        }

        public String getLoad5_bit() {
                return load5_bit;
        }

        public void setLoad5_bit(String load5_bit) {
                this.load5_bit = load5_bit;
        }

        public String getLoad5() {
                return load5;
        }

        public void setLoad5(String load5) {
                this.load5 = load5;
        }

        public Integer getLoad5_lsn() {
                return load5_lsn;
        }

        public void setLoad5_lsn(Integer load5_lsn) {
                this.load5_lsn = load5_lsn;
        }

        public String getLoad6_bit() {
                return load6_bit;
        }

        public void setLoad6_bit(String load6_bit) {
                this.load6_bit = load6_bit;
        }

        public String getLoad6() {
                return load6;
        }

        public void setLoad6(String load6) {
                this.load6 = load6;
        }

        public Integer getLoad6_lsn() {
                return load6_lsn;
        }

        public void setLoad6_lsn(Integer load6_lsn) {
                this.load6_lsn = load6_lsn;
        }

        public String getLoad7_bit() {
                return load7_bit;
        }

        public void setLoad7_bit(String load7_bit) {
                this.load7_bit = load7_bit;
        }

        public String getLoad7() {
                return load7;
        }

        public void setLoad7(String load7) {
                this.load7 = load7;
        }

        public Integer getLoad7_lsn() {
                return load7_lsn;
        }

        public void setLoad7_lsn(Integer load7_lsn) {
                this.load7_lsn = load7_lsn;
        }

        public String getDevice_num() {
                return Device_num;
        }

        public void setDevice_num(String device_num) {
                Device_num = device_num;
        }

        public FileReadDomin(String start_up_bit, String start_up, Integer start_up_lsn, String starting_device_bit, String starting_device, Integer starting_device_lsn, String abnormal_bit, String abnormal, Integer abnormal_lsn, String warehousing_mode_bit, String warehousing_mode, Integer warehousing_mode_lsn, String delivery_mode_bit, String delivery_mode, Integer delivery_mode_lsn, String high_quality_bit, String high_quality, Integer high_quality_lsn, String reset_button_bit, String reset_button, Integer reset_button_lsn, String sorting_button_bit, String sorting_button, Integer sorting_button_lsn, String finish_button_bit, String finish_button, Integer finish_button_lsn, String pallet_code, String error_start_bit, String error_start, Integer error_start_lsn, String error_block_start_device_bit, String error_block_start_device, Integer error_block_start_device_lsn, String error_block_end_device_bit, String error_block_end_device, Integer error_block_end_device_lsn, String error_mmc_start_device_bit, String error_mmc_start_device, Integer error_mmc_start_device_lsn, String error_mmc_end_device_bit, String error_mmc_end_device, Integer error_mmc_end_device_lsn, String error_report_bit, String error_report, Integer error_report_lsn, String existence_bit, String existence, Integer existence_lsn, String signal_name, String load0_bit, String load0, Integer load0_lsn, String load1_bit, String load1, Integer load1_lsn, String load2_bit, String load2, Integer load2_lsn, String load3_bit, String load3, Integer load3_lsn, String load4_bit, String load4, Integer load4_lsn, String load5_bit, String load5, Integer load5_lsn, String load6_bit, String load6, Integer load6_lsn, String load7_bit, String load7, Integer load7_lsn, String device_num) {
                Start_up_bit = start_up_bit;
                Start_up = start_up;
                Start_up_lsn = start_up_lsn;

                Starting_device_bit = starting_device_bit;
                Starting_device = starting_device;
                Starting_device_lsn = starting_device_lsn;
                Abnormal_bit = abnormal_bit;
                Abnormal = abnormal;
                Abnormal_lsn = abnormal_lsn;
                Warehousing_mode_bit = warehousing_mode_bit;
                Warehousing_mode = warehousing_mode;
                Warehousing_mode_lsn = warehousing_mode_lsn;
                Delivery_mode_bit = delivery_mode_bit;
                Delivery_mode = delivery_mode;
                Delivery_mode_lsn = delivery_mode_lsn;
                High_quality_bit = high_quality_bit;
                High_quality = high_quality;
                High_quality_lsn = high_quality_lsn;
                Reset_button_bit = reset_button_bit;
                Reset_button = reset_button;
                Reset_button_lsn = reset_button_lsn;
                Sorting_button_bit = sorting_button_bit;
                Sorting_button = sorting_button;
                Sorting_button_lsn = sorting_button_lsn;
                Finish_button_bit = finish_button_bit;
                Finish_button = finish_button;
                Finish_button_lsn = finish_button_lsn;
                Pallet_code = pallet_code;
                Error_start_bit = error_start_bit;
                Error_start = error_start;
                Error_start_lsn = error_start_lsn;
                Error_block_start_device_bit = error_block_start_device_bit;
                Error_block_start_device = error_block_start_device;
                Error_block_start_device_lsn = error_block_start_device_lsn;
                Error_block_end_device_bit = error_block_end_device_bit;
                Error_block_end_device = error_block_end_device;
                Error_block_end_device_lsn = error_block_end_device_lsn;
                Error_mmc_start_device_bit = error_mmc_start_device_bit;
                Error_mmc_start_device = error_mmc_start_device;
                Error_mmc_start_device_lsn = error_mmc_start_device_lsn;
                Error_mmc_end_device_bit = error_mmc_end_device_bit;
                Error_mmc_end_device = error_mmc_end_device;
                Error_mmc_end_device_lsn = error_mmc_end_device_lsn;
                Error_report_bit = error_report_bit;
                Error_report = error_report;
                Error_report_lsn = error_report_lsn;
                Existence_bit = existence_bit;
                Existence = existence;
                Existence_lsn = existence_lsn;
                Signal_name = signal_name;
                this.load0_bit = load0_bit;
                this.load0 = load0;
                this.load0_lsn = load0_lsn;
                this.load1_bit = load1_bit;
                this.load1 = load1;
                this.load1_lsn = load1_lsn;
                this.load2_bit = load2_bit;
                this.load2 = load2;
                this.load2_lsn = load2_lsn;
                this.load3_bit = load3_bit;
                this.load3 = load3;
                this.load3_lsn = load3_lsn;
                this.load4_bit = load4_bit;
                this.load4 = load4;
                this.load4_lsn = load4_lsn;
                this.load5_bit = load5_bit;
                this.load5 = load5;
                this.load5_lsn = load5_lsn;
                this.load6_bit = load6_bit;
                this.load6 = load6;
                this.load6_lsn = load6_lsn;
                this.load7_bit = load7_bit;
                this.load7 = load7;
                this.load7_lsn = load7_lsn;
                Device_num = device_num;
        }

        private String load1_bit;
        private String load1;
        private Integer load1_lsn;
        private String load2_bit;
        private String load2;
        private Integer load2_lsn;
        private String load3_bit;
        private String load3;
        private Integer load3_lsn;
        private String load4_bit;
        private String load4;
        private Integer load4_lsn;
        private String load5_bit;
        private String load5;
        private Integer load5_lsn;
        private String load6_bit;
        private String load6;
        private Integer load6_lsn;
        private String load7_bit;
        private String load7;
        private Integer load7_lsn;
        private String Device_num;



        public FileReadDomin() {}


}
