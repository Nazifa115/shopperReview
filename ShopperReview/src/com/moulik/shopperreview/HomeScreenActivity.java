package com.moulik.shopperreview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.capricorn.ArcMenu;
import com.moulik.shopperreview.productSearch.ProductSearch;
import com.moulik.shopperreview.util.SystemUiHider;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class HomeScreenActivity extends Activity {
	/**
	 * Whether or not the system UI should be auto-hidden after
	 * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
	 */
	//private static final boolean AUTO_HIDE = true;

	/**
	 * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
	 * user interaction before hiding the system UI.
	 */
	//private static final int AUTO_HIDE_DELAY_MILLIS = 1500;

	/**
	 * If set, will toggle the system UI visibility upon interaction. Otherwise,
	 * will show the system UI visibility upon interaction.
	 */
	//private static final boolean TOGGLE_ON_CLICK = true;

	/**
	 * The flags to pass to {@link SystemUiHider#getInstance}.
	 */
	//private static final int HIDER_FLAGS = SystemUiHider.FLAG_HIDE_NAVIGATION;

	/**
	 * The instance of the {@link SystemUiHider} for this activity.
	 */
	//private SystemUiHider mSystemUiHider;

	// private View controlsView;
	private ArcMenu arcMenu;
	

	private static final int[] ITEM_DRAWABLES = { R.drawable.white_product,
			R.drawable.shopping_cart_light_gray, R.drawable.store_icon,
			R.drawable.settings, R.drawable.forum };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_home_screen);

		// controlsView = findViewById(R.id.fullscreen_content_controls);
		// final View contentView = findViewById(R.id.fullscreen_content);
		arcMenu = (ArcMenu) findViewById(R.id.fullscreen_content);
		
		initArcMenu(arcMenu, ITEM_DRAWABLES);

		findViewById(R.id.titleText).clearAnimation();
		TranslateAnimation translation;
		translation = new TranslateAnimation(0f, 0F, 0f,
				((getDisplayHeight() / 2) - getDisplayHeight() / 12));
		translation.setStartOffset(500);
		translation.setDuration(2000);
		translation.setFillAfter(false);
		translation.setRepeatCount(1);
		translation.setRepeatMode(Animation.REVERSE);
		translation.setInterpolator(new BounceInterpolator());
		findViewById(R.id.titleText).startAnimation(translation);
		// final Button btn = (Button) findViewById(R.id.home_button);
		// btn.startAnimation(animation);
		// btn.setOnClickListener(new OnClickListener() {
		// @Override
		// public void onClick(final View view) {
		// view.clearAnimation();
		// initArcMenu(arcMenu, ITEM_DRAWABLES);
		// }
		// });

		
		// mSystemUiHider = SystemUiHider.getInstance(this, arcMenu,
		// HIDER_FLAGS);
		// mSystemUiHider.setup();

		// mSystemUiHider
		// .setOnVisibilityChangeListener(new
		// SystemUiHider.OnVisibilityChangeListener() {
		// // Cached values.
		// int mControlsHeight;
		// int mShortAnimTime;
		//
		// @Override
		// @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
		// public void onVisibilityChange(boolean visible) {
		// if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
		// // If the ViewPropertyAnimator API is available
		// // (Honeycomb MR2 and later), use it to animate the
		// // in-layout UI controls at the bottom of the
		// // screen.
		// if (mControlsHeight == 0) {
		// mControlsHeight = controlsView.getHeight();
		// }
		// if (mShortAnimTime == 0) {
		// mShortAnimTime = getResources().getInteger(
		// android.R.integer.config_shortAnimTime);
		// }
		// controlsView
		// .animate()
		// .translationY(visible ? 0 : mControlsHeight)
		// .setDuration(mShortAnimTime);
		// } else {
		// // If the ViewPropertyAnimator APIs aren't
		// // available, simply show or hide the in-layout UI
		// // controls.
		// controlsView.setVisibility(visible ? View.VISIBLE
		// : View.GONE);
		// }
		//
		// if (visible && AUTO_HIDE) {
		// // Schedule a hide().
		// delayedHide(AUTO_HIDE_DELAY_MILLIS);
		// }
		// }
		// });

		// Set up the user interaction to manually show or hide the system UI.
		// arcMenu.setOnClickListener(new View.OnClickListener() {
		// @Override
		// public void onClick(View view) {
		// arcMenu.clearAnimation();
		// if (TOGGLE_ON_CLICK) {
		// mSystemUiHider.toggle();
		// } else {
		// mSystemUiHider.show();
		// }
		// }
		// });

		// Upon interacting with UI controls, delay any scheduled hide()
		// operations to prevent the jarring behavior of controls going away
		// while interacting with the UI.
		// findViewById(R.id.dummy_button).setOnTouchListener(
		// mDelayHideTouchListener);
	}

	private void initArcMenu(ArcMenu menu, int[] itemDrawables) {
		final int itemCount = itemDrawables.length;
		for (int i = 0; i < itemCount; i++) {
			ImageView item = new ImageView(this);
			item.setImageResource(itemDrawables[i]);

			final int position = i;
			menu.addItem(item, new OnClickListener() {

				@Override
				public void onClick(View v) {
					if (position == 0) {
						Intent productIntent = new Intent(getApplicationContext(), ProductSearch.class);
						startActivity(productIntent);
					}
				}
			});
		}
	}

	private int getDisplayHeight() {
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		return metrics.widthPixels;
	}

	// @Override
	// protected void onPostCreate(Bundle savedInstanceState) {
	// super.onPostCreate(savedInstanceState);
	//
	// // Trigger the initial hide() shortly after the activity has been
	// // created, to briefly hint to the user that UI controls
	// // are available.
	// delayedHide(100);
	// }

	/**
	 * Touch listener to use for in-layout UI controls to delay hiding the
	 * system UI. This is to prevent the jarring behavior of controls going away
	 * while interacting with activity UI.
	 */
	// View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener()
	// {
	// @Override
	// public boolean onTouch(View view, MotionEvent motionEvent) {
	// if (AUTO_HIDE) {
	// delayedHide(AUTO_HIDE_DELAY_MILLIS);
	// }
	// return false;
	// }
	// };

	// Handler mHideHandler = new Handler();
	// Runnable mHideRunnable = new Runnable() {
	// @Override
	// public void run() {
	// mSystemUiHider.hide();
	// }
	// };

	/**
	 * Schedules a call to hide() in [delay] milliseconds, canceling any
	 * previously scheduled calls.
	 */
	// private void delayedHide(int delayMillis) {
	// mHideHandler.removeCallbacks(mHideRunnable);
	// mHideHandler.postDelayed(mHideRunnable, delayMillis);
	// }
}
