package com.muke.day01;

import java.util.Scanner;

/**
 * Main
 * 
 * @author
 * @date 2018年11月18日
 */
public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		Fraction a = new Fraction(in.nextInt(), in.nextInt());

		Fraction b = new Fraction(in.nextInt(), in.nextInt());

		a.print();

		b.print();

		a.plus(b).print();

		a.multiply(b).plus(new Fraction(5, 6)).print();

		a.print();

		b.print();

		in.close();

	}

}

class Fraction {
	/**
	 * 分子
	 */
	private int a;
	/**
	 * 分母
	 */
	private int b;

	Fraction() {

	}

	Fraction(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
    /**
             * 将分数转换为double
     * @return double类型
     */
	double toDouble() {
		return (double) a / b;
	}

	/**
	 * 分数相加
	 * @param r
	 * @return Fraction fraction
	 */
	Fraction plus(Fraction r) {
		Fraction fraction = new Fraction();
		fraction.a = r.a * this.b + this.a * r.b;
		fraction.b = r.b * this.b;
		return fraction;

	}
	/**
	 * 分数相乘
	 * @param r
	 * @return
	 */
	Fraction multiply(Fraction r) {
		Fraction fraction = new Fraction();
		fraction.a = r.a * this.a;
		fraction.b = r.b * this.b;
		return fraction;
	}

	/**
	 * 将自己以“分子/分母”的形式输出到标准输出，并带有回车换行。 如果分数是1/1，应该输出1。
	 * 当分子大于分母时，不需要提出整数部分，即31/30是一个正确的输出
	 */
	void print() {

		if (a == b) {
			System.out.println("1");
			return;
		}

		int gcd = getGcd2(a, b);

		a = a / gcd;
		b = b / gcd;

		System.out.println(a + "/" + b);

	}
	/**
	 * 求最大公约数
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static int getGcd1(int n1, int n2) {
		int gcd = 0;
		// 交换n1、n2的值
		if (n1 < n2) {
			n1 = n1 + n2;
			n2 = n1 - n2;
			n1 = n1 - n2;
		}

		if (n1 % n2 == 0) {
			gcd = n2;
		}

		while (n1 % n2 > 0) {
			n1 = n1 % n2;

			if (n1 < n2) {
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
	/**
	 * 最大公约数 递归
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int getGcd2(int num1, int num2) {
        
        int remainder = num1 % num2;
        
        if (remainder == 0) {
            return num2;
        }
        // 递归调用
        return getGcd2(num2, remainder);
    }

}
