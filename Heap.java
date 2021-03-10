package lecture1stMay;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {

	private ArrayList<T> data;
	boolean isMin;

	public Heap(Boolean isMin) {
		this.data = new ArrayList<>();
		this.isMin = isMin;
	}

	public T getHP() {
		return this.data.get(0);

	}

	public void add(T item) {
		this.data.add(item);
		this.upheapify(this.data.size() - 1);
	}

	private void upheapify(int ci) {

		if (ci == 0) {
			return;
		}

		int pi = (ci - 1) / 2;
		if (this.isHP(ci, pi)) {
			this.swap(ci, pi);
			this.upheapify(pi);
		}

	}

	private boolean isHP(int i, int j) {
		T ith = this.data.get(i);
		T jth = this.data.get(j);

		if (isMin) {
			if (ith.compareTo(jth) > 0) {
				return false;
			} else {
				return true;
			}
		} else {
			if (ith.compareTo(jth) > 0) {
				return true;
			} else {
				return false;
			}
		}

	}

	private void swap(int i, int j) {
		T ith = this.data.get(i);
		T jth = this.data.get(j);
		this.data.set(i, jth);
		this.data.set(j, ith);

	}

	public T removeHP() {
		T rv = this.data.get(0);
		this.swap(0, this.data.size() - 1);
		this.data.remove(this.data.size() - 1);
		this.downheapify(0);
		return rv;
	}

	private void downheapify(int pi) {

		int lci = (2 * pi) + 1;
		int rci = (2 * pi) + 2;

		int maxi = pi;
		if (lci < this.data.size() && this.isHP(lci, maxi)) {
			maxi = lci;
		}

		if (rci < this.data.size() && this.isHP(rci, maxi)) {
			maxi = rci;
		}

		if (maxi != pi) {
			this.swap(maxi, pi);
			this.downheapify(maxi);
		}
	}

	public void display() {
		System.out.println(this.data);
	}

	public int size() {
		return this.data.size();
	}

	public boolean isEmpty() {
		return this.data.size() == 0;

	}
	public  class pair{
		int cost;
		String vtx;
		String psf;
		
	}
	
	
	public void Djiktra(String vtx){
		pair p = new pair();
		p.cost = 0;
		p.vtx = vtx;
		p.psf = "";
		
	}

}
