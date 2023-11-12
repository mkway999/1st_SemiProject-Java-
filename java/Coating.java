import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


public class Coating
{	
	int temp = 0;

	int n; // ���� �ɼ� �Է°� 
	
	VendingMachine menu = new VendingMachine(); // ���� �޴� Ŭ���� �ν��Ͻ� ����
	
	static List<String> sugarCoatinList = new ArrayList<String>();
	
	// RandomFruit1212 Ŭ�������� selectedFruits ���� ��������
	//selectedFruits =  �������� ��õ�� ������ huru�� �������  �����ϴ� ����Ʈ
	List<FruitsProducts> selectedFruits = RandomFruit1212.selectedFruits;
	
	static List<Integer> kcList = new ArrayList<Integer>(); //  ��ġ ��� ��� ����Ʈ

	//  �߰� ���� ��� ������ �ڷᱸ��
    static List<Integer> sugarStockList = new ArrayList<Integer>();

	public void sugarPrint() throws IOException
	{

		//System.out.println(sm.subMaterialList.get("��ġ").getSubStock());
		

		System.out.println("     ���Ͻô� ���� ���� �ɼ��� �������ּ���.");
		System.out.println("\n     ���� ���� ������ �� : " + Sub.sub.get(1).getStock());
		System.out.println("  �� (1.���(10g))  (2.����(20g))  (3.�β���(30g))"); 
		System.out.println("  ����������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.print("  �� ");
		


		sugarOrder(); //  �� �̵�
	
	} // sugarPrint() end



	
	// ���� �ֹ�(��� ����)�ϴ� �޼ҵ�

	// 1�� =  10g  �� 1�� �Է��ϸ�  10 ����
	// 2�� =  20g  �� 2�� �Է��ϸ�  20 ����
	// 3�� =  30g  �� 3�� �Է��ϸ�  30 ����
	
	public void sugarOrder() throws IOException 
	{
		Scanner sc = new Scanner(System.in);
    
		while (true)
		{
			n = sc.nextInt();
        
			if (n == 1) 
			{
				Sub.sub.get(1).setStock(Sub.sub.get(1).getStock() - 10);
				sugarCoatinList.add("����");
				sugarStockList.add(10);
				break; 
			} 
			else if (n == 2) 
			{
				Sub.sub.get(1).setStock(Sub.sub.get(1).getStock() - 20);
				sugarCoatinList.add("����");
				sugarStockList.add(20);
				break; 
			}
			else if (n == 3) 
			{
				Sub.sub.get(1).setStock(Sub.sub.get(1).getStock() - 30);
				sugarCoatinList.add("�β���");
				sugarStockList.add(30);
				break; 
			}	
			else 
			{
				System.out.println(">> ��Ȯ�� ���� �Է����ּ���.\n ");
				 sugarPrint();
			}
			
		 }

			// ���� �Է� �� sFinish() �޼ҵ� ȣ��
			 sFinish();

	} // sugarOrder() end
		
		
	// �Է°� * 10 ��ŭ ���� ���� ���
	// �ȳ��� ��� �� �ɼǼ���
	public void sFinish() throws IOException 
	{
		Scanner sc = new Scanner(System.in);
	
		int num;
		

		while (true)
		{	
			
			System.out.printf("\n  (%dg)�� ���� �ɼ��� �����ϼ̽��ϴ�.\n", n*10); 
			System.out.println("  ���ķ� ������ �Ϸ� �Ǿ����ϴ�."); 
			System.out.println("\n  1.�ٽ� ���� 2. ��ٱ��� ���  3. ����ϰ� ���θ޴��� ������");
			System.out.println("  ����������������������������������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.print("  �� ");
			num = sc.nextInt();		 //  ��µ� �ɼ� ����
			System.out.println();

			temp ++;				 // ��ٱ��� ��ҽ� ���Ǵ� ����
	
			if (num == 1) // 1���� ������ ���� �ɼ��� ��ȯ�ϰ� �ٽ� �����Ϸ���.
			{
				Sub.sub.get(1).setStock(Sub.sub.get(1).getStock()+n*10);
				sugarCoatinList.remove(temp-1);
				temp --;
				sugarStockList.clear();
				kcList.clear();
				sugarPrint();

			}
			else if (num == 2) // 2���� ������ ���� �ɼǰ�, ��ġ 1���� �Һ��Ͽ� ��ٱ��Ͽ� ���.
			{	
				for (FruitsProducts randomFruit : selectedFruits)		// selectedFruits �ȿ� �ִ� ���� ��õ�� ���ϵ���
				{														// for ���� ���� �� ���ϵ��� ��� 1���� ����
					int stock = randomFruit.getStock();

					if (stock > 0 && randomFruit.getSize() > 0)
					{
						randomFruit.setStock(stock - 1);
					}
				
				}

				Sub.sub.get(2).setStock(Sub.sub.get(2).getStock()-1);
				kcList.add(1);
				System.out.println("���� ������ �� : " + Sub.sub.get(1).getStock());
				System.out.println("���� ��ġ�� �� : " + Sub.sub.get(2).getStock());
				System.out.println("���� �Ϸ�� ���ķ簡 ��ٱ��Ͽ� �����ϴ�. ");
			
				RCustom huru = new RCustom();	
				huru.temp();

				menu.turnOn(); 
			}
			else if (num == 3) // 3���� ������ ���� �ɼ��� ��ȯ�ϰ�, ���θ޴��� �̵�
			{
				Sub.sub.get(1).setStock(Sub.sub.get(1).getStock()+n*10);
				
				// ��ٱ��� �ʱ�ȭ 
				// temp == 0
				RCustom huru = new RCustom();
				huru.resetHuru();

				ShopingCart cart = new ShopingCart();

				cart.huruList.remove(cart.huruList.size());		// hashmap
				cart.priceList.remove(temp-1);					// ����Ʈ

				sugarCoatinList.remove(temp-1);
				cart.setKeyCounter(cart.huruList.size()+1);

				sugarStockList.clear(); //���� �ʱ�ȭ
				kcList.clear(); // ��ġ �ʱ�ȭ
				
				temp --;

				menu.turnOn();

			}
			else 
			{
				System.out.println(">> ��Ȯ�� ���� �Է����ּ���.\n " );
				
			}

		}
	} // sFinish() end
	
/*
	public static void main(String[] args) throws IOException
	{
		Coating ct =  new Coating();  // CoatingŬ���� �ν��Ͻ� ����
		Sub s = new Sub(); // SubsidiaryMaterial Ŭ���� �ν��Ͻ� ����
		Sub.set(); // sm�� �޼ҵ�

			ct.sugarPrint();
			ct.sugarOrder();
			ct.sFinish();
	}
*/
}
