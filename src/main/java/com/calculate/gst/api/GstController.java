package com.calculate.gst.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calculate.gst.models.Gst;
import com.calculate.gst.service.GstService;

@RestController
@RequestMapping(path = "/gst/")
public class GstController {

	@Autowired
	GstService gstService;

	@CrossOrigin
	@RequestMapping(value = "_search", method = RequestMethod.GET)
	public Gst gstSearch(@RequestParam(value = "amount", required = true) Double amount,
			@RequestParam(value = "gstType", required = false) String gstType,
			@RequestParam(value = "gstPercentage", required = false) Double gstPercentage) throws Exception {
		return gstService.searchGst(amount, gstType, gstPercentage);
	};
}
