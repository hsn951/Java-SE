package com.qst.dms.entity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class AppendObjectOutputStream extends ObjectOutputStream{
	public static File file = null;
	public AppendObjectOutputStream(File file) throws IOException {
		super(new FileOutputStream(file,true));
	}
	
	public void writeStreamHeader() throws IOException {
		if(file!=null) {
			if(file.length()==0) {
				super.writeStreamHeader();
			}else {
				//当文件不为可空时，空实现
				this.reset();
			}
	     }else {
				super.writeStreamHeader();
         }
	}
}