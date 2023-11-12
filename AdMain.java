/*
[������ ���θ޴� Ŭ����]

������ �α���(�ڵ�����) ������ ������ �� ������
���ο��� �����ϴ� ����� �� 4����, �� �� �������� �������� ������ ����.

�� �������� ��ȸ
 1) �� ���� ���� ��ȸ
 2) ���Ϻ� ���� ���� ��ȸ
 3) ���պ�(n����) ���� ���� ��ȸ
 4) �ڷΰ���

�� ���� �� ������ ����
 1) ���� ����
  1-1) ���� �ű� ���
  1-2) ���� ���� ����
  1-3) ���� ���� ����
  1-4) �ڷΰ���
 2) ������ ����
  2-1) ���� ��� ����
  2-2) ��ġ ��� ����
  2-3) �ڷΰ���
 3) �ڷΰ���

�� ����(�Ǹſ�) �ý��� ��ȯ

�� ���α׷� ����

*�޼ҵ� ����*

#1 ��~�� ����� �����ϴ� �޼ҵ�

#2 ������ ������� �̵������ִ� �޼ҵ�
*/

import java.util.Scanner;
import java.io.IOException;

class AdMain implements VmMenu
{	
	private static final int AD_SALES = 1;		// �������� ��ȸ
	private static final int AD_SETTING = 2;		// ���� �� ������ ����
	private static final int AD_TOCUSTOM = 3;	// ����(�Ǹſ�) �ý��� ��ȯ
	private static final int AD_EXIT = 4;		// ���α׷� ����(�����ڸ� ����)

	private static int adMenuSel = 0;
	
	@Override
	public void turnOn() throws IOException
	{
		menuDisp();
		menuSelect();
		menuRun();
	}
	
	@Override
	public void menuDisp()
	{
		System.out.println("\n\t[������ �ý���]");
		System.out.println("[1] ���� �� �Ǹ����");
		System.out.println("[2] ���� �� ������ ����");
		System.out.println("[3] �Ǹſ� �ý��� ��ȯ");
		System.out.println("[4] ���α׷� ����\n");
	}
	
	@Override
	public void menuSelect() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		String inputTemp;
		
		boolean mJudge = false;

		do
		{
			System.out.println("�޴��� ������ �ּ���");
			System.out.print("�� ");
			inputTemp = sc.next();
			System.out.println();

			mJudge = false;

			if (inputTemp.equals("1"))
			{
				adMenuSel = AD_SALES;
				return;
			}
			
			else if (inputTemp.equals("2"))
			{
				adMenuSel = AD_SETTING;
				return;
			}
			
			else if (inputTemp.equals("3"))
			{
				adMenuSel = AD_TOCUSTOM;
				return;
			}

			else if (inputTemp.equals("4"))
			{
				adMenuSel = AD_EXIT;
				return;
			}

			else
			{
				System.out.println("�ùٸ� ���� �Է��� �ּ���.");
				System.out.println();
				mJudge = true;
			}
		}
		while (mJudge);
	}
	
	@Override
	public void menuRun() throws IOException
	{
		if (adMenuSel == AD_SALES)
		{
			// �������� ��ȸ
			new AdSales().saleSelect();
		}

		else if (adMenuSel == AD_SETTING)
		{
			// ���� �� ������ ����
			new AdSetting().setSelect();
		}

		else if (adMenuSel == AD_TOCUSTOM)
		{
			// ����(�Ǹſ�) �ý��� ��ȯ
			Serial.fruitSet(); 
			Serial.subSet(); 
			//���ѿ� ���� - �������� �����

			Serial.totahapSet();
			Serial.dailySalesSet();
			Serial.totalPdHuruListSet();
			Serial.pdHuruListSet();
			Serial.fruitCountsSet();
			switchSM();

		}

		else if (adMenuSel == AD_EXIT)
		{	
			// ���α׷� ����(�����ڸ� ����)
			Exit.exit();	
		}
	}

	void switchSM() throws IOException
	{
				Scanner sc = new Scanner(System.in);
				String inputTemp1;
				
				System.out.println("\t[�ǸŸ��]");
				System.out.println();

				System.out.println("�Ǹ� �غ� �Ϸ� �Ǿ����ϱ�? (Y/N)");
				System.out.print("�� ");
				inputTemp1 = sc.next();

				if (inputTemp1.equals("Y") || inputTemp1.equals("y"))
				{
					new VendingMachine().turnOn();	
				}
				else
				{
					turnOn();
				}
	}
}