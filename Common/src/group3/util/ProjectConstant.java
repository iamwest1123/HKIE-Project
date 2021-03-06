package group3.util;

public class ProjectConstant {
	public static final String DB_USERNAME= "CANDY001";
	public static final String DB_PASSWORD= "123";
	public static final String DB_URL= "jdbc:oracle:thin:@ITA-031-W7.corp.oocl.com:1521:XE";
	public static final String DB_DRIVER_CLASSNAME= "oracle.jdbc.OracleDriver";
	
	public static final String JMS_URL = "failover://tcp://zha-ita076-w7:61616";
	public static final String JMS_QUEUE_NEW_MERCHENT = "Q_NEW_MERCHENT";

	public static final String USERTYPE_MERCHENT = "MERCHENT";
	public static final String USERTYPE_ADMIN = "ADMIN";
	public static final String USERTYPE_CUSTOMER = "CUSTOMER";

	public static final String MERCHANT_STATUS_ACCEPTED="Accepted";
	public static final String MERCHANT_STATUS_REJECTED="Rejected";
	public static final String MERCHANT_STATUS_FORZEN="Forzen";
	public static final String MERCHANT_STATUS_UNDERREVIEW="UnderReview";
	public static final String MERCHANT_STATUS_DELETED="Deleted";

	public static final String SESSION_ATTRIBUTE_USERID="UserId";
	public static final String SESSION_ATTRIBUTE_USERNAME="UserName";
	public static final String SESSION_ATTRIBUTE_USERTYPE="UserType";

	public static final String UI_LOGIN = "loginMainPage.jsp";
	public static final String UI_LOGIN_AS = "loginAs.jsp";
	
}
