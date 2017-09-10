package com.calculate.gst.models;

import javax.validation.constraints.NotNull;

import com.calculate.gst.Enums.GstType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gst {
	@JsonProperty("amount")
	@NotNull
	public Double amount;

	@JsonProperty("gstType")
	public GstType gstType;

	@JsonProperty("gstPercentage")
	public Double gstPercentage;

	@JsonProperty("gstPrice")
	public Double gstPrice;

	@JsonProperty("netPrice")
	public Double netPrice;

}
