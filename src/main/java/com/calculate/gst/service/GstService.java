package com.calculate.gst.service;

import com.calculate.gst.models.Gst;

public interface GstService {

	public Gst searchGst(Double amount, String gstType, Double gstPercentage) throws Exception;

}
