package lecture30thApril;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class Graph {
	private class Vertex {
		String vname;
		HashMap<String, Integer> neighbours;

		Vertex(String name) {
			this.vname = name;
			this.neighbours = new HashMap<>();
		}

	}

	private HashMap<String, Vertex> vertices;

	public Graph() {
		this.vertices = new HashMap<>();
	}

	public int numVertices() {
		return this.vertices.size();
	}

	public boolean ContainsVertex(String vname) {
		return this.vertices.containsKey(vname);
	}

	public void addVertex(String vname) {
		if (this.ContainsVertex(vname)) {
			return;
		}

		Vertex vtx = new Vertex(vname);
		this.vertices.put(vname, vtx);

	}

	public void removeVertex(String vname) {
		if (!this.ContainsVertex(vname)) {
			return;
		}

		Vertex vtx = this.vertices.get(vname);
		Set<String> nbrnames = vtx.neighbours.keySet();

		for (String nbrname : nbrnames) {
			Vertex nbrremove = this.vertices.get(nbrname);
			nbrremove.neighbours.remove(vname);

		}
		this.vertices.remove(vname);
	}

	public int numEdges() {
		int rv = 0;
		Set<String> vnames = this.vertices.keySet();

		for (String vname : vnames) {
			Vertex vtx = this.vertices.get(vname);
			rv += vtx.neighbours.size();
		}
		rv = rv / 2;
		return rv;
	}

	public boolean containsEdge(String v1name, String v2name) {
		Vertex vtx1 = this.vertices.get(v1name);
		Vertex vtx2 = this.vertices.get(v2name);

		if (vtx1 == null || vtx2 == null) {
			return false;
		}
		return vtx1.neighbours.containsKey(v2name);

	}

	public void addEdge(String v1name, String v2name, int cost) {
		Vertex vtx1 = this.vertices.get(v1name);
		Vertex vtx2 = this.vertices.get(v2name);

		if (vtx1 == null || vtx2 == null) {
			return;
		}

		vtx1.neighbours.put(v2name, cost);
		vtx2.neighbours.put(v1name, cost);
	}

	public void removeEdge(String v1name, String v2name) {
		Vertex vtx1 = this.vertices.get(v1name);
		Vertex vtx2 = this.vertices.get(v2name);

		if (vtx1 == null || vtx2 == null) {
			return;
		}

		vtx1.neighbours.remove(v2name);
		vtx2.neighbours.remove(v1name);

	}

	public void display() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		Set<String> vnames = this.vertices.keySet();

		for (String vname : vnames) {
			String ans = vname + "=>";
			Vertex vetx = this.vertices.get(vname);
			Set<String> nbrnames = vetx.neighbours.keySet();
			for (String nbrname : nbrnames) {
				ans += nbrname + "[" + vetx.neighbours.get(nbrname) + "]";
			}
			ans = ans + "END";

			System.out.println(ans);

		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	// this code is of depth first search
	public boolean HasPathFrom(String v1name, String v2name) {

		Vertex vtx1 = this.vertices.get(v1name);
		Vertex vtx2 = this.vertices.get(v2name);

		if (vtx1 == null || vtx2 == null) {
			return false;
		}

		HashMap<String, Boolean> processed = new HashMap();
		return HasPathFrom(vtx1, vtx2, processed);

	}

	private boolean HasPathFrom(Vertex vtx1, Vertex vtx2, HashMap<String, Boolean> processed) {

		if (processed.containsKey(vtx1.vname)) {
			return false;
		}
		processed.put(vtx1.vname, true);

		if (vtx1.neighbours.containsKey(vtx2.vname)) {
			return true;
		}

		Set<String> nbrsnames = vtx1.neighbours.keySet();
		for (String nbrsname : nbrsnames) {
			Vertex vtex = this.vertices.get(nbrsname);
			if (HasPathFrom(vtex, vtx2, processed)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasPathBFS(String v1name, String v2name) {
		Vertex vtx1 = this.vertices.get(v1name);
		Vertex vtx2 = this.vertices.get(v2name);

		if (vtx1 == null || vtx2 == null) {
			return false;
		}

		return hasPathBFS(vtx1, vtx2);
	}

	private boolean hasPathBFS(Vertex vtx1, Vertex vtx2) {
		LinkedList<Vertex> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		queue.addLast(vtx1);

		while (!queue.isEmpty()) {
			Vertex temp = queue.removeFirst();
			if (!processed.containsKey(vtx1)) {
				processed.put(temp.vname, true);

			}

			if (temp.neighbours.containsKey(vtx2.vname)) {
				return true;
			}

			Set<String> nbrsnames = vtx1.neighbours.keySet();
			for (String nbrsname : nbrsnames) {
				Vertex vtex = this.vertices.get(nbrsname);
				queue.addLast(vtex);
			}

		}
		return false;
	}

	public boolean hasPathBFS1(String v1name, String v2name) {
		Vertex vtx1 = this.vertices.get(v1name);
		Vertex vtx2 = this.vertices.get(v2name);

		if (vtx1 == null || vtx2 == null) {
			return false;
		}

		return hasPathBFS1(vtx1, vtx2);
	}

	private boolean hasPathBFS1(Vertex vtx1, Vertex vtx2) {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		Pair p = new Pair();
		p.vtx = vtx1;
		p.psf = "";
		queue.addLast(p);

		while (!queue.isEmpty()) {
			Pair temp = queue.removeFirst();
			if (!processed.containsKey(vtx1)) {
				processed.put(temp.vtx.vname, true);

			}

			if (temp.vtx.neighbours.containsKey(vtx2.vname)) {
				System.out.println(temp.psf + temp.vtx.vname + vtx2.vname);
				return true;
			}

			Set<String> nbrsnames = temp.vtx.neighbours.keySet();
			for (String nbrsname : nbrsnames) {

				if (!processed.containsKey(nbrsname)) {
					Vertex vtex = this.vertices.get(nbrsname);
					Pair np = new Pair();
					np.vtx = vtex;
					np.psf = temp.psf + temp.vtx.vname;

					queue.addLast(np);
				}
			}

		}
		return false;
	}

	private class Pair {
		Vertex vtx;
		String psf;
	}

	public boolean HasPath(String v1name, String v2name) {

		Vertex vtx1 = this.vertices.get(v1name);
		Vertex vtx2 = this.vertices.get(v2name);

		if (vtx1 == null || vtx2 == null) {
			return false;
		}

		HashMap<String, Boolean> processed = new HashMap();
		return HasPath(vtx1, vtx2, processed, "");

	}

	private boolean HasPath(Vertex vtx1, Vertex vtx2, HashMap<String, Boolean> processed, String osf) {

		if (processed.containsKey(vtx1.vname)) {
			return false;
		}
		processed.put(vtx1.vname, true);
		osf = osf + vtx1.vname;

		if (vtx1.neighbours.containsKey(vtx2.vname)) {
			System.out.println(osf + vtx2.vname);
			return true;
		}

		Set<String> nbrsnames = vtx1.neighbours.keySet();
		for (String nbrsname : nbrsnames) {
			Vertex vtex = this.vertices.get(nbrsname);
			if (HasPath(vtex, vtx2, processed, osf)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasPathDFS(String v1name, String v2name) {
		Vertex vtx1 = this.vertices.get(v1name);
		Vertex vtx2 = this.vertices.get(v2name);

		if (vtx1 == null || vtx2 == null) {
			return false;
		}

		return hasPathDFS(vtx1, vtx2);
	}

	private boolean hasPathDFS(Vertex vtx1, Vertex vtx2) {
		LinkedList<Pair> stack = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		Pair p = new Pair();
		p.vtx = vtx1;
		p.psf = "";
		stack.addFirst(p);

		while (!stack.isEmpty()) {
			Pair temp = stack.removeFirst();
			if (!processed.containsKey(vtx1)) {
				processed.put(temp.vtx.vname, true);

			}

			if (temp.vtx.neighbours.containsKey(vtx2.vname)) {
				System.out.println(temp.psf + temp.vtx.vname + vtx2.vname);
				return true;
			}

			Set<String> nbrsnames = temp.vtx.neighbours.keySet();
			for (String nbrsname : nbrsnames) {

				if (!processed.containsKey(nbrsname)) {
					Vertex vtex = this.vertices.get(nbrsname);
					Pair np = new Pair();
					np.vtx = vtex;
					np.psf = temp.psf + temp.vtx.vname;

					stack.addFirst(np);
				}
			}

		}
		return false;
	}

	public void dft() {
		LinkedList<Pair> stack = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		Set<String> vnames = this.vertices.keySet();
		for (String vname : vnames) {
			if (!processed.containsKey(vname)) {
				Vertex vtx = this.vertices.get(vname);

				Pair p = new Pair();
				p.vtx = vtx;
				p.psf = "";
				stack.addFirst(p);

				while (!stack.isEmpty()) {
					Pair temp = stack.removeFirst();

					if (!processed.containsKey(temp.vtx.vname)) {
						processed.put(temp.vtx.vname, true);

						System.out.println(temp.vtx.vname + "[" + temp.psf + "]");

						Set<String> nbrsnames = temp.vtx.neighbours.keySet();
						for (String nbrsname : nbrsnames) {

							if (!processed.containsKey(nbrsname)) {
								Vertex vtex = this.vertices.get(nbrsname);
								Pair np = new Pair();
								np.vtx = vtex;
								np.psf = temp.psf + temp.vtx.vname;

								stack.addFirst(np);
							}
						}
					}

				}

			}
		}

	}

	public void bft() {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		Set<String> vnames = this.vertices.keySet();
		for (String vname : vnames) {
			if (!processed.containsKey(vname)) {
				Vertex vtx = this.vertices.get(vname);

				Pair p = new Pair();
				p.vtx = vtx;
				p.psf = "";
				queue.addLast(p);

				while (!queue.isEmpty()) {
					Pair temp = queue.removeFirst();

					if (!processed.containsKey(temp.vtx.vname)) {
						processed.put(temp.vtx.vname, true);

						System.out.println(temp.vtx.vname + "[" + temp.psf + "]");

						Set<String> nbrsnames = temp.vtx.neighbours.keySet();
						for (String nbrsname : nbrsnames) {

							if (!processed.containsKey(nbrsname)) {
								Vertex vtex = this.vertices.get(nbrsname);
								Pair np = new Pair();
								np.vtx = vtex;
								np.psf = temp.psf + temp.vtx.vname;

								queue.addLast(np);
							}
						}

					}

				}
			}

		}
	}

	public boolean IsAcyclic() {
		LinkedList<Pair> stack = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		Set<String> vnames = this.vertices.keySet();
		for (String vname : vnames) {
			if (!processed.containsKey(vname)) {
				Vertex vtx = this.vertices.get(vname);

				Pair p = new Pair();
				p.vtx = vtx;
				p.psf = "";
				stack.addFirst(p);

				while (!stack.isEmpty()) {
					Pair temp = stack.removeFirst();

					if (!processed.containsKey(temp.vtx.vname)) {
						processed.put(temp.vtx.vname, true);

						Set<String> nbrsnames = temp.vtx.neighbours.keySet();
						for (String nbrsname : nbrsnames) {

							if (!processed.containsKey(nbrsname)) {
								Vertex vtex = this.vertices.get(nbrsname);
								Pair np = new Pair();
								np.vtx = vtex;
								np.psf = temp.psf + temp.vtx.vname;

								stack.addFirst(np);
							}
						}
					} else {
						return false;

					}

				}
			}

		}
		return true;

	}

	public boolean isConnected() {
		LinkedList<Pair> stack = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		String zvn = this.vertices.keySet().iterator().next();
		Vertex vn = this.vertices.get(zvn);

		Pair p = new Pair();
		p.vtx = vn;
		p.psf = "";
		stack.addFirst(p);

		while (!stack.isEmpty()) {
			Pair temp = stack.removeFirst();
			if (!processed.containsKey(temp.vtx.vname)) {
				processed.put(temp.vtx.vname, true);

				Set<String> nbrsnames = temp.vtx.neighbours.keySet();
				for (String nbrsname : nbrsnames) {

					if (!processed.containsKey(nbrsname)) {
						Vertex vtex = this.vertices.get(nbrsname);
						Pair np = new Pair();
						np.vtx = vtex;
						np.psf = temp.psf + temp.vtx.vname;

						stack.addFirst(np);
					}
				}

			}

		}
		return processed.size() == this.vertices.size();

	}
	
	
}