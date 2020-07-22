import java.util.*;
import java.io.*;
// This was made by a student (Nihal Shivannagari) so take everything with a grain of salt. Although all the code has been tested, there may still be errors and 
//bugs that need to be fixed please let me know if you find any. If you come across and issue during a competitive programming contest, you may customize the 
//code independently and let me know later. I will try to get the issue fixed as soon as possible. Most of the classes are made with Integer in mind. If this 
//is an issue or you want to see a more broad variety of variables that can be housed, please let me know and I will try to expand the options available.
public class DataStructures
{
	public DataStructures()
	{/*this class houses a bunch of nested classes*/}
	
	public class DirectedGraph
	{
		private int points;
		private ArrayList<Integer>[] originConnections;
		private ArrayList<Integer>[] destinationConnections;
		private boolean[][] adjacencyMatrix;
		public DirectedGraph(int points)
		{
			this.points=points;
			originConnections=new ArrayList[points];
			destinationConnections=new ArrayList[points];
			for(int x=0;x<points;x++)
			{originConnections[x]=new ArrayList<Integer>();
			destinationConnections[x]=new ArrayList<Integer>();}
			adjacencyMatrix=new boolean[points][points];
		}
		public void addConnection(int origin,int destination)
		{
			//finding the location to input new connections
			origin--;destination--;
			BasicAlgos b=new BasicAlgos();
			int x=0;
			if(originConnections[origin].size()>0)
			{x=b.indexOfClosestValue(originConnections[origin],destination);
			if(originConnections[origin].get(x)==destination)
			{return;}
			if(originConnections[origin].get(x)>destination)
			{x--;}}
			int y=0;
			if(destinationConnections[destination].size()>0)
			{y=b.indexOfClosestValue(destinationConnections[destination],origin);
			if(destinationConnections[destination].get(y)>origin)
			{y--;}}
			
			//inputing the connection
			originConnections[origin].add(x,destination);
			destinationConnections[destination].add(y,origin);
			adjacencyMatrix[origin][destination]=true;
		}
		
		//retrieval methods
		public ArrayList<Integer>[] getOriginConnections()
		{return originConnections;}
		public ArrayList<Integer>[] getDestinationConnections()
		{return destinationConnections;}
		public boolean[][] getAdjacencyMatrix()
		{return adjacencyMatrix;}
		
		public boolean isAcyclic()
		{
			{ 
		        // Create a array to store 
		        // indegrees of all 
		        // vertices. Initialize all 
		        // indegrees as 0. 
		        int indegree[] = new int[points]; 
		  
		        // Traverse adjacency lists 
		        // to fill indegrees of 
		        // vertices. This step takes 
		        // O(V+E) time 
		        for (int i = 0; i < points; i++) { 
		            ArrayList<Integer> temp 
		                = (ArrayList<Integer>)originConnections[i]; 
		            for (int node : temp) { 
		                indegree[node]++; 
		            } 
		        } 
		  
		        // Create a queue and enqueue 
		        // all vertices with indegree 0 
		        Queue<Integer> q 
		            = new LinkedList<Integer>(); 
		        for (int i = 0; i < points; i++) { 
		            if (indegree[i] == 0) 
		                q.add(i); 
		        } 
		  
		        // Initialize count of visited vertices 
		        int cnt = 0; 
		  
		        // Create a vector to store result 
		        // (A topological ordering of the vertices) 
		        Vector<Integer> topOrder = new Vector<Integer>(); 
		        while (!q.isEmpty()) { 
		            // Extract front of queue 
		            // (or perform dequeue) 
		            // and add it to topological order 
		            int u = q.poll(); 
		            topOrder.add(u); 
		  
		            // Iterate through all its 
		            // neighbouring nodes 
		            // of dequeued node u and 
		            // decrease their in-degree 
		            // by 1 
		            for (int node : originConnections[u]) { 
		                // If in-degree becomes zero, 
		                // add it to queue 
		                if (--indegree[node] == 0) 
		                    q.add(node); 
		            } 
		            cnt++; 
		        } 
		  
		        // Check if there was a cycle 
		        if (cnt != points) { return false;} 
		        else
		        {return true;}
		    } 
		}
		
		public ArrayList<Integer> topologicalSort()
		{
			{ 
		        // Create a array to store 
		        // indegrees of all 
		        // vertices. Initialize all 
		        // indegrees as 0. 
		        int indegree[] = new int[points]; 
		  
		        // Traverse adjacency lists 
		        // to fill indegrees of 
		        // vertices. This step takes 
		        // O(V+E) time 
		        for (int i = 0; i < points; i++) { 
		            ArrayList<Integer> temp 
		                = (ArrayList<Integer>)originConnections[i]; 
		            for (int node : temp) { 
		                indegree[node]++; 
		            } 
		        } 
		  
		        // Create a queue and enqueue 
		        // all vertices with indegree 0 
		        Queue<Integer> q 
		            = new LinkedList<Integer>(); 
		        for (int i = 0; i < points; i++) { 
		            if (indegree[i] == 0) 
		                q.add(i); 
		        } 
		  
		        // Initialize count of visited vertices 
		        int cnt = 0; 
		  
		        // Create a vector to store result 
		        // (A topological ordering of the vertices) 
		        Vector<Integer> topOrder = new Vector<Integer>(); 
		        while (!q.isEmpty()) { 
		            // Extract front of queue 
		            // (or perform dequeue) 
		            // and add it to topological order 
		            int u = q.poll(); 
		            topOrder.add(u); 
		  
		            // Iterate through all its 
		            // neighboring nodes 
		            // of dequeued node u and 
		            // decrease their in-degree 
		            // by 1 
		            for (int node : originConnections[u]) { 
		                // If in-degree becomes zero, 
		                // add it to queue 
		                if (--indegree[node] == 0) 
		                    q.add(node); 
		            } 
		            cnt++; 
		        } 
		  
		        // Check if there was a cycle 
		        if (cnt != points) { 
		            return null;
		        } 
		  
		        ArrayList<Integer>sol=new ArrayList<Integer>();
		        for (int i : topOrder) { 
		            sol.add(i+1); 
		        } 
		        return sol;
		    } 
		}
	}
	public class Tree
	{
		private int pointVal;
		private Tree parent;
		private ArrayList<Tree> leaves;
		
		//if this node is the original, set parent to null
		public Tree(int value,Tree parent)
		{
			pointVal=value;
			this.parent=parent;
			leaves=new ArrayList<Tree>();
		}
		public void addLeaf(int value)
		{
			leaves.add(new Tree(value,this));
		}
		public void addBranch(Tree branch)
		{
			branch.parent=this;
			leaves.add(branch);
		}
		
		//this is a Depth First Search
		//this will not search for anything that is not contained with this Tree's leaves or lower
		public boolean contains(int value)
		{
			if(pointVal==value)
			{return true;}
			for(int x=0;x<leaves.size();x++)
			{
				if(leaves.get(x).contains(value))
				{return true;}
			}
			return false;
		}
	}
	
	//this is extremely primitive and isn't very spatially efficient
	public class PrimitiveMap
	{
		private int maximum;
		private int minimum;
		private int[] map;
		
		//gap between max value and min value must be under 2*10^9
		public PrimitiveMap(int maxValue,int minValue)
		{
			maximum=maxValue;
			minimum=minValue;
			map=new int[maximum-minimum+1];
		}
		
		//returns how many of this value there are
		public int contains(int value)
		{
			return map[value-minimum];
		}
		
		//can't add over 2*10^9 of the same value
		public  void add(int value)
		{
			map[value-minimum]++;
		}
		
		//will return how many of that value is left
		//if a value is removed when there is nothing there, nothing will happen
		public int remove(int value)
		{
			if(map[value-minimum]>0)
			{map[value-minimum]--;}
			return map[value-minimum];
		}
	}
	
	//tuple super simple and kind of pointless but makes life easier
	public class Tuple implements Comparable<Tuple>
	{
		private int count;
		private int key;
		private int[] values;
		
		public Tuple(int count,int key)
		{this.count=count;this.key=key;values=new int[count];}
		public Tuple(int count)
		{this.count=count;this.key=0;values=new int[count];}
		
		public void setKey(int key)
		{this.key=key;}
		public int getKey()
		{return key;}
		public int getValue(int index)
		{return values[index];}
		public void setValue(int index,int value)
		{values[index]=value;}
		
		//for the tupleListSort method to function properly
		public int compareTo(Tuple t)
		{
			return values[key]-t.values[t.key];
		}
		public String toString()
		{BasicAlgos ba=new BasicAlgos(); return ba.arrayToString(values);}
	}
	
	//for a normal queue just leave the value at index 1 as the same number for all tuples
	//higher value rank is better
	public class PriorityQueue
	{
		private ArrayList<Integer> queue;
		private ArrayList<Integer> priority;
		public PriorityQueue()
		{
			queue=new ArrayList<Integer>();priority=new ArrayList<Integer>();
		}
		public void enqueue(int value,int rank)
		{
			DataStructures ds=new DataStructures();
			BasicAlgos ba=ds.new BasicAlgos();
			int k=ba.indexOfClosestValue(priority, rank);
			while(k>=0&&priority.get(k)>=rank)
			{k--;}
			k++;queue.add(k,value);priority.add(k,rank);
		}
		public Tuple dequeue()
		{
			Tuple t=new Tuple(2,1);
			t.setValue(0,queue.remove(queue.size()-1));
			t.setValue(1,priority.remove(priority.size()-1));
			return t;
		}
	}
	
	//used for basic coding in the class and can be implemented by users
	public class BasicAlgos
	{
		public BasicAlgos()
		{/*Just to access the methods*/}
		public int indexOfClosestValue(ArrayList<Integer>list,int target)
		{
			int low=0;int high=list.size()-1;

			//edge cases
			if(list.get(0)>target) {return 0;}
			if(list.get(high)<target) {return high;}

			//find index of closest value less than target
			int sol=0;
			while(low<=high)
			{
				if(low==high)
				{sol=low;break;}

				int med=(low+high)/2;
				if(list.get(med)<target&&list.get(med+1)>target)
				{sol=med;break;}
				else if(list.get(med)<target&&list.get(med+1)<target)
				{low=med+1;}
				else if(list.get(med)>target&&list.get(med+1)>target)
				{high=med-1;}
			}

			if(sol<high&&list.get(sol+1)-target<target-list.get(sol))
			{return sol+1;}
			else
			{return sol;}
		}
		public String arrayToString(int[]array)
		{
			String sol="[";
			sol+=array[0];
			for(int x=1;x<array.length;x++)
			{sol+=(", "+array[x]);}
			return sol+"]";
		}
		public void tupleListSort(ArrayList<Tuple>list,int key)
		{
			for(int x=0;x<list.size();x++)
			{
				list.get(x).setKey(key);
			}
			Collections.sort(list);
		}
	}
}
