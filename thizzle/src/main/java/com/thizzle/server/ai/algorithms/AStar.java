//package  com.thizzle.server.ai.algorithms;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//
//
//public class AStar {
//	
//	
//	
//	public List<Node> aStarSearch(Node start, Node goal) {
//		List<Node> visitedNodes = new ArrayList<Node>();
//		List<Node> edges = new ArrayList<Node>();
//		edges.add(start);
//		
////		double gScore = Double.POSITIVE_INFINITY;
//		start.setGScore(0);
//		
////		double fScore = Double.POSITIVE_INFINITY;
//		start.setFScore(calcHeuristics(start, goal, "additive", "manhattan", "goalcount"));
//		
//		while(!edges.isEmpty()) {
//			Collections.sort(edges,new Comparator<Node>(){
//				   @Override
//				   public int compare(Node n1,Node n2) {
//				     return n1.getFScore() - n2.getFScore();
//				     }
//				 });
//			Node current = edges.get(0);
//			edges.remove(0);
//			visitedNodes.add(current);
//			
//			if(current == goal) {
//				return reconstructPath(current);
//			}
//			
//			for(Node newEdge: current.getEdges()) {
//				if(visitedNodes.contains(newEdge)) {
//					continue;
//				}
//				
//				if(!edges.contains(newEdge)) {
//					edges.add(newEdge);
//				}
//				
//				int tempGScore = current.getGScore() + 1;
//				
//				if(tempGScore >= newEdge.getGScore()) {
//					continue;
//				}
//				current.setCameFrom(newEdge);
//				newEdge.setGScore(tempGScore);
//				newEdge.setFScore(newEdge.getGScore() + calcHeuristics(newEdge, goal, "additive", "manhattan", "goalcount"));
//			}
//		}
//		return null;
//	}
//	
//	
//	private int calcHeuristics(Node startNode, Node goalNode, String heuristicMethod, String heuristic1, String heuristic2){
//		int retValue = 0;
//		
//		if(heuristic1.equalsIgnoreCase("manhattan") || heuristic2.equalsIgnoreCase("manhattan")) {
//			retValue += manhattanDistance(startNode, goalNode);
//		}
//		if(heuristic1.equalsIgnoreCase("goalcount") || heuristic2.equalsIgnoreCase("goalcount")) {
//			retValue += goalCount(startNode, goalNode);
//		}
//		
//		
//		return retValue;
//		
//	}
//	
//	
//	private List<Node> reconstructPath(Node current){
//		List<Node> finalPath = new ArrayList<>();
//		finalPath.add(current);
//		Node nextNode = current;
//		boolean stillAPath = true;
//		while(stillAPath) {
//			finalPath.add(current.getCameFrom());
//			nextNode = current.getCameFrom();
//		}
//		
//		return finalPath;
//		
//	}
//	
//}
//
//
