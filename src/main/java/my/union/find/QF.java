package my.union.find;

/**
 * User: ivan
 * fundamentals.dataAbstraction.Date: 9/3/14
 */
public class QF<V> extends AbstractUF<V> {

	public QF(int count) {
		super(count);
	}

	@Override
	public void union(V fromVal, V toVal) {

	}

	@Override
	public boolean isConnected(V fromVal, V toVal) {
		return fromVal.equals(toVal);
	}

	@Override
	public V find(int id) {
		return (V) ids[id];
	}

	@Override
	public int count() {
		return count;
	}
}
