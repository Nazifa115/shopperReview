package com.ls.list.customization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.moulik.shopperreview.R;

public class AdapterItemVO
{
	private static final List<AdapterItemVO> SAMPLE_ITEMS; 
	static{		
		final List<AdapterItemVO> sampleList = new ArrayList<AdapterItemVO>();
		sampleList.add(new AdapterItemVO("Item 1",R.drawable.sample_1));
		sampleList.add(new AdapterItemVO("Item 2",R.drawable.sample_2));
		sampleList.add(new AdapterItemVO("Item 3",R.drawable.sample_3));
		sampleList.add(new AdapterItemVO("Item 4",R.drawable.sample_4));
		sampleList.add(new AdapterItemVO("Item 5",R.drawable.sample_5));
		sampleList.add(new AdapterItemVO("Item 6",R.drawable.sample_6));
		sampleList.add(new AdapterItemVO("Item 7",R.drawable.sample_7));
		SAMPLE_ITEMS = Collections.unmodifiableList(sampleList);
	}
	
	public final static List<AdapterItemVO> getSampleItemList()
	{
		return SAMPLE_ITEMS;
	}
	
	private String title;
	private int imageId;
	
	
	public AdapterItemVO(final String theTitle,int theImageId)
	{
		this.title = theTitle;
		this.imageId = theImageId;
	}
	
	public String getTitle()
	{
		return title;
	}
	public int getImageId()
	{
		return imageId;
	}	
}
