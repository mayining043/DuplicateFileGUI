package myn;

import java.io.*;
import java.util.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

public class DuplicateFile {
	protected int dcount=0,fcount=0;
	protected Map<String,Vector<File>> map=new HashMap<String,Vector<File>>();
	void run(File file){
		sum=0;cur=0;
		if (!file.isDirectory()){
			System.out.println("输入格式错误,请输入一个目录文件");
			PALETTE.textArea.append("输入格式错误,请输入一个目录文件\n");
			return;
		}
		else{
			System.out.println("扫描中............");
			PALETTE.textArea.append("扫描中............\n");
			dfssum(file);
			dfs(file);
			PALETTE.num.setText("正在展示重复文件：");
			PALETTE.textArea.setText("");
			print();
			PALETTE.num.setText("完成");
		}
		return;
	}
	public int sum=0;
	public int cur=0;
	public void dfssum(File f){
		if(!f.isDirectory())
				sum++;
		else{
				sum++;
				File[] childs = f.listFiles();
				for (int i=0;i<childs.length;i++){
					dfssum(childs[i]);
				}
			}
	}
	public void dfs(File f){
		if(!f.isDirectory()){
			 FileInputStream fis;
			 cur++;
			 PALETTE.progressBar.setValue(cur*100/sum);
			 PALETTE.num.setText((int)cur*100/sum+" %");
			 fcount++;
			try {
				fis = new FileInputStream(f.getAbsolutePath());
				 String md5 = DigestUtils.md5Hex(IOUtils.toByteArray(fis));
				 IOUtils.closeQuietly(fis);
				 if (map.containsKey(md5)){
					 System.out.println("已存在md5 "+md5+" ,正在进一步比较:");
					 PALETTE.textArea.append("已存在md5 "+md5+" ,正在进一步比较:\n"  );
					 Vector<File> vct = map.get(md5);
					 File exsit=vct.get(0);
					 if (compareFile(f,exsit)){
							 System.out.println("两文件相同: "+f.getAbsolutePath()+" == "+exsit.getAbsolutePath());
							 PALETTE.textArea.append("两文件相同: "+f.getAbsolutePath()+" == "+exsit.getAbsolutePath()  +"\n");
							 vct.addElement(f);
						 }
					 else
						 return;
					 }
				 else{
					 Vector<File> temp=new Vector<File>();
					 temp.add(f);
					 map.put( md5,temp);			 
					 System.out.println("记录md5-文件 : "+md5+" s "+f.getName());	
					 PALETTE.textArea.append("记录md5-文件 : "+md5+" s "+f.getName()+"\n");
				 }
				return;
			}catch(Exception e){}
			} 
			else{
				 cur++;
				 PALETTE.progressBar.setValue(cur*100/sum);
				 PALETTE.num.setText((int)cur*100/sum+" %");
				dcount++;
				File[] childs = f.listFiles();
				for (int i=0;i<childs.length;i++){
					dfs(childs[i]);
				}
			}
			
	}
	public void print(){
		System.out.println("-------------------------------------------");
		System.out.println("扫描结束 : 共扫描"+dcount+"个目录文件, "+fcount+"个非目录文件");
		System.out.println("查询结果:");
		PALETTE.textArea.append("-------------------------------------------\n");
		PALETTE.textArea.append("扫描结束 : 共扫描"+dcount+"个目录文件, "+fcount+"个非目录文件\n");
		PALETTE.textArea.append("查询结果:\n");
		int sum=0;
		for(Map.Entry<String, Vector<File>> f : map.entrySet()){
			if(f.getValue().size()>1){
				sum++;
			System.out.println("md5为:"+f.getKey()+"的文件共有"+f.getValue().size()+"个，展示如下：");
			PALETTE.textArea.append("md5为:"+f.getKey()+"的文件共有"+f.getValue().size()+"个，展示如下：\n");
			for(File o:f.getValue()){
				System.out.println(o.toString());
				PALETTE.textArea.append(o.toString()+"\n");
			}
			System.out.println("");
			PALETTE.textArea.append("\n");
			}
		}
		System.out.println("共扫描到"+sum+"个重复文件");
		PALETTE.textArea.append("共扫描到"+sum+"个重复文件"+
		"\n");
	}

	protected boolean compareFile(File  file1,File file2) {
        try{
        	BufferedInputStream inFile1 = new BufferedInputStream(new FileInputStream(file1));
            BufferedInputStream inFile2 = new BufferedInputStream(new FileInputStream(file2));
            //比较文件的长度是否一样
            if(inFile1.available() != inFile2.available()){
            	inFile1.close();
            	inFile2.close();
            	return false;
            }
          //比较文件的具体内容是否一样
            while(inFile1.read() != -1 && inFile2.read() != -1){
                if(inFile1.read() != inFile2.read()){
                	inFile1.close();
                	inFile2.close();
                    return false;
                }
            }
        	inFile1.close();
        	inFile2.close();
            return true; 
        }catch (FileNotFoundException e){
            e.printStackTrace();
            return false;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }
}
