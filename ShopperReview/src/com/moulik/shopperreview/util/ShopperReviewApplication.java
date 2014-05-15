package com.moulik.shopperreview.util;

import android.app.Application;
import android.content.Context;

public class ShopperReviewApplication extends Application {

	private static ShopperReviewApplication instance = null;

	private ShopperReviewApplication() {
		instance = this;
	}

	public static Context getInstance() {
		if (null == instance) {
			instance = new ShopperReviewApplication();
		}

		return instance;
	}
}
