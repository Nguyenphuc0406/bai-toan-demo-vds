package com.example.demo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Data
@PropertySources(@PropertySource("classpath:messages/message_vi.properties"))
@Configuration
public class LocalMessage {
/*
    public static final String ERR_NOT_FOUND = "Không tìm thấy kết quả dữ liệu";
    public static final String ERR_INPUT = "Dữ liệu nhập vào không hợp lệ";
    public static final String SUCCESS_ADD_MASTER_SERVICE = "Thêm dịch vụ mới cho hệ thống thành công";
    public static final String SUCCESS_DELETE_PARTNER = "Xóa đối tác thành công";
    public static final String SUCCESS_ADD_PARTNER = "Thêm đối tác thành công";
    public static final String SUCCESS_PUT_PARTNER = "Sửa đối tác thành công";
    public static final String SUCCESS_ADD_SERVICE = "Thêm dịch vụ thành công";
*/
    @Value("${msg.error.notfound}")
    private String errNotfound;
    @Value("${msg.error.input}")
    private String errInput;
    @Value("${msg.success.add.master}")
    private String sucAddMaster;
    @Value("${msg.success.add.partner}")
    private String sucAddPartner;
    @Value("${msg.success.add.master.service}")
    private String sucAddMasterService;
    @Value("${msg.success.add.partner.service}")
    private String sucAddPartnerService;
    @Value("${msg.success.del.partner}")
    private String sucDelPartner;
    @Value("${msg.success.put.partner}")
    private String sucPutPartner;
}
