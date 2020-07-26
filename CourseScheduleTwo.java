package main.java.com.leetcode;

import java.util.*;

public class CourseScheduleTwo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCourses = scanner.nextInt();
        int numPrerequisites = scanner.nextInt();
        int[][] prerequisites = new int[numPrerequisites][2];
        for(int i=0;i<prerequisites.length;i++)
            for (int j=0;j<prerequisites[i].length;j++)
                prerequisites[i][j] = scanner.nextInt();
        int[] order = prerequisites(numCourses,prerequisites);
        for(int x:order)
            System.out.print(x + " ");
    }

    private static int[] prerequisites(int numCourses, int[][] prerequisites) {
        Stack<Integer> orderStack = new Stack<Integer>();
        boolean[] visitedNodes = new boolean[numCourses];
        for(int i=0;i<visitedNodes.length;i++){
            if(!visitedNodes[i]){
                visitedNodes[i] = true;
                topologicalSort(i,visitedNodes,orderStack,prerequisites);
                orderStack.push(i);
            }
        }
        int[] order = new int[orderStack.size()];
        for(int i=0;i<order.length;i++)
            order[i] = orderStack.pop();
        return order;
    }



    private static void topologicalSort(int node,boolean[] visitedNodes,
                                        Stack<Integer> orderStack,int[][] prerequisites) {
        List<Integer> adjList = getAdjList(node,prerequisites,visitedNodes);
        for(int adjNodes : adjList){
            if(!visitedNodes[adjNodes]){
                visitedNodes[adjNodes] = true;
                topologicalSort(adjNodes,visitedNodes,orderStack,prerequisites);
                orderStack.push(adjNodes);
            }
        }
    }

    private static List<Integer> getAdjList(int node, int[][] prerequisites,
                                            boolean[] visitedNodes) {
        List<Integer> adjList = new ArrayList<>();
        for(int i=0;i<prerequisites.length;i++){
            if(prerequisites[i][1] == node && !visitedNodes[prerequisites[i][0]])
                adjList.add(prerequisites[i][0]);
        }
        return adjList;
    }
}