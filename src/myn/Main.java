package myn;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		while(true){
		System.out.println("请输入要检查的系统文件目录：");
		Scanner in=new Scanner(System.in);
		DuplicateFile temp = new DuplicateFile();
		File check=new File(in.nextLine());
		temp.run(check);	
		}
	}
}
