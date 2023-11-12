import java.io.Serializable;
class SubProducts implements Serializable
{
	private String name;
	private int stock;		// ���
	private int count;		// ��� ī���� /������ 0 �ʱ�ȭ 
	private int	total;	// ���� ī���� /������ ī��Ʈ��ŭ ����
	private int max;

	SubProducts(String name,int stock, int max)
	{
		this.name = name;
		this.stock = stock;
		this.max = max;
	}

	// getter
	public int getStock()
	{
		return stock;
	}
	public String getName()
	{
		return name;
	}
	public int getCount()
	{
		return count;
	}
	public int getTotal()
	{
		return total;
	}
	public int getMax()
	{
		return max;
	}

	// setter
	public void setStock(int stock)
	{
		this.stock = stock;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setCount(int count)
	{
		this.count = count;
	}
	public void setTotal(int total)
	{
		this.total = total;
	}
	public void setMax(int max)
	{
		this.max = max;
	}
}