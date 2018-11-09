package com.thizzle.server.dto.requests;

import java.util.List;

public class PredictNumberRq {
	
	private Integer canvasWidth;
	private Integer canvasHeight;
	private List<Integer> xPositions;
	private List<Integer> yPositions;
	
	public PredictNumberRq() {
		
	}

	public Integer getCanvasWidth() {
		return canvasWidth;
	}

	public void setCanvasWidth(Integer canvasWidth) {
		this.canvasWidth = canvasWidth;
	}

	public Integer getCanvasHeight() {
		return canvasHeight;
	}

	public void setCanvasHeight(Integer canvasHeight) {
		this.canvasHeight = canvasHeight;
	}

	public List<Integer> getxPositions() {
		return xPositions;
	}

	public void setxPositions(List<Integer> xPositions) {
		this.xPositions = xPositions;
	}

	public List<Integer> getyPositions() {
		return yPositions;
	}

	public void setyPositions(List<Integer> yPositions) {
		this.yPositions = yPositions;
	}

}
