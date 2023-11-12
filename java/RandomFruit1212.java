import java.util.*;
import java.io.IOException;


public class RandomFruit1212 
{
	static List<String> huru = new ArrayList<String>(); // ������ �̸��� ������ huru 

	// ������ �߻� ���� �������� ��� �� ���ϵ��� ������ ���� selectedFruits
	public static List<FruitsProducts> selectedFruits = new ArrayList<>(); 
	static List<FruitsProducts> allRandomFruits = new ArrayList<>();
	
	Coating ct = new Coating(); // ���� Ŭ���� �ν��Ͻ�����

	VendingMachine vm = new VendingMachine(); // ����ӽ� �ν��Ͻ� ����

	int[] temp = new int[10];

	public void print()  throws IOException
	{
		if (Sub.sub.get(1).getStock() < 30 && Sub.sub.get(2).getStock() < 1)
		{
			System.out.println("���� ������ ��ġ�� �����մϴ�.");
			System.out.println("�� �̻� �ֹ� �� �� �����ϴ�.");
			System.out.println("��ٱ��Ϸ� �̵��մϴ�.");

			
			ShopingCart cart = new ShopingCart();

			cart.sMenu();
		}
		else if (Sub.sub.get(2).getStock() < 1)
		{
			System.out.println("��ġ�� �����մϴ�.");
			System.out.println("�� �̻� �ֹ� �� �� �����ϴ�.");
			System.out.println("��ٱ��Ϸ� �̵��մϴ�.");

			
			ShopingCart cart = new ShopingCart();

			cart.sMenu();
		}
		else if (Sub.sub.get(1).getStock() < 30)
		{
			System.out.println("������ �����մϴ�.");
			System.out.println("�� �̻� �ֹ� �� �� �����ϴ�.");
			System.out.println("��ٱ��Ϸ� �̵��մϴ�.");
		
			ShopingCart cart = new ShopingCart();

			cart.sMenu();
		}
		else 	
		{
			System.out.println(" \n   ���ϴ� ������ �������ּ���! (size 6 �ʰ� ��)");
			System.out.println("   �� [] ���� ���ڰ� ������ �Դϴ�.");
			System.out.println("  ����������������������������������������������������������������������������������������������������������������������������������������������������������������������");

			for (int i = 0; i < Fruits.fruits.size();) 
			{
				for (int j = 1; Fruits.fruits.size() - i > 0; j++) 
				{
					if (Fruits.fruits.containsKey(j)) 
					{
						temp[i] = j;
						if (Fruits.fruits.get(j).getSize() * Fruits.fruits.get(j).getStock() <= 6)
						{
							System.out.printf("%5d. %s [%d] (ǰ��)", (i + 1), Fruits.fruits.get(j).getName(),
									Fruits.fruits.get(j).getSize());
						} 
						else	
						{
							System.out.printf("%5d. %s [%d] (%d)", (i + 1), Fruits.fruits.get(j).getName(),
									Fruits.fruits.get(j).getSize(), Fruits.fruits.get(j).getStock());
						}
						i++;
						if (i % 4 == 0) 
						{
							System.out.println();
						}
					}
				}
			}

			System.out.println();
			System.out.println("  ����������������������������������������������������������������������������������������������������������������������������������������������������������������������");
			runRd();
		}
	}
	       
    public void runRd() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		Fruits fruits = new Fruits(); // Fruits ��ü ����, ���� ������ ������ ����
		
		while (true) 
		{
			huru.clear(); // ���� ������ ������ ���� ���� �ʵ��� huru �� �ʱ�ȭ
			
			System.out.println("   ���� ���ķ� ��õ�� �����ðڽ��ϱ�?");
			System.out.println("   [1] �� / [2] �ƴϿ�(���θ޴�) ");
			System.out.print("   �� ");
			int choice = sc.nextInt();
			sc.nextLine(); // ���� ���� ó��

			if (choice == 1) 
			{
				Random rd = new Random(); // ���� �ν��Ͻ� ���� 

				int totalSize = 0; // ��µ� ������ ��ü ������ �� �ʱ�ȭ
				int totalPrice = 0; // ��ü ���� ���� �հ� �ʱ�ȭ

				// ��� ������ ���� �ε����� �����ϴ� ����Ʈ �ʱ�ȭ
				List<Integer> availableFruitIndices = new ArrayList();

				
				
				// ���ο� �ڷᱸ���� ��� ���� ��õ�� ���� ������ �߰�
                

				for (int i = 1; i <= fruits.fruits.size(); i++) 
				{
					FruitsProducts fruit = fruits.fruits.get(i);		// availableFruitIndices �� ��ȿ�� ���ϵ��� ��� 
																		// ������ �������� �����ϴµ��� ����� 
					if (fruit.getSize() > 0 && fruit.getStock() > 6)  // ��� 6�� �ʰ��� ���ϸ� ���� �׸��� ����� 0 �̻��� ���� ����
					{
						availableFruitIndices.add(i); // ���� ����� 0 �̻��� ������ �ε����� ����
					}
				}

					 // ���ο� ����: availableFruitIndices�� ��� �ִٸ� ��� ������ ǰ��
					 selectedFruits.clear(); //  huru �� ���������� �����Ǽ� ��µ��� �ʵ��� selectedFruits �� �ʱ�ȭ 

					if (availableFruitIndices.isEmpty())
					{
						System.out.println("\n   ������ ��� �����Ǿ����ϴ�.");
						System.out.println("   ���θ޴��� ���ư��ϴ�.");
						vm.turnOn();
					} 
					else
					{

					while (!availableFruitIndices.isEmpty()) 
					{
						int rdIndex = rd.nextInt(availableFruitIndices.size());
						int rdFruitIndex = availableFruitIndices.get(rdIndex);
						FruitsProducts rdFruit = fruits.fruits.get(rdFruitIndex);
						int fruitSize = rdFruit.getSize();

						// ��ü ������ ���� 6 ������ ���ϸ� ���� ���߿�
						if (totalSize + fruitSize <= 6) 
						{
							selectedFruits.add(rdFruit); // ������ ���� ��Ͽ� �߰�
							totalSize += fruitSize;

							if (rdFruit.getStock() <= 1) 
							{
								// ��� 1�� ���� ���, �ش� ������ �������� �������� �ʵ��� �ε��� ����
								availableFruitIndices.remove(rdIndex);
							}

							totalPrice += rdFruit.getPrice();  //  ���ݵ��� ���Ѵ�.

							if (totalSize == 6) 
							{
								break; // ��ü ������ ���� 6�� �Ǹ� ���� ����
							}
						} 
						else
						{
							availableFruitIndices.remove(rdIndex);
						}

					}
					}

					

					
					// selectedFruits ����Ʈ�� �ִ� ���õ� ���ϵ��� �̸��� huru ����Ʈ�� �߰� 
					for (int i = 0; i < selectedFruits.size(); i++) 
					{
						 FruitsProducts randomFruit = selectedFruits.get(i);
					
						huru.add(randomFruit.getName());
						
					}
					
					// ����ڿ��� �������� ��µ� ���ϰ� �� ������ ������ 
					// ���� ���ݵ��� �ջ��Ͽ� ���� ���� ����ؼ� ������ 
					System.out.println("\n   �������� ��õ�� ����:");
					for (int i = 0; i < selectedFruits.size(); i++) 
					{
						FruitsProducts randomFruit = selectedFruits.get(i);
						System.out.println("   "+ (i + 1) + ". " + randomFruit.getName() + " [" + randomFruit.getSize() + "]");
						// ��õ�� ������ �̸��� ������ ���
					}
					System.out.println("\n   ��ü ����: " + totalPrice + "��"); // ��ü ���� ���
				
					
					// �� ������ ���� �� ���� �ɼ� ���
					while (true)
					{
					
						System.out.println("\n   ���Ͻô� �ɼ� ��ȣ�� �Է��� �ּ���. ");
						System.out.println("   [1] ���� ������ ���� / [2] �ٽ� ��õ �ޱ� / [3] ���θ޴� ");
						System.out.print("   �� ");
						int sugarOption = sc.nextInt();
						sc.nextLine(); // ���� ���� ó��

							if (sugarOption == 1)					
							{		
							// ��� ���� ��õ�� ���� ������ ���ο� �ڷᱸ���� �߰�
							 allRandomFruits.addAll(selectedFruits);
					
							ShopingCart ob = new ShopingCart();
							ob.setHuruPrice(totalPrice);
							ob.setHuruList(huru);
							ob.huruInput();
							
							System.out.println();
							ct.sugarPrint();
						}
						else if (sugarOption == 2)
						{
							

							// selectedFruits�� �ʱ�ȭ
							selectedFruits.clear();

							System.out.println();
							runRd();
						}
						else if (sugarOption == 3)
						{
							vm.turnOn();
						}
						else
							System.out.println("\n  �ùٸ� ��ȣ�� �Է����ּ���!\n");
					}
			} 
			else if (choice == 2)  // 2���� ������ ���θ޴��� �̵�
			{
				System.out.println();
				vm.turnOn();
				
			}
			else
				System.out.println("\n  �ùٸ� ��ȣ�� �Է����ּ���!\n");

		}


	}

	// �ٸ� Ŭ�������� selectedFruits�� ���� �� �� �ֵ��� �޼ҵ� ����
	public List<FruitsProducts> getSelectedFruits() 
	{
    return selectedFruits;
	}

	public static void main(String[] args) throws IOException
	{
        RandomFruit1212 rd12 = new RandomFruit1212();
        rd12.print();
        rd12.runRd();
		rd12.getSelectedFruits();
	}
}
