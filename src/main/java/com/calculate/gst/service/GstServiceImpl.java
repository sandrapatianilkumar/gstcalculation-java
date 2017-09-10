package com.calculate.gst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.calculate.gst.Enums.GstType;
import com.calculate.gst.models.Gst;

@Service
public class GstServiceImpl implements GstService {

	@Autowired
	Environment env;

	@Override
	public Gst searchGst(Double amount, String gstType, Double gstPercentage) throws Exception {
		// TODO Auto-generated method stub
		Gst gst = new Gst();
		Double gstAmount = null;
		Double netPrice = null;

		if (gstType.toString().equalsIgnoreCase(env.getProperty("gsttype"))) {
			// Add GST
			gstAmount = (double) Math.round(((amount * gstPercentage) / 100) * 10 / 10);
			netPrice = (double) Math.round((amount + gstAmount) * 10 / 10);
			gstType="ADDGST";
		} else {
			// Remove GST
			gstAmount = (double) Math.round((amount - (amount * (100 / (100 + gstPercentage)))) * 10 / 10);
			netPrice = (double) Math.round((amount - gstAmount) * 10 / 10);
			gstType="REMOVEGST";
		}

		gst.setAmount(amount);
		gst.setGstPercentage(gstPercentage);
		gst.setGstPrice(gstAmount);
		gst.setGstType(GstType.valueOf(gstType));
		gst.setNetPrice(netPrice);
		return gst;
	}

}
