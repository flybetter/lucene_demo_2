//package com.cn.company.util;
//
//import org.apache.lucene.store.MMapDirectory;
//
//import java.io.IOException;
//import java.nio.file.Paths;
//
//public class DirectoryPostUtil {
//	private static MMapDirectory mMapDirectory;
//	static{
//		try {
//			mMapDirectory=new MMapDirectory(Paths.get("/Users/wubingyu/IdeaProjects/365company_demo/BBS/index/post"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//
//	public static MMapDirectory getMMapDirectory(){
//		return  mMapDirectory;
//	}
//}
