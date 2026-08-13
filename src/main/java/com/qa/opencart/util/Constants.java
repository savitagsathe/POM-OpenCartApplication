package com.qa.opencart.util;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {
	public static final String LOGIN_PAGE_UR_VALUE = "account/login";
	public static final String LOGIN_PAGE_TITLE="Account Login";
	public static final String ACCOUNT_PAGE_TITLE ="My Account";
	public static final Duration DEFAULT_TIME_OUT = Duration.ofSeconds(5);
	public static final List<String>EXP_ACCOUNTS_SECTIONS_LIST=new ArrayList<String>(Arrays.asList
			("My Account","My Orders","My Affiliate Account","Newsletter"));
	public static final int IMAC_IMAGE_COUNT = 3;
	public static final String REGISTER_SUCCESS_MESSAGE = "Your Account Has Been Created!";
	public static final String REGISTER_SHEET_NAME = "register";
	

}
