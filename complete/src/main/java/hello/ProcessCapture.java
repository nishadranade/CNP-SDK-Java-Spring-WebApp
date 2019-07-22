package hello;
//package com.cnp.sdk.samples;

import java.io.StringWriter;
import java.util.Properties;
import javax.xml.bind.JAXB;

import com.cnp.sdk.*;
import com.cnp.sdk.generate.*;
import com.cnp.sdk.generate.MethodOfPaymentTypeEnum;

public class ProcessCapture {
    private static CnpOnline cnp;
    private String xmlCaptureResponse;
    private String xmlAuthResponse;

    public void configure(Greeting g) {
        Properties config = new Properties();
        config.setProperty("url", g.getUrl());
        if (g.getProxyHost() != null) {
            config.setProperty("proxyHost", g.getProxyHost());
        }
        if (g.getProxyPort() != null) {
            config.setProperty("proxyPort", g.getProxyPort().toString());
        }
        config.setProperty("username", g.getUser());
        config.setProperty("password", g.getPassword());
        config.setProperty("merchantId", g.getMerchantId());
        config.setProperty("printxml", "true");
        cnp = new CnpOnline(config);
    }

    // // @BeforeClass
    // public static void beforeClass() throws Exception {
    // cnp = new CnpOnline();
    // }

    public AuthorizationResponse simpleAuth(Greeting g) {
        Authorization authorization = new Authorization();
        authorization.setReportGroup(g.getAuthReportGroup());
        authorization.setAmount(Long.parseLong(g.getAuthAmount()));

        authorization.setOrderSource(OrderSourceType.valueOf(g.getAuthOrderSource().toUpperCase()));
        authorization.setOrderId(g.getOrderId());
        authorization.setId(g.getAuthId());
        CardType card = new CardType();

        card.setNumber(g.getCardNumber());
        card.setType(MethodOfPaymentTypeEnum.valueOf(g.getCardType().toUpperCase()));
        card.setExpDate(g.getExpirationDate());
        authorization.setCard(card);

        AuthorizationResponse response = cnp.authorize(authorization);

        StringWriter sw = new StringWriter();
        JAXB.marshal(response, sw);
        this.setXmlAuthResponse(sw.toString());
        return response;
    }

    public CaptureResponse simpleCapture(Greeting g) {
        Capture capture = new Capture();

        capture.setCnpTxnId(Long.parseLong(g.getCnpTxnId()));
        capture.setAmount(Long.parseLong(g.getCaptureAmount()));
        capture.setId(g.getCaptureId());
        capture.setReportGroup(g.getCaptureReportGroup());

        CaptureResponse response = cnp.capture(capture);
        StringWriter sw = new StringWriter();
        JAXB.marshal(response, sw);
        this.setXmlCaptureResponse(sw.toString());
        return response;
    }

    public String toString() {
        return this.xmlCaptureResponse;
    }

    public String getXmlCaptureResponse() {
        if (this.xmlCaptureResponse == null) {
            return "No Capture Request Sent";
        }
        return this.xmlCaptureResponse;
    }

    public void setXmlCaptureResponse(String xmlCaptureResponse) {
        this.xmlCaptureResponse = xmlCaptureResponse;
    }

    public String getXmlAuthResponse() {
        if (this.xmlAuthResponse == null) {
            return "No Auth Request Sent";
        }
        return this.xmlAuthResponse;
    }

    public void setXmlAuthResponse(String xmlAuthResponse) {
        this.xmlAuthResponse = xmlAuthResponse;
    }

}

// instantiate a cnpOnline object using new cnpOnline(config)
// after that do the capture