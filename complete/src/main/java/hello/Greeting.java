package hello;

import com.cnp.sdk.*;
import java.util.Properties;
import com.cnp.sdk.generate.*;

public class Greeting {

    // config variables
    private String url;
    private String proxyHost;
    private Integer proxyPort;
    private String user;
    private String password;
    private String merchantId;

    // simple auth variables
    private String authReportGroup;
    private String orderId;
    private String authAmount; // stored as string because no support for number as input type in form
    private String authOrderSource;
    private String authId;
    private String cardNumber;
    private String expirationDate;
    private String cardType;

    // simple capture variables
    private String captureReportGroup;
    private String cnpTxnId; // stored as a string for same reason as above, actually a Long
    private String captureAmount; // stored as a string for the same reason as above, actually a Long
    private String paypalNotes;
    private String captureId;

    // config settings getters and setters

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProxyHost() {
        return this.proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public Integer getProxyPort() {
        return this.proxyPort;
    }

    public void setProxyPort(Integer proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    // simpleAuth variable getters and setters

    public String getAuthReportGroup() {
        return this.authReportGroup;
    }

    public void setAuthReportGroup(String authReportGroup) {
        this.authReportGroup = authReportGroup;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAuthAmount() {
        return this.authAmount;
    }

    public void setAuthAmount(String authAmount) {
        this.authAmount = authAmount;
    }

    public String getAuthOrderSource() {
        return this.authOrderSource;
    }

    public void setAuthOrderSource(String authOrderSource) {
        this.authOrderSource = authOrderSource;
    }

    public String getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getAuthId() {
        return this.authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return this.cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    // simple capture variables getters and setters

    public String getCaptureReportGroup() {
        return this.captureReportGroup;
    }

    public void setCaptureReportGroup(String captureReportGroup) {
        this.captureReportGroup = captureReportGroup;
    }

    public String getCnpTxnId() {
        return this.cnpTxnId;
    }

    public void setCnpTxnId(String cnpTxnId) {
        this.cnpTxnId = cnpTxnId;
    }

    public String getCaptureAmount() {
        return this.captureAmount;
    }

    public void setCaptureAmount(String captureAmount) {
        this.captureAmount = captureAmount;
    }

    public String getPaypalNotes() {
        return this.paypalNotes;
    }

    public void setPaypalNotes(String paypalNotes) {
        this.paypalNotes = paypalNotes;
    }

    public String getCaptureId() {
        return this.captureId;
    }

    public void setCaptureId(String captureId) {
        this.captureId = captureId;
    }

}
