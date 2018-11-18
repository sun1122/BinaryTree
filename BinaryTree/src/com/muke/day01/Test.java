package com.muke.day01;

/**
 * Test
 * 
 * @author 周家申
 * @date 2018年11月18日
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getGCD(6,30));

	}
	public static int getGCD(int num1, int num2) {
        // 先获得绝对值，保证负数也可以求
        num1 = Math.abs(num1);
        num2 = Math.abs(num2);
        // 先求余数，假定第一个数较大；如果第二个较大，在第二轮调用时会颠倒过来
        int remainder = num1 % num2;
        // 如果为 0，则直接得出
        if (remainder == 0) {
            return num2;
        }
        // 递归调用
        return getGCD(num2, remainder);
    }



	// 最大公约数
	public static int get_gcd(int n1, int n2) {
		int gcd = 0;
		if (n1 < n2) {// 交换n1、n2的值
			n1 = n1 + n2;
			n2 = n1 - n2;
			n1 = n1 - n2;
		}

		if (n1 % n2 == 0) {
			gcd = n2;
		}

		while (n1 % n2 > 0) {
			n1 = n1 % n2;

			if (n1 < n2) {// 交换n1、n2的值
				n1 = n1 + n2;
				n2 = n1 - n2;
				n1 = n1 - n2;
			}

			if (n1 % n2 == 0) {
				gcd = n2;
			}
		}
		return gcd;

	}

}
