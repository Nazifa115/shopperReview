package com.ls.list;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.ls.list.customization.AdapterItemVO;
import com.ls.list.customization.ThreeDListAdapter;
import com.ls.list.customization.ThreeDListItemView;
import com.ls.list.threed.HighlightedViewContainer;
import com.ls.list.threed.ThreeDListView;
import com.moulik.shopperreview.R;

public class ThreeDListTest extends Activity
{	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.three_d_list);
		initThreeDList();
	}

	private ThreeDListView initThreeDList()
	{
		final ThreeDListView list = (ThreeDListView) this.findViewById(R.id.threeDListView);	
		final ThreeDListAdapter adapter = new ThreeDListAdapter(this);
		adapter.setItems(AdapterItemVO.getSampleItemList());
		list.setAdapter(adapter);
		list.setHighlightViewContainer(new HighlightedViewContainer()
		{
			@Override
			public void performHighlightAction(final View theView)
			{
				ThreeDListItemView selectedView = (ThreeDListItemView) theView;
				if (selectedView != null)
				{
					selectedView.setChecked(true);
				}
			}

			@Override
			public void performDehighlightAction(final View theView)
			{
				ThreeDListItemView deSelectedView = (ThreeDListItemView) theView;
				if (deSelectedView != null)
				{
					deSelectedView.setChecked(false);
				}
			}
		});
		return list;
	}
}