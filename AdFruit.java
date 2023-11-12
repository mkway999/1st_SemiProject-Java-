/*
[���� ����]

���� �� ������ �������� 1) �� �����ϸ� �ش� �ý��� ����

 1) ���� ����
  1-1) ���� �ű� ���
  1-2) ���� ���� ����
  1-3) ���� ���� ����
  1-4) �ڷΰ���

*�޼ҵ� ����*

#1 1-1) ~ 1-3) ����� �����ϴ� �޼ҵ�

#2 ������ ������� �̵������ִ� �޼ҵ�

#3 ���� �ű� ��� �޼ҵ�
#3-1 �ű� ��� ������ȣ(Ű��) ���� �޼ҵ�
#3-2 �ű� ��� ���� �̸� �ߺ� �˻� �޼ҵ�

#4 ���� ������ ���ϴ� ������ �����ϴ� �޼ҵ�
#4-0 4���� ������ ������ ���� ��ҷ� �̵��ϴ� �޼ҵ�
#4-1 �̸�����
#4-2 ���� ����
#4-3 ��� ����
#4-4 ������ ����

#5 ���� ������ ���ϴ� ������ �����ϴ� �޼ҵ�
#5-1 5���� ������ ������ ������ �����ϴ� �޼ҵ�

#6 ���� ���� ��� ����ϴ� �޼ҵ�
*/
import java.util.Scanner;
import java.io.IOException;

class AdFruit extends AdSetting 
{
	//#1
	void frSelect() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int number = 0;			// ���ð� ������ ����
		boolean temp = false;	// �ݺ����� �Ҹ� ����

		System.out.println("\n\t[���� ����]");
		System.out.println("[1] ���� �ű� ���");
		System.out.println("[2] ���� ���� ����");
		System.out.println("[3] ���� ���� ����");
		System.out.println("[4] �ڷΰ���");

		do	// ����ڰ� �����(1~4 ������) �Է��Ҷ����� �ݺ�
		{
			System.out.print("\n������ ����� �����ϼ���. : ");
			try	// �� �� ��� �̻��ϰ� �Է������� ����
			{
				number = sc.nextInt();
				temp = false;	// ����� ������ �� ���� ����
			}
			catch (Exception e)
			{
				System.out.println("\n���Է¿�����");
				System.out.println("1�̻� 4������ ������ �Է��ϼ���.");
				sc.nextLine();
				temp = true;	// �������� temp true�� �ٲ��
			}
		}
		while (temp);			// ����� �� ������ �ݺ�
		frGo(number);
	}// frSelect()

	//#2
	void frGo(int number) throws IOException
	{
		switch (number)
		{
			case 1 : newRegister(); break;	// �ű� ���
			case 2 : edit();break;			// ���� ����
			case 3 : delete();break;		// ���� ����
			case 4 : super.setSelect(); break;	// �ڷΰ��� - ��ӹ��� �θ�(����) �������� ���ư���

			// �������� �Է��ߴµ� 1�̻� 4���ϰ� �ƴ϶��
			default : System.out.println("\n�߸��� �����Դϴ�.");
					System.out.println("1�̻� 4������ ������ �Է��ϼ���.");
					frSelect();
		}
	}// frGo()

	//#3
	void newRegister() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int num = findNum();
		boolean temp = false;
		String name="";
		int price,stock,size;
		price=stock=size=0;
		
		// �̸� �Է�
		System.out.printf("\n������ȣ %d�� ������ ������ �Է��ϼ���.\n",num);
		System.out.print("������ �̸� : ");
		name = sc.next();

		if (check(name))
		{
			System.out.printf("\n�Է��Ͻ� ���� %s�� �̹� �����ϴ� �����Դϴ�.",name);
			System.out.println("���� ���� ���� �ý����� �̿��ϼ���.");
			frSelect();
		}
		else
		{		
			// ���� �Է�
			do
			{
				try
				{
					System.out.print(name + "�� ���� : ");
					price = sc.nextInt();
					temp = false;
				}
				catch (Exception e)
				{
					System.out.println("\n���Է� ������");
					System.out.println("�Է��� ������ Ȯ���ϰ� �ٽ� �Է��ϼ���.");
					sc.nextLine();
					temp = true;
				}
			}
			while (temp);
			
			// ��� �Է�
			do
			{
				try
				{
					System.out.print(name + "�� ���(�ִ� 50��) : ");
					stock = sc.nextInt();
					if (stock<=50)
						temp = false;
					else
					{
						System.out.println("������ �ִ� ��� 50�� �Դϴ�. �ٽ� �Է��ϼ���.");
						temp = true;
					}
				}
				catch (Exception e)
				{
					System.out.println("\n���Է� ������");
					System.out.println("�Է��� ������ Ȯ���ϰ� �ٽ� �Է��ϼ���.");
					sc.nextLine();
					temp = true;
				}
			}
			while (temp);

			// ������ �Է�
			do
			{
				try
				{
					System.out.print(name + "�� ������(1 or 2) : ");
					size = sc.nextInt();	//������
					if (size==1||size==2)
						temp = false;
					else
					{
						System.out.println("������� 1 �Ǵ� 2�� �Է��� �����մϴ�. �ٽ� �Է��ϼ���.");
						temp = true;
					}
				}
				catch (Exception e)
				{
					System.out.println("\n���Է� ������");
					System.out.println("�Է��� ������ Ȯ���ϰ� �ٽ� �Է��ϼ���.");
					sc.nextLine();
					temp = true;
				}
			}
			while (temp);
			
			// �Է��� ���� Ȯ��
			System.out.println("\n�Է��� ������ ������");
			System.out.printf("������ȣ %d�� ",num);
			System.out.print("- �̸�[ " + name + " ]");
			System.out.print(" ����[ " + price + " ]");
			System.out.print(" ���[ " + stock + " ]");
			System.out.print(" ������[ " + size + " ] ");
			System.out.print("�Դϴ�.\n�����Ͻðڽ��ϱ�?(Y/N) : ");
			
			// ���� or ���
			String answer = sc.next();
			if (answer.equals("y")||answer.equals("Y"))
			{
				Fruits.fruits.put(num,new FruitsProducts(name,price,stock,size));
				System.out.println("\n������ ���������� ��ϵǾ����ϴ�.");
			}
			else
				System.out.println("\n���� ����� ����մϴ�.");
			frSelect();
		}
	}// newRegister()
	
	//#3-1
	int findNum() throws IOException
	{
		int num;
		for (num=1; num<=Fruits.fruits.size(); num++)
		{			   //----------- ����ȭ�� ���� ��ü
			if (!Fruits.fruits.containsKey(num))	// 1 ���� ��ü�� Ű���� �ִ��� ã��
			{
				break;	// ������ �ݺ��� Ż��~
			}
		}
		return num;
	}

	//#3-2
	boolean check(String name) throws IOException
	{
		int j=1;
		boolean result = false;
		for (int i=0; i<Fruits.fruits.size();j++)
		{
			if (!Fruits.fruits.containsKey(j))
			{
				continue;
			}
			else
			{
				if (Fruits.fruits.get(j).getName().equals(name))
				{
					result = true;
					break;
				}
				i++;
			}
		}
		return result;
	}

	//#4
	void edit() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int num=-1;
		boolean temp=true;
		printAll();
		do
		{
			try
			{
				System.out.print("\n������ ������ ������ȣ�� �Է��ϼ���.(�ڷΰ����� [0] �Է�) : ");
				num = sc.nextInt();
				if (Fruits.fruits.containsKey(num))
					temp = false;
				else if (num==0)
					temp = false;
				else
				{
					System.out.println("������ȣ�� Ȯ���ϰ� �ٽ� �Է��ϼ���.");
					temp = true;
				}
			}
			catch (Exception e)
			{
				System.out.println("\n���Է� ������");
				System.out.println("������ȣ�� Ȯ���ϰ� �ٽ� �Է��ϼ���.");
				sc.nextLine();
				temp = true;
			}
		}
		while (temp);
		if (num==0)
			frSelect();
		else
			goEdit(num);
	}
	
	//#4-0
	void goEdit(int num) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int yoso=-1;
		boolean temp = true;
		System.out.printf("\n������ ���� [%s]�� ������ ��Ҹ� �����ϼ���.\n",Fruits.fruits.get(num).getName());
		System.out.println("\n[1] �̸�\n[2] ����\n[3] ���\n[4] ������\n[5] �ڷΰ���");
		do
		{
			try
			{
				System.out.print("������ ��� ���� : ");
				yoso = sc.nextInt();
				temp = false;
			}
			catch (Exception e)
			{
				System.out.println("\n���Է� ������");
				System.out.println("������ȣ�� Ȯ���ϰ� �ٽ� �Է��ϼ���.");
				sc.nextLine();
				temp = true;
			}
		}
		while (temp);

		switch (yoso)
		{
			case 1:name(num); break;	//�̸�
			case 2:price(num);break;	//����
			case 3:stock(num);break;	//���
			case 4:size(num);break;		//������
			case 5:edit();break;	//�ڷΰ���
			default:System.out.println("\n���Է¿�����\n1�̻� 5���Ͽ� �ش��ϴ� ������ �Է��ϼ���.");goEdit(num);
		}
	}

	//#4-1
	void name(int num) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\n������ ������ ���Ӱ� ������ �̸��� �Է��ϼ���.");
		System.out.printf("���� �̸� [%s] �� ������ �̸� : ",Fruits.fruits.get(num).getName());
		String newName = sc.next();
		
		//�̸��� �ߺ��̸�
		if (check(newName))
		{
			System.out.println("\n�Է��Ͻ� �̸��� ������ �̹� �����մϴ�.");
			System.out.println("���� �������� ���ư��ϴ�.");
			edit();
		}

		//�̸��� �ߺ��� �ƴϸ�
		else
		{
			System.out.printf("%d�� ���� [%s]�� �̸��� [%s]�� �����Ͻðڽ��ϱ�?(Y/N) : ",num,Fruits.fruits.get(num).getName(),newName);
			String answer = sc.next();
			if (answer.equals("Y")||answer.equals("y"))
			{
				Fruits.fruits.get(num).setName(newName);
				System.out.println("\n������ �Ϸ�Ǿ����ϴ�.");
				edit();
			}
			else
			{
				System.out.println("/n������ ����մϴ�.");
				edit();
			}
		}
	}

	//#4-2
	void price(int num) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\n������ ������ ���Ӱ� ������ ������ �Է��ϼ���.");	
		int newPrice=0;
		boolean temp = true;

		do
		{
			try
			{
				System.out.printf("���� ���� [%d��] �� ������ ���� : ",Fruits.fruits.get(num).getPrice());
				newPrice = sc.nextInt();
				if (newPrice<0)
				{
					System.out.println("0 �̻��� �������·� �ٽ� �Է��ϼ���.");
					temp = true;
				}
				else
					temp = false;
			}
			catch (Exception e)
			{
				System.out.println("\n���Է� ������");
				System.out.println("0 �̻��� �������·� �ٽ� �Է��ϼ���.");
				sc.nextLine();
				temp = true;
			}
		}
		while (temp);

		System.out.printf("%d�� ���� [%s]�� ������ [%d�� �� %d��]���� �����Ͻðڽ��ϱ�?(Y/N) : ",num,Fruits.fruits.get(num).getName(),Fruits.fruits.get(num).getPrice(),newPrice);
		String answer = sc.next();
		if (answer.equals("Y")||answer.equals("y"))
		{
			Fruits.fruits.get(num).setPrice(newPrice);
			System.out.println("\n������ �Ϸ�Ǿ����ϴ�.");
			edit();
		}
		else
		{
			System.out.println("/n������ ����մϴ�.");
			edit();
		}
	}

	//#4-3
	void stock(int num) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\n������ ������ ������ ��� �Է��ϼ���.");	
		int su=0;
		int oldStock=Fruits.fruits.get(num).getStock();
		boolean temp = true;

		do
		{
			try
			{
				System.out.println("\n��� �߰� - ��� �Է� / ��� ���� - ���� �Է�");
				System.out.printf("���� ��� [%d��] �� ������ ��� : ",oldStock);
				su = sc.nextInt();
				if (su<0)
				{
					if (oldStock+su<0)
					{
						System.out.println("���� 0 �̸��� �� �� �����ϴ�.");
						temp = true;
					}
					else
						temp = false;
				}
				else
				{
					if (su>50)
					{
						System.out.println("���� 50���Ϸθ� �Է��� �� �ֽ��ϴ�.");
						temp = true;
					}
					else if (oldStock+su>50)
					{
						System.out.println("���� 50���� �ʰ� �� �� �����ϴ�.");
						temp = true;
					}
					else
						temp = false;
				}
			}
			catch (Exception e)
			{
				System.out.println("\n���Է� ������");
				System.out.println("50������ �������·� �Է��� �� �ֽ��ϴ�.");
				sc.nextLine();
				temp = true;
			}
		}
		while (temp);

		System.out.printf("%d�� ���� [%s]�� ��� [%d�� �� %d��]�� �����Ͻðڽ��ϱ�?(Y/N) : ",num,Fruits.fruits.get(num).getName(),oldStock,oldStock+su);
		String answer = sc.next();
		if (answer.equals("Y")||answer.equals("y"))
		{
			Fruits.fruits.get(num).setStock(oldStock+su);
			System.out.println("\n������ �Ϸ�Ǿ����ϴ�.");
			edit();
		}
		else
		{
			System.out.println("/n������ ����մϴ�.");
			edit();
		}
	}

	//#4-4
	void size(int num) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int newSize=0;
		System.out.printf("\n������ ������ ������� %d�Դϴ�.",Fruits.fruits.get(num).getSize());
		if (Fruits.fruits.get(num).getSize()==1)
			newSize=2;
		else if (Fruits.fruits.get(num).getSize()==2)
			newSize=1;

		System.out.printf("%d�� ���� [%s]�� ����� %d�� �����Ͻðڽ��ϱ�?(Y/N) : ",num,Fruits.fruits.get(num).getName(),newSize);
		String answer = sc.next();
		if (answer.equals("Y")||answer.equals("y"))
		{
			Fruits.fruits.get(num).setSize(newSize);
			System.out.println("\n������ �Ϸ�Ǿ����ϴ�.");
			edit();
		}
		else
		{
			System.out.println("/n������ ����մϴ�.");
			edit();
		}
	}

	//#5
	void delete() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int num=-1;
		boolean temp=true;
		printAll();
		do
		{
			try
			{
				System.out.print("\n������ ������ ������ȣ�� �Է��ϼ���. (�ڷΰ����� [0] �Է�) : ");
				num = sc.nextInt();
				if (num==0)
					break;
				else
				{
					if (Fruits.fruits.containsKey(num))
					temp = false;

					else
					{
						System.out.println("������ȣ�� Ȯ���ϰ� �ٽ� �Է��ϼ���.");
						temp =true;
					}
				}
				
			}
			catch (Exception e)
			{
				System.out.println("\n���Է� ������");
				System.out.println("������ȣ�� Ȯ���ϰ� �ٽ� �Է��ϼ���.");
				sc.nextLine();
				temp = true;
			}
		}
		while (temp);
		if (num==0)
			frSelect();
		else
			goDelete(num);
	}

	//#5-1
	void goDelete(int num) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		String name = Fruits.fruits.get(num).getName();
		int price = Fruits.fruits.get(num).getPrice();
		int stock = Fruits.fruits.get(num).getStock();
		int size = Fruits.fruits.get(num).getSize();

		System.out.println("�����Ͻ� ������ ������");		
		System.out.printf("%2d�� - [%s] %5d�� %3d�� (size %d)",num,name,price,stock,size);
		System.out.print("�Դϴ�.\n�ش� ������ ������ �����Ͻðڽ��ϱ�?(Y/N) : ");

		String answer = sc.next();
		if (answer.equals("Y")||answer.equals("y"))
		{
			Fruits.fruits.remove(num);
			System.out.println("\n������ �Ϸ�Ǿ����ϴ�.");
			frSelect();
		}
		else
		{
			System.out.println("\n������ ����մϴ�.");
			frSelect();
		}
	}

	//#6
	void printAll() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.printf("\n���� ��ϵ� ������ %d�� �Դϴ�.\n",Fruits.fruits.size());
		for (int i=1; i<=Fruits.fruits.size(); )
		{
			for (int j=1; Fruits.fruits.size()-i>=0; j++)
			{
				if (Fruits.fruits.containsKey(j))
				{
					String name = Fruits.fruits.get(j).getName();
					int price = Fruits.fruits.get(j).getPrice();
					int stock = Fruits.fruits.get(j).getStock();
					int size = Fruits.fruits.get(j).getSize();
					System.out.printf("%2d�� - [%s] %5d�� %3d�� (size %d)",j,name,price,stock,size);
					System.out.println();
					i++;
				}
			}
		}
	}// printAll()
}