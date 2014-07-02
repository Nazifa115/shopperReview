package com.moulik.shopperreview.productSearch;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.ls.list.customization.AdapterItemVO;
import com.ls.list.customization.ThreeDListAdapter;
import com.ls.list.customization.ThreeDListItemView;
import com.ls.list.threed.HighlightedViewContainer;
import com.ls.list.threed.ThreeDListView;
import com.moulik.shopperreview.R;

public class ProductSearch extends Activity {

	List<AdapterItemVO> SAMPLE_ITEMS_ME;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.product_search_layout);
		initThreeDList();
	}

	private ThreeDListView initThreeDList() {
		final ThreeDListView list = (ThreeDListView) this
				.findViewById(R.id.threeDListView);
		final ThreeDListAdapter adapter = new ThreeDListAdapter(this);

		SAMPLE_ITEMS_ME = new ArrayList<AdapterItemVO>();
		SAMPLE_ITEMS_ME.add(new AdapterItemVO("Item 1", R.drawable.sample_1));
		SAMPLE_ITEMS_ME.add(new AdapterItemVO("Item 2", R.drawable.sample_2));
		// SAMPLE_ITEMS_ME.add(new AdapterItemVO("Item 3",
		// R.drawable.sample_3));
		// SAMPLE_ITEMS_ME.add(new AdapterItemVO("Item 4",
		// R.drawable.sample_4));
		SAMPLE_ITEMS_ME.add(new AdapterItemVO("Item 5", R.drawable.sample_5));
		SAMPLE_ITEMS_ME.add(new AdapterItemVO("Item 6", R.drawable.sample_6));
		// SAMPLE_ITEMS_ME.add(new AdapterItemVO("Item 7",
		// R.drawable.sample_7));
		// adapter.setItems(AdapterItemVO.getSampleItemList());
		adapter.setItems(SAMPLE_ITEMS_ME);
		list.setAdapter(adapter);
		list.setHighlightViewContainer(new HighlightedViewContainer() {
			@Override
			public void performHighlightAction(final View theView) {
				ThreeDListItemView selectedView = (ThreeDListItemView) theView;
				if (selectedView != null) {
					selectedView.setChecked(true);
				}
			}

			@Override
			public void performDehighlightAction(final View theView) {
				ThreeDListItemView deSelectedView = (ThreeDListItemView) theView;
				if (deSelectedView != null) {
					deSelectedView.setChecked(false);
				}
			}
		});
		return list;
	}

}
