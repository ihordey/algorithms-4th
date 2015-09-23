package my.union.find;

/**
 * User: ivan
 * fundamentals.dataAbstraction.Date: 9/3/14
 */
public abstract class AbstractUF<V>  implements UF<V>{
  protected Object[] ids;
  protected int count;

	protected AbstractUF(int count) {
		this.ids = new Object[count];
		for (int i = 0; i < count; i++) {
		  ids[i] = i;
		}
	}
}
