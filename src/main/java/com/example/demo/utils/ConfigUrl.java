package com.example.demo.utils;

import java.net.URL;

public interface ConfigUrl {
    //
    String URL_API = "/api";
    // master
    String URL_MASTER = URL_API + "/master";
    String URL_MASTER_AC_PARTNER = URL_MASTER + "/ac-partner";
    //master service
    String URL_MASTER_SERVICE = URL_API + "/master-service";
    //partner
    String URL_PARTNER = URL_API + "/partner";
    String URL_PARTNER_AC_SERVICE = URL_PARTNER + "/ac-service";
    String URL_REGISTER = URL_PARTNER + "/register";
    //client
    String URL_CLIENT = URL_API + "/client";
    String URL_CLIENT_SEARCH_PARTNER = URL_CLIENT + "/search-partner";
    String URL_CLIENT_PAYMENT = URL_CLIENT + "/payment";
    //general
    String URL_GET_ALL_MASTER_SER = URL_API + "/all-master-service";
    String URL_GET_ALL_PARTNER_SER = URL_API + "/all-partner-service";

//    String URL_CLIENT = URL_API + "/client";

    //finance
    String URL_FINANCE = URL_API + "/finance";
    String URL_FINANCE_GET_PARTNER_INFOR = URL_FINANCE + "/ac-finance";
    String URL_FINANCE_GET_TRANSACTION = URL_FINANCE + "/transaction";

    //transaction




}
