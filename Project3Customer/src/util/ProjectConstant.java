package util;

public class ProjectConstant {
	public static final String JMS_URL = "failover://tcp://zha-ita076-w7:61616";
	public static final String JMS_QUEUE_NEW_MERCHENT = "Q_NEW_MERCHENT";
	public static final String JMS_QUEUE_COMPLAIN = "Q_COMPLAIN";

	public static final String USERTYPE_MERCHANT = "Merchant";
	public static final String USERTYPE_ADMIN = "Admin";
	public static final String USERTYPE_CUSTOMER = "Customer";

	public static final String MERCHANT_STATUS_ACCEPTED="Accepted";
	public static final String MERCHANT_STATUS_REJECTED="Rejected";
	public static final String MERCHANT_STATUS_FORZEN="Forzen";
	public static final String MERCHANT_STATUS_UNDERREVIEW="UnderReview";
	public static final String MERCHANT_STATUS_DELETED="Deleted";

	public static final String SESSION_ATTRIBUTE_CUSTOMER="Customer";
	public static final String SESSION_ATTRIBUTE_MERCHANT="Merchant";
	public static final String SESSION_ATTRIBUTE_ADMIN="Admin";
	public static final String SESSION_ATTRIBUTE_SHOPPING_CART="ShoppingCart";

}
