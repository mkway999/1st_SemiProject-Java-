/*
[�������� ��ȸ]

���ο��� ���� �����ϸ� �ش� �ý��� ����

�� �������� ��ȸ
 1) �� ���� ���� ��ȸ
 2) ���Ϻ� ���� ���� ��ȸ
 3) ���պ�(n����) ���� ���� ��ȸ
 4) �ڷΰ���

*�޼ҵ� ����*

#1 1) ~ 4) ����� �����ϴ� �޼ҵ�
#2 
#3 
#4 
*/
import java.util.Scanner;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Collections;
import java.util.Calendar;	
import java.util.InputMismatchException;

class AdSales implements Serializable
{	
	public static Map<LocalDate, List<Integer>> dailySales = new HashMap<>();

	int y;
	int m;
	int d;

	int s = 0;
	int s1 = 0;
	int s2 = 0;
	int s3 = 0;
	int totalSale;

	void saleSelect() throws IOException
	{	
		Scanner sc = new Scanner(System.in);
		int number = 0;			// ���ð� ������ ����
		boolean temp = false;	// �ݺ����� �Ҹ� ����

		System.out.println("\n\t[���� �� �Ǹ����]");
		System.out.println("[1] ���� ��ȸ");
		System.out.println("[2] ���Ϻ� �Ǹ� ���� ��ȸ");
		System.out.println("[3] ���պ� ���ķ� �Ǹ� ���� ��ȸ");
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
		srGo(number);
	}

	void srGo(int number) throws IOException
	{	
		
		AdMain am3 = new AdMain();

		switch (number)
		{
			case 1 : totalSalesInquiry();break;	// �� ���� ��ȸ
			case 2 : fruitsNumOfSales();break;	// ���Ϻ� ���� ��ȸ
			case 3 : combiOfhuru();break;		// ���պ�(n����) ���� ���� ��ȸ
			case 4 : am3.turnOn(); break;	// �ڷΰ���

			// �������� �Է��ߴµ� 1�̻� 4���ϰ� �ƴ϶��
			default : System.out.println("\n�߸��� �����Դϴ�.");
					System.out.println("1�̻� 4������ ������ �Է��ϼ���.");
					saleSelect();
		}
	}

	void totalSalesInquiry() throws IOException	// �� ���� ��ȸ
	{
		//Pay ppay = new Pay();

		//System.out.println("�Ѹ��� " + ppay.gettotahap());
	
		saleCal();

		System.out.println("\n\t[���� ��ȸ]\n");
		
			if (s != 0)
			{
				System.out.printf("������ ��¥: %d-%d-%d\n", y,m,d);
				System.out.println();
				System.out.printf("%d-%d-%d ����: %d��\n", y,m,d,s);
				System.out.println();
			}

			else
			{
				System.out.println("�ش� ��¥�� ���� ���� ������ �����ϴ�.");
			}
	

		
			if (s1 != 0)
			{		
				System.out.printf("%d-%d-%d ����: %d��\n", y,m,d-1,s1 );
				System.out.println();
			}

			else
			{
				System.out.println("�ش� ��¥�� ���� ���� ������ �����ϴ�.");
			}
		
			
			if (s2 != 0)
			{
				System.out.printf("%d-%d-%d ����: %d��\n", y,m,d-2,s2 );
				System.out.println();
			}

			else
			{
				System.out.println("�ش� ��¥�� ���� ���� ������ �����ϴ�.");
			}
		
			
			if (s3 != 0)
			{
				
				System.out.printf("%d-%d-%d ����: %d��\n", y,m,d-3,s3 );
				System.out.println();
			}

			else
			{
				System.out.println("�ش� ��¥�� ���� ���� ������ �����ϴ�.");
			}

			System.out.println("���� ����: " + totalSale+"��");
			System.out.println();
	
			saleSelect();
	}
	
	void fruitsNumOfSales() throws IOException // ���Ϻ� ���� ��ȸ
	{
		Pay ppay = new Pay();
		//System.out.println(ppay.fruitCounts);
		
		System.out.println("\n\t[���Ϻ� �Ǹ� ���� ��ȸ]\n");

		ppay.countFruits();

		ppay.countTotalFruits();
		saleSelect();
	}

	void combiOfhuru() throws IOException	// ���պ� ��ȸ
	{
		Pay.typefru();
		
		saleSelect();
	}

	public void addSale(LocalDate date, int saleAmount) {	// ��¥�� ���� �߰� - pay ���� �߰� ��
        
        if (dailySales.containsKey(date)) {
            
            dailySales.put(date, Collections.singletonList(saleAmount));
        } else {
            
            List<Integer> salesList = new ArrayList<>();
            salesList.add(saleAmount);
            dailySales.put(date, salesList);
        }
	}

	public void printSalesByDate() {						// ��¥�� ���� ��ȸ
        for (Map.Entry<LocalDate, List<Integer>> entry : dailySales.entrySet()) {
            LocalDate date = entry.getKey();
            List<Integer> saleAmounts = entry.getValue();
            int totalSaleAmount = 0;

            for (Integer saleAmount : saleAmounts) {
                totalSaleAmount += saleAmount;
            }

            System.out.println("��¥: " + date + ", �� ����: " + totalSaleAmount);
        }
    }

	public void dateCal()
	{
		Calendar cal = Calendar.getInstance();

		y = cal.get(Calendar.YEAR);
		m = cal.get(Calendar.MONTH)+1;
		d = cal.get(Calendar.DATE);
	}

	public void saleCal()
	{	
		dateCal();

		LocalDate targetDate = LocalDate.of(y, m, d);
		List<Integer> salesForTargetDate = dailySales.get(targetDate);
		
		if (salesForTargetDate != null)
		{
			for (int saleAmount : salesForTargetDate)
			{
				s = saleAmount;
			}
		}
		

		LocalDate targetDate1 = LocalDate.of(y, m, d-1);
		List<Integer> salesForTargetDate1 = dailySales.get(targetDate1);
	
		if (salesForTargetDate1 != null)
		{
			for (int saleAmount : salesForTargetDate1)
			{
				s1 = saleAmount;
			}
		}

		LocalDate targetDate2 = LocalDate.of(y, m, d-2);
		List<Integer> salesForTargetDate2 = dailySales.get(targetDate2);

		if (salesForTargetDate2 != null)
		{
			for (int saleAmount : salesForTargetDate2)
			{
				s2 = saleAmount;
			}
		}

		LocalDate targetDate3 = LocalDate.of(y, m, d-3);
		List<Integer> salesForTargetDate3 = dailySales.get(targetDate3);

		if (salesForTargetDate3 != null)
		{
			for (int saleAmount : salesForTargetDate3)
			{
				s3 = saleAmount;
			}
		}

		totalSale = (s + s1 + s2 + s3);
	}
	
	public void countPrint()
	{	
		Pay ppay = new Pay();

		LocalDate desiredDate = LocalDate.of(2023, 10, 13);


ArrayList<ArrayList<String>> huruListForDesiredDate = ppay.pdHuruList.get(desiredDate);


if (huruListForDesiredDate != null) {
    System.out.println("Values for " + desiredDate + ": " + huruListForDesiredDate);
} else {
    System.out.println("No values found for " + desiredDate);
}
	}
}