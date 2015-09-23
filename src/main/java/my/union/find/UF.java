package my.union.find;

/**
 * User: ivan
 * fundamentals.dataAbstraction.Date: 9/3/14
 */

public interface UF<V> {

	void union(V fromVal, V toVal);

	boolean isConnected(V fromVal, V toVal);

	V find(int val);

	int count();
}
