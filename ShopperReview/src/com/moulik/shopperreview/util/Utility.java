package com.moulik.shopperreview.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.Window;

public class Utility {

	public static int getStatusBarHeight(Activity ac) {
		Rect rectangle = new Rect();
		Window window = ac.getWindow();
		window.getDecorView().getWindowVisibleDisplayFrame(rectangle);
		int statusBarHeight = rectangle.top;
		return statusBarHeight;
	}

	public static int getTitleBarHeight(Activity ac) {
		Window window = ac.getWindow();
		int contentViewTop= 
			    window.findViewById(Window.ID_ANDROID_CONTENT).getTop();
			int titleBarHeight= contentViewTop - getStatusBarHeight(ac);
			return titleBarHeight;
	}
}
