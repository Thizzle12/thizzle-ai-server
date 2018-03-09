package com.example.thizzle.ai.algorithms;

import java.util.List;

public interface Node {
	
	
	public Node getCameFrom();
	public void setCameFrom(Node neighbour);
	public List<Node> getEdges();
	public int getGScore();
	public void setGScore(int gScore);
	public int getFScore();
	public void setFScore(int fScore);
	

}
