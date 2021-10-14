package com.qa.opencart.Utilis;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {
	//static final == constand variblae
	public static final int DEFAULT_TIME_OUT=5;
	public static final String LOGIN_PAGE_TITLE="Account Login";
	public static final String LOGIN_PAGE_URL_VALUE="https://demo.opencart.com/index.php?route=account/account";
	public static final String ACCOUNT_PAGE_TITLE="My Account";
	public static final List<String> EXP_ACCOUNTS_SEC_LIST=new ArrayList<String>(Arrays.asList("My Account","My Orders","My Affiliate Account","Newsletter"));
	public static final int IMAC_IMAGE_COUNT = 3;
	public static final int MAC_BOOK = 4;
	public static final String  REGISTER_SUCCESS_MESSAGE = "Your Account Has Been Created";
	public static final String REGISTER_SHEET_NAME = "register";
}
