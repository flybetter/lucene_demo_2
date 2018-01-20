//package com.cn.company.util;
//
//import org.apache.lucene.index.IndexWriter;
//import org.apache.lucene.index.IndexWriterConfig;
//import org.apache.lucene.index.MergePolicy;
//
//import java.io.IOException;
//
//public class IndexThreadUtil {
//	private static IndexWriter indexWriter;
//	static {
//		IndexWriterConfig iwc=new IndexWriterConfig(AnalyzerUtil.getAnalyzer());
//		iwc.setUseCompoundFile(false);
//		MergePolicy mp=iwc.getMergePolicy();
//		mp.setNoCFSRatio(0);
//		iwc.setMergePolicy(mp);
//		iwc.setRAMBufferSizeMB(256.0);
//		try {
//			indexWriter=new IndexWriter(DirectoryThreadUtil.getMMapDirectory(), iwc);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	public static IndexWriter getIndexWriter(){
//		return indexWriter;
//	}
//}
