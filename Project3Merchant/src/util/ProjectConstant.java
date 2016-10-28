package util;

public class ProjectConstant {
	public static final String JMS_URL = "failover://tcp://zha-ita076-w7:61616";
	public static final String JMS_QUEUE_NEW_MERCHENT = "Q_NEW_MERCHENT";
	public static final String JMS_QUEUE_COMPLAIN = "Q_COMPLAIN";

	public static final String USERTYPE_MERCHANT = "Merchant";
	public static final String USERTYPE_ADMIN = "Admin";
	public static final String USERTYPE_CUSTOMER = "Customer";

	public static final String STATUS_ACCEPTED="Accepted";
	public static final String STATUS_REJECTED="Rejected";
	public static final String STATUS_FORZEN="Forzen";
	public static final String STATUS_UNDERREVIEW="UnderReview";
	public static final String STATUS_DELETED="Deleted";

	public static final String DELIVERY_STATUS_ORDERED="Ordered";
	public static final String DELIVERY_STATUS_DELIVERED="Delivered";
	public static final String DELIVERY_STATUS_RECEIVED="Received";
	public static final String DELIVERY_STATUS_CANCELED="Canceled";

	public static final String SESSION_ATTRIBUTE_CUSTOMER="Customer";
	public static final String SESSION_ATTRIBUTE_CUSTOMER_ID="CustomerID";
	public static final String SESSION_ATTRIBUTE_MERCHANT="Merchant";
	public static final String SESSION_ATTRIBUTE_MERCHANT_ID="CustomerID";
	public static final String SESSION_ATTRIBUTE_ADMIN="Admin";
	public static final String SESSION_ATTRIBUTE_SHOPPING_CART="ShoppingCart";

	public static final String CATEGORY_WESTERN="Western";
	public static final String CATEGORY_CHINESE="Chinese";
	public static final String CATEGORY_JAPANESE="Japanese";
	public static final String CATEGORY_KOREAN="Korean";
	public static final String CATEGORY_ASIAN="Asian";
	
	public static final String CHOOSE_ADV_WS_URL = "http://localhost:8080/Project3Admin/chooseAdvert";
	
}
