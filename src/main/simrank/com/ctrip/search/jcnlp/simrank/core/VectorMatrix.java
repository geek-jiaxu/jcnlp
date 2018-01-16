package com.ctrip.search.jcnlp.simrank.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ctrip.search.jcnlp.simrank.data.Graph;
import com.ctrip.search.jcnlp.simrank.data.Node;

public class VectorMatrix {
	public class DimVal{
		public int dim;
		public double val;
		public DimVal(int dimension, double value){
			dim = dimension;
			val = value;
		}
	}
	public List<List<DimVal>> Matrix;
	public void Generate_Mat(Graph G){
		Matrix = new ArrayList<List<DimVal>>();
		//[G.nodes.size()*(Config.KSI+1)]
		for (Node n : G.nodes.values()){
			
		}
	}
}

