/*
[���� ��ü�� �������]
*/
import java.io.Serializable;
class FruitsProducts implements Serializable
{
	private String name;	// �̸�
	private int price;		// ����
	private int stock;		// ���
	
	private int size;		// ������
	private int count;      //-- ��� ī���� /������ 0 �ʱ�ȭ 
	private int	addCount;   //-- ���� ���� ī���� /������ ī��Ʈ��ŭ ����

	// �� new!! ��
	private int cTemp;		//-- �ʱ�ȭ�� ���� ī��Ʈ ���Ҹ� ���� ���� 
	private int sTemp;		// �ʱ�ȭ�� ��� ������ ���� �ӽ� ����

	private int tempC;
	private int tempS;

	FruitsProducts(String name, int price, int stock, int size)
	{
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.size = size;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}
	public void setStock(int stock)
	{
		this.stock = stock;
	}
	public void setSize(int size)
	{
		this.size = size;
	}
	public void setAddCount(int addCount)
	{
		this.addCount = addCount;
	}

	// �� new!! ��
	public void setCTemp(int cTemp)
	{
		this.cTemp = cTemp;
	}
		public void setSTemp(int sTemp)
	{
		this.sTemp = sTemp;
	}

		// �� new!! new!!  ��
	public void setTempC(int tempC)
	{
		this.tempC = tempC;
	}
	public void setTempS(int tempS)
	{
		this.tempS = tempS;
	}


	public String getName()
	{
		return name;
	}
	public int getPrice()
	{
		return price;
	}
	public int getStock()
	{
		return stock;
	}
	public int getSize()
	{
		return size;
	}
	public int getAddCount()
	{
		return addCount;
	}

	// �� new!! ��
	public int getCTemp()
	{
		return cTemp;
	}	
	public int getSTemp()
	{
		return sTemp;
	}

		// �� new!! new!!  ��
	public int getTempC()
	{
		return tempC;
	}	
	public int getTempS()
	{
		return tempS;
	}
}